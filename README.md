# Mono Schwarz Raster QWERTZ Launcher

Original Android launcher project. Package: `de.monoschwarz.raster`.

## Implemented source
- Portrait-first 61.8% display / 38.2% controls in the available app content area.
- Dark, Light and Minimalist themes; independent LISTEN / TYPE / PLAY mode selector.
- TYPE: German QWERTZ launcher search and a separately registered Android InputMethodService (enable via Android Settings > Keyboard). Basic shift, ALT number/symbol layers, umlauts, ß, delete, enter and space.
- LISTEN: Native Android active MediaSession metadata and playback transport controls, when user enables notification listener access in Android Settings.
- PLAY: Game Hub discovers apps tagged as games by Android. Controller surface is UI only for third-party games; universal injection is not supported.
- App drawer, app launching, search, basic persisted preferences, dialler and home/back controls.
- No external APIs, internet permission, advertising or analytics SDK.

## Build
Open the project folder in Android Studio with JDK 17+, Android SDK 36, and Gradle/AGP 8.10.1 support. Sync and build. The supplied project does not include a Gradle wrapper.

## Important limitations
This source update has **not** been compiled or device-tested. Do not treat it as a release-ready APK. The original design reference is included; pixel-perfect matching is not guaranteed. Game controls cannot control arbitrary third-party games. User-defined favourites, recent games, editable shortcuts, full emoji picker, media artwork and media progress are not yet implemented. The Android power menu and screen lock require additional supported platform permissions or device controls.
