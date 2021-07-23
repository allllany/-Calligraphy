app下build文件夹删了，缓存文件太占空间。

配置文件build.gradle(app)(部分)

```java
android {
    compileSdkVersion 29
    buildToolsVersion '29.0.2'
    defaultConfig {
        applicationId "com.example.ts.news"
        minSdkVersion 21
        targetSdkVersion 26

        ndk {
            abiFilters "armeabi-v7a", "arm64-v8a", "x86", "x86_64"
        }



        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

        lintOptions {
            abortOnError
        }

    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    sourceSets {
        main { assets.srcDirs = ['src/main/assets', 'src/main/assets/']
            jniLibs.srcDirs = ['src/main/jniLibs']
        }


    }
    aaptOptions {
        noCompress = ['.unity3d', '.ress', '.resource', '.obb']
    }
    packagingOptions {
        doNotStrip '*/armeabi-v7a/*.so'
        doNotStrip '*/x86/*.so'
    }
}
```

