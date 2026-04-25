# SpeedScaleView 🚀

> **This README is available in two versions: [English](#english) and [Bengali](#bengali).**  
> **এই README ফাইলটি দুটি সংস্করণে উপলব্ধ: [ইংরেজি](#english) এবং [বাংলা](#bengali)।**

---

<a name="english"></a>
## English Version

**SpeedScaleView** is a custom Android library that allows you to create beautiful and interactive speedometer or scale views in your app. It is extremely lightweight and easy to customize.

---

### 📸 Preview
Add a screenshot or GIF of your app here:
[SpeedScaleView Preview](https://drive.google.com/file/d/1cCoiwr94SEnDpcu_2uTmg56jIw3k6wnm/view?usp=drive_link)

---

### ⚙️ Installation

To add this library to your project, follow these steps:

#### 1. Add JitPack repository
Add JitPack to your `settings.gradle` file:

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

#### 2. Add dependency
Add the following line to your app module's `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.Aptic-Studio:android-speed-scale-view:v1.0.2'
}
```

---

### 🚀 Usage

#### 1. Add to XML Layout
Use the following code in your `layout.xml` file:

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

### 🎨 Customization (Attributes)

| Attribute | Format | Description |
|-----------|--------|-------------|
| `app:lineColor` | color | Color of the general scale lines. |
| `app:centerLineColor` | color | Color of the middle/main line. |
| `app:textColor` | color | Color of the text below the scale. |
| `app:textSize` | dimension | Size of the text (sp or dp). |

---

### 🛠️ Tech Stack
- **Language:** Java
- **UI:** Custom Canvas Drawing
- **Minimum SDK:** 24+

---

### 📄 License
This project is licensed under the **Apache License 2.0**. See the [LICENSE](LICENSE) file for details.

---

<a name="bengali"></a>
## বাংলা সংস্করণ (Bengali Version)

**SpeedScaleView** হলো একটি কাস্টম অ্যান্ড্রয়েড লাইব্রেরি, যা দিয়ে আপনি আপনার অ্যাপে সুন্দর এবং ইন্টারঅ্যাক্টিভ স্পিডমিটার বা স্কেল ভিউ তৈরি করতে পারবেন। এটি অত্যন্ত হালকা এবং সহজে কাস্টমাইজ করা যায়।

---

### 📸 প্রিভিউ (Preview)
এখানে আপনার অ্যাপের একটি স্ক্রিনশট বা GIF যোগ করুন:
[SpeedScaleView Preview](https://drive.google.com/file/d/1cCoiwr94SEnDpcu_2uTmg56jIw3k6wnm/view?usp=drive_link)

---

### ⚙️ ইন্সটলেশন (Installation)

আপনার প্রজেক্টে এই লাইব্রেরিটি যুক্ত করতে নিচের ধাপগুলো অনুসরণ করুন:

#### ১. JitPack রিপোজিটরি যোগ করুন
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

#### ২. ডিপেন্ডেন্সি যোগ করুন
আপনার অ্যাপ মডিউলের `build.gradle` ফাইলে নিচের লাইনটি যোগ করুন:

```gradle
dependencies {
    implementation 'com.github.Aptic-Studio:android-speed-scale-view:v1.0.2'
}
```

---

### 🚀 ব্যবহার করার নিয়ম (Usage)

#### ১. XML লেআউটে যোগ করুন
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

### 🎨 কাস্টমাইজেশন (Attributes)

| Attribute | Format | Description |
|-----------|--------|-------------|
| `app:lineColor` | color | সাধারণ স্কেল লাইনগুলোর রঙ। |
| `app:centerLineColor` | color | মাঝখানের বা মেইন লাইনের রঙ। |
| `app:textColor` | color | স্কেলের নিচে থাকা টেক্সটের রঙ। |
| `app:textSize` | dimension | টেক্সটের সাইজ (sp বা dp)। |

---

### 🛠️ প্রযুক্তি (Tech Stack)
- **Language:** Java
- **UI:** Custom Canvas Drawing
- **Minimum SDK:** 24+

---

### 📄 লাইসেন্স (License)
এই প্রজেক্টটি **Apache License 2.0** এর অধীনে লাইসেন্সকৃত। বিস্তারিত জানতে [LICENSE](LICENSE) ফাইলটি দেখুন।

---

## 👨‍💻 Developer / ডেভেলপার
This library was created by : **[Aptic Studio](https://github.com/Aptic-Studio)**

- **GitHub**: [https://github.com/Aptic-Studio](https://github.com/Aptic-Studio)
- **Website**: [apticstudio.com](https://apticstudio.com/)
- **Email**: contact.apticstudio@gmail.com


If you have any questions, feel free to contact us.

আপনার যদি কোনো প্রশ্ন থাকে, তবে আমাদের সাথে যোগাযোগ করতে পারেন।
