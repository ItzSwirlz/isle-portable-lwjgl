# isle-portable-lwjgl
Java frontend for isle-portable (attempt)

# Caveats
- While SDL is initialized in Java, it is not initialized on the C side of things in LEGO1. As a result, you'll need to manually add a SDL_Init line to LegoOmni::CreateInstance, otherwise it won't be able to get the window handle.
- You need to run IsleApp with a pointer to the *same* SDL dynamic library built by passing it to `-Dorg.lwjgl.sdl.libname`.

# This repo is setup primarily for my use, but feel free to contribute
Apologies about this, but it is my first time working with JNI stuff at all.
