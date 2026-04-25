package com.apticstudio.speed_scale_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;

public class SpeedScaleView extends View {

    private Paint linePaint;
    private Paint textPaint;
    private Paint centerPaint;

    private float currentSpeed = 1.0f;
    private final float minSpeed = 0.25f;
    private final float maxSpeed = 4.0f;

    private float lastTouchX;
    private VelocityTracker velocityTracker;
    private Scroller scroller;

    private static final float PIXELS_PER_UNIT = 250f;
    private OnSpeedChangeListener listener;

    public interface OnSpeedChangeListener {
        void onSpeedChanged(float speed);
    }

    public SpeedScaleView(Context context) {
        super(context);
        init(context, null);
    }

    public SpeedScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        // ডিফল্ট ভ্যালু
        int lineColor = Color.WHITE;
        int centerLineColor = Color.parseColor("#EC407A");
        int textColor = Color.WHITE;
        float textSize = 32f;

        // XML থেকে কাস্টম ভ্যালুগুলো পড়া (Safe way)
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SpeedScaleView);
            lineColor = a.getColor(R.styleable.SpeedScaleView_lineColor, lineColor);
            centerLineColor = a.getColor(R.styleable.SpeedScaleView_centerLineColor, centerLineColor);
            textColor = a.getColor(R.styleable.SpeedScaleView_textColor, textColor);
            textSize = a.getDimension(R.styleable.SpeedScaleView_textSize, textSize);
            a.recycle(); // সরাসরি রিসাইকেল করুন, try-finally বা অটো-ক্লোজ দরকার নেই
        }

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(3f);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);

        centerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        centerPaint.setColor(centerLineColor);
        centerPaint.setStrokeWidth(6f);
        centerPaint.setStrokeCap(Paint.Cap.ROUND);

        scroller = new Scroller(context);
    }

    public void setOnSpeedChangeListener(OnSpeedChangeListener listener) {
        this.listener = listener;
    }

    public void setSpeed(float speed) {
        float oldSpeed = currentSpeed;
        this.currentSpeed = Math.max(minSpeed, Math.min(maxSpeed, speed));
        if (oldSpeed != currentSpeed) {
            invalidate();
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        int centerX = w / 2;
        float baselineY = h * 0.65f;

        for (float s = 0.2f; s <= 4.01f; s += 0.1f) {
            float speedToDraw;
            if (s < 0.3f && s > 0.19f) {
                speedToDraw = 0.25f;
            } else {
                speedToDraw = (float) (Math.round(s * 10.0) / 10.0);
            }

            if (speedToDraw < 0.25f || speedToDraw > 4.0f) continue;

            float x = centerX + (speedToDraw - currentSpeed) * PIXELS_PER_UNIT;

            if (x < -100 || x > w + 100) continue;

            float distFromCenter = Math.abs(x - centerX);
            float fadeThreshold = w * 0.40f;
            int alpha = 255;
            if (distFromCenter > fadeThreshold) {
                alpha = (int) (255 * (1.0f - (distFromCenter - fadeThreshold) / (w * 0.10f)));
                alpha = Math.max(0, Math.min(255, alpha));
            }

            boolean isMajor = Math.abs(speedToDraw % 1.0f) < 0.01f;
            float lineHeight;

            if (isMajor) {
                lineHeight = h * 0.45f;
                linePaint.setStrokeWidth(5f);
                textPaint.setAlpha(alpha);
                canvas.drawText(String.format(Locale.US, "%.1fX", speedToDraw), x, h - 8, textPaint);
            } else {
                lineHeight = h * 0.22f;
                linePaint.setStrokeWidth(3f);
            }

            linePaint.setAlpha(alpha);
            canvas.drawLine(x, baselineY, x, baselineY - lineHeight, linePaint);
        }

        centerPaint.setAlpha(255);
        canvas.drawLine(centerX, baselineY - 60, centerX, baselineY - h * 0.70f, centerPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!scroller.isFinished()) scroller.abortAnimation();
                lastTouchX = event.getX();
                return true;

            case MotionEvent.ACTION_MOVE:
                float dx = event.getX() - lastTouchX;
                updateSpeedAndNotify(currentSpeed - (dx / PIXELS_PER_UNIT));
                lastTouchX = event.getX();
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                velocityTracker.computeCurrentVelocity(1000);
                float xVelocity = velocityTracker.getXVelocity();
                scroller.fling((int)(currentSpeed * PIXELS_PER_UNIT), 0, (int)-xVelocity, 0,
                        (int)(minSpeed * PIXELS_PER_UNIT), (int)(maxSpeed * PIXELS_PER_UNIT), 0, 0);
                invalidate();
                if (velocityTracker != null) { velocityTracker.recycle(); velocityTracker = null; }
                performClick();
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            updateSpeedAndNotify(scroller.getCurrX() / PIXELS_PER_UNIT);
            postInvalidate();
        }
    }

    private void updateSpeedAndNotify(float speed) {
        float oldSpeed = currentSpeed;
        currentSpeed = Math.max(minSpeed, Math.min(maxSpeed, speed));
        if (oldSpeed != currentSpeed && listener != null) {
            listener.onSpeedChanged(currentSpeed);
        }
        invalidate();
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}