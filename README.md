# Android System Message Log With Threading -APK

Copyright Kris Occhipinti 2022-12-09

(https://filmsbykris.com)

License GPLv3

# What's it do?
Minimal Code example for Android to print messages to the system log which can be viewed with logcat

# setup
Based on the following tutorial
https://proandroiddev.com/how-to-setup-android-sdk-without-android-studio-6d60d0f2812a

- Get Android SDK Command line tools https://developer.android.com/studio
```bash
wget "https://dl.google.com/android/repository/commandlinetools-linux-9123335_latest.zip" -O /tmp/commandlinetools.zip
mkdir ~/android
cd ~/android
unzip /tmp/commandlinetools.zip
cd cmdline-tools
mkdir tools
mv -i * tools

#run the following and add it to your shell's rc file
export ANDROID_HOME=$HOME/android
export PATH=$ANDROID_HOME/cmdline-tools/tools/bin/:$PATH
export PATH=$ANDROID_HOME/emulator/:$PATH
export PATH=$ANDROID_HOME/platform-tools/:$PATH
```
- Install the sdk
```bash
sdkmanager --list
#change version if needed
yes|sdkmanager --install "platform-tools" "platforms;android-29" "build-tools;29.0.2"

#if you don't need the emulator you can save a lot of space by deleting it
rm -fr ../emulator
```

- To change icon replace 'app/src/main/res/mipmap/ic_launcher.png'

- Build and Install It
```bash
./gradlew build && adb install app/build/outputs/apk/debug/app-debug.apk
```

# Speical Notes
If you get an error, it may be do to the version of Java you Are running.
Try JDK 11
```bash
#change Default JDK
sudo update-alternatives --config java
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export PATH=$PATH:$JAVA_HOME
```

# Once Compiled and Installed
- Watch for logs using adb and then start the app on the phone
```bash
   adb shell logcat|grep "FilmsByKris" 
```

