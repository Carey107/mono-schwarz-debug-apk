# Build Mono Schwarz APK online (no local installation)

This project includes a GitHub Actions workflow at `.github/workflows/android-apk.yml`.
It builds a debug APK on a GitHub-hosted runner using JDK 17, Gradle 8.11.1 and Android SDK 36.

## Steps

1. Create a **private** repository on GitHub.
2. Upload the contents of this project folder to the repository root (the `app`, `design`, `.github` folders and the root Gradle files).
3. Commit the files to the `main` branch.
4. Open the repository's **Actions** tab.
5. Select **Build Mono Schwarz Android APK**.
6. Click **Run workflow** if the workflow has not already started after the first push.
7. Open the completed workflow run.
8. Under **Artifacts**, download `mono-schwarz-debug-apk`.
9. Extract the downloaded artifact ZIP. It contains `app-debug.apk`.
10. Upload `app-debug.apk` to a browser-based Android emulator that accepts APK uploads.

## Build notes

- This produces a **debug APK**, suitable for preview/testing, not a signed Play Store release.
- No Android Studio, JDK, Gradle or Android SDK needs to be installed on your laptop.
- GitHub Actions must be permitted by your employer's device/network policies. Do not upload employer-owned or confidential code to a personal repository without permission.
- If the build fails, open the workflow run, expand the failed step, and share the error log. Do not assume the APK was generated.
