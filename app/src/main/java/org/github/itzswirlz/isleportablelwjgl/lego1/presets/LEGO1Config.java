package org.github.itzswirlz.isleportablelwjgl.lego1.presets;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(value =
@Platform(
        includepath = {"../../../isle-portable/LEGO1/omni/include",
                "../../../isle-portable/LEGO1/",
                "../../../isle-portable/LEGO1/lego/legoomni/include",
                "../../../isle-portable/LEGO1/lego/legoomni/include/actions",
                "../../../isle-portable/util",
                "../../../SDL/include",
                "../../../isle-portable/miniwin/include/",

                "../../../../isle-portable/LEGO1/omni/include",
                "../../../../isle-portable/LEGO1/",
                "../../../../isle-portable/LEGO1/mxdirectx/",
                "../../../../isle-portable/LEGO1/realtime/",
                "../../../../isle-portable/LEGO1/lego/legoomni/include",
                "../../../../isle-portable/LEGO1/lego/legoomni/include/actions",
                "../../../../isle-portable/util",
                "../../../../SDL/include",
                "../../../../isle-portable/miniwin/include/",
                },

        // Pick a path, just trying to be flexible
        linkpath = {"../../../../", "../../../", "../../../../lib"},
        include = {
                "vector.h",
                "legoeventnotificationparam.h",
                "legogamestate.h",
                "legoinputmanager.h",
                "legovideomanager.h",
                "mxcore.h",
                "mxdirectdraw.h",
                "mxdiskstreamcontroller.h",
                "mxdsaction.h",
                "mxdsbuffer.h",
                "mxdsobject.h",
                "mxdssubscriber.h",
                "mxticklemanager.h",
                "mxtimer.h",
                "mxgeometry.h", //TODO: templates and lists
                "mxmisc.h",
                "mxnextactiondatastart.h",
                "mxnotificationparam.h",
                "mxomnicreateflags.h",
                "mxomnicreateparam.h",
                "mxstreamcontroller.h",
                "mxstreamer.h",
                "mxstring.h",
                "mxomni.h",
                "legomain.h",
                "mxpresenter.h",
                "mxpresentationmanager.h",
                "mxtransitionmanager.h",
                "mxvariable.h",
                "mxvideoparam.h",
                "mxvideoparamflags.h",

                // decomp types
                "decomp.h",
                "misc.h",

                "miniwin/bitflags.h",
                "miniwin/ddraw.h",
                "miniwin/windows.h"
        },
        define = {"MINIWIN"},
        link = {"LEGO1"}
),
        target = "org.github.itzswirlz.isleportablelwjgl.lego1.LEGO1"
)
public class LEGO1Config implements InfoMapper {
    @Override
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("MINIWIN").cppTypes().annotations());
        infoMap.put(new Info("LEGO1_EXPORT").cppTypes().annotations());

        // FIXME: append type templates
        infoMap.put(new Info("BOOL", "LegoBool", "MxBool").cast().valueTypes("boolean"));
        infoMap.put(new Info("LegoChar", "MxS8").cast().valueTypes("char"));
        infoMap.put(new Info("BYTE").cast().valueTypes("byte"));
        infoMap.put(new Info("MxS16", "MxU8", "undefined", "WORD").cast().valueTypes("short"));
        infoMap.put(new Info("MxS32", "MxU16", "MxResult", "LegoResult", "LegoTime", "undefined2", "MxTime", "DWORD").cast().valueTypes("int"));
        infoMap.put(new Info("MxU32", "MxLong", "Uint32", "LegoU32", "MxULong", "undefined4", "LONG", "UINT", "HRESULT").cast().valueTypes("long"));
        infoMap.put(new Info("LegoFloat", "MxFloat").cast().valueTypes("float"));
        infoMap.put(new Info("LPSTR").cast().valueTypes("String"));

        infoMap.put(new Info("MxRect<MxS32>").define().pointerTypes("MxRectInteger"));
        infoMap.put(new Info("MxPoint<MxS32>").define().pointerTypes("MxPointInteger"));
        infoMap.put(new Info("MxSize<MxS32>").define().pointerTypes("MxSizeInteger"));

        infoMap.put(new Info("MxRect<MxS16>").define().pointerTypes("MxRectShort"));
        infoMap.put(new Info("MxPoint<MxS16>").define().pointerTypes("MxPointShort"));
        infoMap.put(new Info("MxSize<MxS16>").define().pointerTypes("MxSizeShort"));

        // TODO: Lists
        infoMap.put(new Info("MxDSObjectList", "MxDSSubscriberList", "MxNextActionDataStartList").skip());
        infoMap.put(new Info("MxPoint32List", "MxPoint32ListCursor", "MxSize32List", "MxPoint16List", "MxPoint16ListCursor", "MxSize16List", "MxSize32ListCursor", "MxSize16ListCursor", "MxRect16ListCursor", "MxRect16List", "MxRect32ListCursor", "MxRect32List").skip());

        // FIXME: disabled because lazy
        infoMap.put(new Info("PlayMusic").skip());
        infoMap.put(new Info("LegoVideoManager::SetCursorBitmap", "LegoVideoManager::GetPhonemeList").skip());

        // FIXME: Disabled stuff
        // ---------
        // Excuse: need to figure out vector
        infoMap.put(new Info("MxOmni::GetHDFiles", "MxOmni::GetCDFiles").skip());
        // ---------
        // Excuse: Haven't done SoundManager or VideoManager
        infoMap.put(new Info("LegoOmni::GetVideoManager", "LegoOmni::GetSoundManager").skip());
        // ---------
        // Excuse: broken (for now)
        infoMap.put(new Info("LegoOmni::GetCurrPathInfo").skip());
        infoMap.put(new Info("LegoNotifyList", "LegoNotifyListCursor").skip());
        // Excuse: compiler error with HDC stuff. I don't think we need it anyway
        infoMap.put(new Info("IDirectDrawSurface::GetDC").skip());
        // Excuse: Something with HRESULT type data loss, but this should be fixed eventually
        infoMap.put(new Info("DDCAPS::dwSVBRops").skip());
        // Excuse: Not currently needed, but we should come back to this. Including mxdirectxinfo.h will fix this
        infoMap.put(new Info("MxDirectDraw::CurrentMode").skip());
        // Excuse: haven't done scripts yet (something is a bit weird with how javacpp is generating them)
        infoMap.put(new Info("LegoGameState::m_jukeboxMusic").skip());
        // Excuse: Compiler errors, but ISLE does not need to deal with these.
        infoMap.put(new Info("LegoGameState::History::m_indices").skip());
        infoMap.put(new Info("LegoGameState::History::m_scores").skip());
        infoMap.put(new Info("LegoGameState::ScoreItem::m_scores").skip());
        infoMap.put(new Info("LegoGameState::ScoreItem::m_name").skip());
        infoMap.put(new Info("LegoGameState::Username::m_letters").skip()); // FIXME: Most likely a symptom of some other basic typing issue
        infoMap.put(new Info("LegoGameState::History::FindPlayerInScoreHistory").skip());
        // Excuse: compiler error not needed for isle. Streaming things here are often because of casting
        // and the generator not setting the correct type when it is a pointer
        infoMap.put(new Info("MxDSAction::GetExtra").skip());
        infoMap.put(new Info("MxDSBuffer::Append").skip());
        infoMap.put(new Info("MxDSBuffer::FUN_100c6fa0").skip());
        infoMap.put(new Info("MxDSBuffer::GetBuffer").skip());
        infoMap.put(new Info("MxDSBuffer::SkipToData").skip());
        infoMap.put(new Info("MxStreamer::GetMemoryBlock").skip());

        // Manuevering around SDL stuff
        infoMap.put(new Info("LegoInputManager::GetLastInputMethod").skip());
        infoMap.put(new Info("LegoEventQueue").skip());
        infoMap.put(new Info("SDL_Keycode").cppTypes("int").javaText("int").valueTypes("int"));
        infoMap.put(new Info("LegoInputManager::QueueEvent").javaText("public native void QueueEvent(NotificationId p_id, @Cast(\"MxU8\") short p_modifier, @Cast(\"MxLong\") long p_x, @Cast(\"MxLong\") long p_y, @ByVal int p_key);"));
        infoMap.put(new Info("LegoInputManager::AddKeyboard").javaText("public native void AddKeyboard(@ByVal int p_keyboardID);"));
        infoMap.put(new Info("LegoInputManager::RemoveKeyboard").javaText("public native void RemoveKeyboard(@ByVal int p_keyboardID);"));
        infoMap.put(new Info("LegoInputManager::AddMouse").javaText("public native void AddMouse(@ByVal int p_mouseID);"));
        infoMap.put(new Info("LegoInputManager::RemoveMouse").javaText("public native void RemoveMouse(@ByVal int p_mouseID);"));
        infoMap.put(new Info("LegoInputManager::AddJoystick").javaText("public native void AddJoystick(@ByVal int p_joystickID);"));
        infoMap.put(new Info("LegoInputManager::RemoveJoystick").javaText("public native void RemoveJoystick(@ByVal int p_joystickID);"));
        infoMap.put(new Info("LegoInputManager::HandleTouchEvent").javaText("public native @Cast(\"MxBool\") boolean HandleTouchEvent(@Cast(\"SDL_Event*\") Pointer p_event, @Cast(\"LegoInputManager::TouchScheme\") int p_touchScheme);"));
        infoMap.put(new Info("LegoInputManager::UpdateLastInputMethod").skip());
        infoMap.put(new Info("LegoInputManager::GetNavigationTouchStates").skip());
        infoMap.put(new Info("LegoInputManager::GetNavigationKeyStates").skip());

        // TODO: Check this. This may be unnecessary as we include more of miniwin
        // FIXME: like, check all of it
        infoMap.put(new Info("HWND", "HWND__").valueTypes("HWND").pointerTypes("HWND"));
        infoMap.put(new Info("HWND_NOTOPMOST", "VOID", "GetDC", "ReleaseDC", "GetMenu", "GetDeviceCaps", "S_OK").skip());
        infoMap.put(new Info("HDC", "HDC__").valueTypes("HDC").pointerTypes("HDC"));
        infoMap.put(new Info("HPALETTE", "HPALETTE__").valueTypes("HPALETTE").pointerTypes("HPALETTE"));
        infoMap.put(new Info("LPVOID", "HANDLE").pointerTypes("@Cast(\"void*\") Pointer").cppTypes("void*"));
        infoMap.put(new Info("LPGUID").pointerTypes("@Cast(\"GUID*\") Pointer").cppTypes("GUID*"));
        infoMap.put(new Info("LPRECT").pointerTypes("@Cast(\"RECT*\") Pointer").cppTypes("RECT*"));
        infoMap.put(new Info("LPDDSURFACEDESC").pointerTypes("@Cast(\"DDSURFACEDESC*\") Pointer").cppTypes("DDSURFACEDESC*"));
        infoMap.put(new Info("LPDIRECTDRAW").pointerTypes("@Cast(\"IDirectDraw*\") Pointer").cppTypes("IDirectDraw*"));
        infoMap.put(new Info("LPDIRECTDRAWSURFACE").pointerTypes("@Cast(\"IDirectDrawSurface*\") Pointer").cppTypes("IDirectDrawSurface*"));
        infoMap.put(new Info("LPDIRECTDRAWPALETTE").pointerTypes("@Cast(\"IDirectDrawPalette*\") Pointer").cppTypes("IDirectDrawPalette*"));
        infoMap.put(new Info("LPLOGPALETTE").pointerTypes("@Cast(\"LOGPALETTE*\") Pointer").cppTypes("LOGPALETTE*"));
        infoMap.put(new Info("LPDDSCAPS").pointerTypes("@Cast(\"DDSCAPS*\") Pointer").cppTypes("DDSCAPS*"));
        infoMap.put(new Info("LPDDPIXELFORMAT").pointerTypes("@Cast(\"DDPIXELFORMAT*\") Pointer").cppTypes("DDPIXELFORMAT*"));

        // Enums
        infoMap.put(new Info("LegoOmni::World").enumerate());
        infoMap.put(new Info("MxPresenter::TickleState").enumerate());
        infoMap.put(new Info("MxTransitionManager::TransitionType").enumerate());
        infoMap.put(new Info("MxDSObject::Type").enumerate());
        infoMap.put(new Info("NotificationId").enumerate());
        infoMap.put(new Info("MxStreamer::OpenMode").enumerate());
        infoMap.put(new Info("LegoInputManager::TouchScheme").enumerate());
        infoMap.put(new Info("LegoInputManager::Keys").enumerate());
        infoMap.put(new Info("DDPixelCaps", "DDColorKeyFlags", "DDFlipFlags", "DDCaps2Flags", "DDSCapsFlags", "DDPixelFormatFlags", "DDBLTFXFlags", "PCFlags", "DDBltFlags", "DDLockFlags", "DDBltFastFlags", "DDSCLFlags", "DDSurfaceDescFlags").enumerate());

        // Definition skips
        infoMap.put(new Info("DDCKEY_SRCBLT", "DDFLIP_WAIT", "DDCAPS2_CERTIFIED", "DDPCAPS_8BIT", "DDPCAPS_INITIALIZE", "DDPCAPS_ALLOW256").cppTypes().annotations());
        infoMap.put(new Info("DDBLT_NONE", "DDBLT_KEYSRC", "DDBLT_ROP", "DDBLT_COLORFILL", "DDBLT_WAIT").cppTypes().annotations());
        infoMap.put(new Info("DDPF_ALPHAPIXELS", "DDPF_PALETTEINDEXED8", "DDPF_RGB").cppTypes().annotations());

        infoMap.put(new Info("DDBLTFAST_SRCCOLORKEY", "DDBLTFAST_WAIT").cppTypes().annotations());
        infoMap.put(new Info("DDLOCK_SURFACEMEMORYPTR", "DDLOCK_WAIT", "DDLOCK_WRITEONLY", "DDLOCK_READONLY").cppTypes().annotations());

        infoMap.put(new Info("DDSCL_FULLSCREEN", "DDSCL_ALLOWREBOOT", "DDSCL_NORMAL", "DDSCL_EXCLUSIVE").cppTypes().annotations());
        infoMap.put(new Info("DDSD_CAPS", "DDSD_HEIGHT", "DDSD_WIDTH", "DDSD_ZBUFFERBITDEPTH", "DDSD_BACKBUFFERCOUNT", "DDSD_PIXELFORMAT").cppTypes().annotations());
        infoMap.put(new Info("DDSCAPS_BACKBUFFER", "DDSCAPS_COMPLEX", "DDSCAPS_FLIP", "DDSCAPS_OFFSCREENPLAIN", "DDSCAPS_PRIMARYSURFACE", "DDSCAPS_SYSTEMMEMORY", "DDSCAPS_TEXTURE", "DDSCAPS_3DDEVICE", "DDSCAPS_VIDEOMEMORY", "DDSCAPS_ZBUFFER").cppTypes().annotations());
        infoMap.put(new Info("PC_NONE", "PC_NOCOLLAPSE", "D3DPAL_READONLY", "D3DPAL_RESERVED").cppTypes().annotations());
        infoMap.put(new Info("DDERR_UNSUPPORTED", "DDERR_GENERIC", "DDERR_INVALIDPARAMS", "DDERR_OUTOFMEMORY", "DD_OK", "DDENUMRET_OK").cppTypes().annotations());
        infoMap.put(new Info("DDBLTFX_NOTEARING").cppTypes().annotations());

        // DD errors
        // there's probably a better way to do this but i just can't figure it out, even with line patterns
        infoMap.put(new Info("DDERR_ALREADYINITIALIZED", "DDERR_CANNOTATTACHSURFACE", "DDERR_CANNOTDETACHSURFACE", "DDERR_EXCEPTION", "DDERR_HEIGHTALIGN", "DDERR_INCOMPATIBLEPRIMARY", "DDERR_INVALIDCAPS", "DDERR_INVALIDCLIPLIST", "DDERR_CURRENTLYNOTAVAIL", "DDERR_NODC", "DDERR_WRONGMODE", "DDERR_NOTPALETTIZED", "DDERR_IMPLICITLYCREATED", "DDERR_INVALIDMODE", "DDERR_INVALIDOBJECT", "DDERR_INVALIDPIXELFORMAT", "DDERR_INVALIDRECT", "DDERR_LOCKEDSURFACES").cppTypes().annotations());
        infoMap.put(new Info("DDERR_NO3D", "DDERR_NOALPHAHW", "DDERR_NOCLIPLIST", "DDERR_NOCOLORCONVHW", "DDERR_NOCOOPERATIVELEVELSET", "DDERR_NOCOLORKEY", "DDERR_NOCOLORKEYHW", "DDERR_NOEXCLUSIVEMODE", "DDERR_NOFLIPHW", "DDERR_NOGDI", "DDERR_NOMIRRORHW", "DDERR_NOTFOUND", "DDERR_NOOVERLAYHW", "DDERR_NORASTEROPHW", "DDERR_NOROTATIONHW", "DDERR_NOSTRETCHHW", "DDERR_NOT4BITCOLOR", "DDERR_NOT4BITCOLORINDEX", "DDERR_NOT8BITCOLOR", "DDERR_NOTEXTUREHW", "DDERR_NOVSYNCHW", "DDERR_NOZBUFFERHW").cppTypes().annotations());
        infoMap.put(new Info("DDERR_NOZOVERLAYHW", "DDERR_OUTOFCAPS", "DDERR_OUTOFVIDEOMEMORY", "DDERR_OVERLAYCANTCLIP", "DDERR_OVERLAYCOLORKEYONLYONEACTIVE", "DDERR_PALETTEBUSY", "DDERR_COLORKEYNOTSET", "DDERR_SURFACEALREADYATTACHED", "DDERR_SURFACEALREADYDEPENDENT", "DDERR_SURFACEBUSY", "DDERR_SURFACEISOBSCURED", "DDERR_SURFACELOST", "DDERR_SURFACENOTATTACHED", "DDERR_TOOBIGHEIGHT", "DDERR_TOOBIGSIZE", "DDERR_TOOBIGWIDTH", "DDERR_UNSUPPORTEDFORMAT", "DDERR_UNSUPPORTEDMASK", "DDERR_VERTICALBLANKINPROGRESS", "DDERR_WASSTILLDRAWING").cppTypes().annotations());
        infoMap.put(new Info("DDERR_XALIGN", "DDERR_INVALIDDIRECTDRAWGUID", "DDERR_DIRECTDRAWALREADYCREATED", "DDERR_NODIRECTDRAWHW", "DDERR_PRIMARYSURFACEALREADYEXISTS", "DDERR_NOEMULATION", "DDERR_REGIONTOOSMALL", "DDERR_CLIPPERISUSINGHWND", "DDERR_NOCLIPPERATTACHED", "DDERR_NOHWND", "DDERR_HWNDSUBCLASSED", "DDERR_HWNDALREADYSET", "DDERR_NOPALETTEATTACHED", "DDERR_NOPALETTEHW", "DDERR_BLTFASTCANTCLIP", "DDERR_NOBLTHW", "DDERR_NODDROPSHW", "DDERR_OVERLAYNOTVISIBLE", "DDERR_NOOVERLAYDEST", "DDERR_INVALIDPOSITION", "DDERR_NOTAOVERLAYSURFACE").cppTypes().annotations());
        infoMap.put(new Info("DDERR_EXCLUSIVEMODEALREADYSET", "DDERR_NOTFLIPPABLE", "DDERR_CANTDUPLICATE", "DDERR_NOTLOCKED", "DDERR_CANTCREATEDC").cppTypes().annotations());

        infoMap.put(new Info("MAKE_HRESULT").cppTypes("long", "long", "long", "long"));
        infoMap.put(new Info("MAKE_DDHRESULT").cppTypes("long", "long"));
