# SpeedScaleView 🚀

**SpeedScaleView** হলো একটি কাস্টম অ্যান্ড্রয়েড লাইব্রেরি, যা দিয়ে আপনি আপনার অ্যাপে সুন্দর এবং ইন্টারঅ্যাক্টিভ স্পিডমিটার বা স্কেল ভিউ তৈরি করতে পারবেন। এটি অত্যন্ত হালকা এবং সহজে কাস্টমাইজ করা যায়।

---

## 📸 প্রিভিউ (Preview)
এখানে আপনার অ্যাপের একটি স্ক্রিনশট বা GIF যোগ করুন:
[SpeedScaleView Preview](https://drive.google.com/file/d/1cCoiwr94SEnDpcu_2uTmg56jIw3k6wnm/view?usp=drive_link)

---

## ⚙️ ইন্সটলেশন (Installation)

আপনার প্রজেক্টে এই লাইব্রেরিটি যুক্ত করতে নিচের ধাপগুলো অনুসরণ করুন:

### ১. JitPack রিপোজিটরি যোগ করুন
আপনার প্রজেক্টের `settings.gradle` ফাইলে JitPack যোগ করুন:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories { 
        google() 
        mavenCentral()
        maven { url 'https://jitpack.io' } 
    } 
}
```

### ২. ডিপেন্ডেন্সি যোগ করুন
আপনার অ্যাপ মডিউলের `build.gradle` (Module: app) ফাইলে নিচের লাইনটি যোগ করুন:

```gradle
dependencies {
    implementation 'com.github.Aptic-Studio:android-speed-scale-view:v1.0.2'
}
```

---

## 🚀 ব্যবহার করার নিয়ম (Usage)

### ১. XML লেআউটে যোগ করুন
আপনার `layout.xml` ফাইলে নিচের কোডটি ব্যবহার করুন:

```xml
<com.apticstudio.speed_scale_view.SpeedScaleView 
    android:id="@+id/speedScaleView" 
    android:layout_width="match_parent" 
    android:layout_height="200dp" 
    app:lineColor="#FFFFFF" 
    app:centerLineColor="#EC407A" 
    app:textColor="#FFFFFF" 
    app:textSize="14sp" />
```

---

## 🎨 কাস্টমাইজেশন (Attributes)

| Attribute | Format | Description |
|-----------|--------|-------------|
| `app:lineColor` | color | সাধারণ স্কেল লাইনগুলোর রঙ। |
| `app:centerLineColor` | color | মাঝখানের বা মেইন লাইনের রঙ। |
| `app:textColor` | color | স্কেলের নিচে থাকা টেক্সটের রঙ। |
| `app:textSize` | dimension | টেক্সটের সাইজ (sp বা dp)। |

---

## 🛠️ প্রযুক্তি (Tech Stack)
- **Language:** Java
- **UI:** Custom Canvas Drawing
- **Minimum SDK:** 24+

---

## 📄 লাইসেন্স (License)
এই প্রজেক্টটি **Apache License 2.0** এর অধীনে লাইসেন্সকৃত। বিস্তারিত জানতে [LICENSE](LICENSE) ফাইলটি দেখুন।

---

## 👨‍💻 ডেভেলপার
This library was created by : **[Aptic Studio](https://github.com/Aptic-Studio)**

- **GitHub**: [https://github.com/Aptic-Studio](https://github.com/Aptic-Studio)
- **Website**: [apticstudio.com](https://apticstudio.com/)
- **Email**: contact.apticstudio@gmail.com

আপনার যদি কোনো প্রশ্ন থাকে, তবে আমাদের সাথে যোগাযোগ করতে পারেন।
