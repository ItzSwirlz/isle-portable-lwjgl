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
                "../../../../isle-portable/LEGO1/lego/legoomni/include",
                "../../../../isle-portable/LEGO1/lego/legoomni/include/actions",
                "../../../../isle-portable/util",
                "../../../../SDL/include",
                "../../../../isle-portable/miniwin/include/",
                },

        // Pick a path, just trying to be flexible
        linkpath = {"../../../../", "../../../", "../../../../lib"},
        include = {
                "mxcore.h",
                "mxticklemanager.h",
                "mxtimer.h",
                "mxgeometry.h", //TODO: templates and lists
                "mxomnicreateflags.h",
                "mxomnicreateparam.h",
                "mxstring.h",
                "mxomni.h",
                "legomain.h",
                "mxvideoparam.h",
                "mxvideoparamflags.h",

                // decomp types
                "decomp.h",
                "misc.h",

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
        infoMap.put(new Info("MxS16", "MxU8", "undefined").cast().valueTypes("short"));
        infoMap.put(new Info("MxS32", "MxU16", "MxResult", "LegoResult", "LegoTime", "undefined2", "MxTime").cast().valueTypes("int"));
        infoMap.put(new Info("MxU32", "MxLong", "Uint32", "LegoU32", "MxULong", "undefined4").cast().valueTypes("long"));
        infoMap.put(new Info("LegoFloat", "MxFloat").cast().valueTypes("float"));

        infoMap.put(new Info("MxRect<MxS32>").define().pointerTypes("MxRectInteger"));
        infoMap.put(new Info("MxPoint<MxS32>").define().pointerTypes("MxPointInteger"));
        infoMap.put(new Info("MxSize<MxS32>").define().pointerTypes("MxSizeInteger"));

        infoMap.put(new Info("MxRect<MxS16>").define().pointerTypes("MxRectShort"));
        infoMap.put(new Info("MxPoint<MxS16>").define().pointerTypes("MxPointShort"));
        infoMap.put(new Info("MxSize<MxS16>").define().pointerTypes("MxSizeShort"));

        // TODO: Lists
        infoMap.put(new Info("MxPoint32List", "MxPoint32ListCursor", "MxSize32List", "MxPoint16List", "MxPoint16ListCursor", "MxSize16List", "MxSize32ListCursor", "MxSize16ListCursor", "MxRect16ListCursor", "MxRect16List", "MxRect32ListCursor", "MxRect32List").skip());

        // FIXME: disabled because lazy
        infoMap.put(new Info("PlayMusic").skip());

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

        // TODO: Check this. This may be unnecessary as we include more of miniwin
        infoMap.put(new Info("HWND", "HWND__").define().valueTypes("HWND__"));
        infoMap.put(new Info("HWND_NOTOPMOST", "VOID", "GetDC", "ReleaseDC", "GetMenu", "GetDeviceCaps", "S_OK").skip());

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