//        infoMap.put(new Info().linePatterns("^.*DDERR.*$").cppTypesskip());
    }
}



/*
 * Backup in case we try to make all of LEGO1 bindable
 */

//@Properties(value =
//@Platform(
//        includepath = {"../../../../isle-portable/LEGO1/omni/include",
//                "../../../../isle-portable/LEGO1/lego/sources/3dmanager",
//                "../../../../isle-portable/util",
//                "../../../../isle-portable/LEGO1/lego/legoomni/include",
//                "../../../../isle-portable/LEGO1/realtime",
//                "../../../../isle-portable/LEGO1/tgl",
//                "../../../../isle-portable/LEGO1/lego/sources/misc",
//                "../../../../isle-portable/LEGO1/lego/sources/roi",
//                "../../../../isle-portable/LEGO1/viewmanager",
//                "../../../../isle-portable/LEGO1/mxdirectx"},
//        linkpath = {"../../../../isle-portable-lwjgl"},
//        include = {
//                // have LEGO1_EXPORT in them
//                "legoanimationmanager.h",
//                "legobuildingmanager.h",
//                "legogamestate.h",
////                "legoinputmanager.h", broken...
//                "legomain.h",
//                "legomodelpresenter.h",
//                "legopartpresenter.h",
//                "legoplantmanager.h",
//                "legoroi.h",
//                "legotypes.h",
//                "legovideomanager.h",
//                "legoworldpresenter.h",
//                "misc.h",
//                "mxatom.h",
//                "mxbackgroundaudiomanager.h",
//                "mxcore.h",
//                "mxdirectdraw.h",
//                "mxdsaction.h",
//                "mxdsfile.h",
//                "mxmisc.h",
//                "mxomnicreateflags.h",
//                "mxomnicreateparam.h",
//                "mxomni.h",
//                "mxstring.h",
//                "mxstreamer.h",
//                "mxtimer.h",
//                "mxtransitionmanager.h",
//                "mxutilities.h",
////                "mxvariabletable.h", ddoes somthing weird here
//                "mxvideoparam.h",
//                "mxvideoparamflags.h",
//                "realtimeview.h",
//                "viewmanager.h",
//
//                // extras/dependencies.
//                "legoentitypresenter.h",
//                "legophoneme.h",
//                "legophonemelist.h",
//                "legosoundmanager.h",
//                "legotraninfo.h",
//                "legotypes.h",
//                "lodlist.h",
////                "matrix.h",   Handle classes with numbers in name
//                "mxcompositepresenter.h",
//                "mxdsbuffer.h",
//                "mxdssource.h",
//                "mxgeometry.h",
//                "mxlist.h",
//                "mxmediapresenter.h",
//                "mxnotificationparam.h",
//                "mxtypes.h",
//                "mxvariable.h",
//                "orientableroi.h",
//                "roi.h",
//                "tgl.h",
//                "viewlodlist.h",
//                "viewroi.h",
//        },
//        link = {"LEGO1"}
//),
//        target = "org.github.itzswirlz.isleportablelwjgl.LEGO1Library"
//)
//public class LegoOneConfig implements InfoMapper {
//    @Override
//    public void map(InfoMap infoMap) {
//        infoMap.put(new Info("LEGO1_EXPORT").cppTypes().annotations());
//
//
//        infoMap.put(new Info("BOOL", "LegoBool", "MxBool").cast().valueTypes("boolean"));
//        infoMap.put(new Info("LegoChar", "MxS8").cast().valueTypes("char"));
//        infoMap.put(new Info("MxS16", "MxU8").cast().valueTypes("short"));
//        infoMap.put(new Info("MxU32", "MxLong", "Uint32", "LegoU32", "MxULong", "undefined4").cast().valueTypes("long"));
//        infoMap.put(new Info("MxS32", "MxU16", "MxResult", "LegoResult", "LegoTime").cast().valueTypes("int"));
//        infoMap.put(new Info("LegoFloat", "MxFloat").cast().valueTypes("float"));
//    }
//}