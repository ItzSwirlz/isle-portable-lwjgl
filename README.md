# isle-portable-lwjgl
Java frontend for isle-portable (attempt)

# Caveats
- In your submodule clone of isle-portable, you'll need to adjust things to make it work with JavaCPP. These were:
  1) Commenting out the GetLastInputMethod, since currently as far as I know there is no handling for "auto" type
  2) Commenting out `enum class SDL_KeyboardID_v` and the other `enum class`'s with no members
  3) Commenting out the m_lastInputMethod field

- I'm on macOS where `p_back` is a predefined thing on the system, so for `Lego3DManager::SetFrustrum` in the header I renamed it to `p_bback`

These eventually should be taken care of and properly handled.
- You need to run IsleApp with a pointer to the *same* SDL dynamic library built by passing it to `-Dorg.lwjgl.sdl.libname`.

# This repo is setup primarily for my use, but feel free to contribute
Apologies about this, but it is my first time working with JNI stuff at all.
