package org.github.itzswirlz.isleportablelwjgl;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(value =
@Platform(
        includepath = {"/Users/jpeisach/isle-portable/LEGO1/omni/include",
                "/Users/jpeisach/isle-portable/LEGO1/lego/sources/3dmanager",
                "/Users/jpeisach/isle-portable/util",
                "/Users/jpeisach/isle-portable/LEGO1/lego/legoomni/include",
                "/Users/jpeisach/isle-portable/LEGO1/lego/legoomni/include/actions",
                "/Users/jpeisach/isle-portable/LEGO1/realtime",
                "/Users/jpeisach/isle-portable/LEGO1/tgl",
                "/Users/jpeisach/isle-portable/LEGO1/",
                "/Users/jpeisach/isle-portable/LEGO1/lego/sources",
                "/Users/jpeisach/isle-portable/LEGO1/lego/sources/misc",
                "/Users/jpeisach/isle-portable/LEGO1/lego/sources/roi",
                "/Users/jpeisach/isle-portable/LEGO1/viewmanager",
                "/Users/jpeisach/isle-portable/LEGO1/mxdirectx",
                "/Users/jpeisach/isle-portable/miniwin/include/miniwin",
                "/Users/jpeisach/isle-portable/miniwin/include",
                "/Users/jpeisach/isle-portable/build/_deps/sdl3-src/include"},
        linkpath = {"/Users/jpeisach/isle-portable-lwjgl"},
        include = {
                // contains LEGO1_EXPORT
                "legoanimationmanager.h",
                "legobuildingmanager.h",
                "legogamestate.h",
              //  "legoinputmanager.h" breaks generator, this will be done manually
                "legomain.h",
                "legomodelpresenter.h",
                "legopartpresenter.h",
                "legoplantmanager.h",
//                "legoroi.h", manual, bc then it needs roi craziness
                "legotypes.h",
                "legovideomanager.h",
                "legoworldpresenter.h",
                "misc.h",
                "mxatom.h",
                "mxbackgroundaudiomanager.h",
                "mxcore.h",
                "mxdirectdraw.h",
                "mxdsaction.h",
                "mxdsfile.h",
                "mxmisc.h",
                "mxomnicreateflags.h",
                "mxomnicreateparam.h",
                "mxomni.h",
                "mxstring.h",
                "mxstreamer.h",
                "mxtimer.h",
                "mxtransitionmanager.h",
                "mxutilities.h",
                //"mxvariabletable.h", TODO: stl/types/stuff
                "mxvideoparam.h",
                "mxvideoparamflags.h",
                "realtimeview.h",
                "viewmanager.h",


                // these are dependencies that dont export anything and are lightweight

                // Required dependency for LegoBackgroundColor
                "mxvariable.h",

                // Required for mxdssfile
                "mxdssource.h",
                "mxdsbuffer.h",

                // legopartpresenter
                "mxmediapresenter.h",
                "mxpresenter.h",

                // legowroldprresenter
                "legoentitypresenter.h",
                "mxcompositepresenter.h",

                // miniwin
                "windows.h",

                // viewmanager
                "viewroi.h",

                // ugh
//                "mxgeometry.h", will do mxrect32 manually

                // decomp types
                "decomp.h"
        },
        link = {"LEGO1"}
),
        target = "org.github.itzswirlz.isleportablelwjgl.LEGO1"
)
public class LegoOneConfig implements InfoMapper {
    @Override
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("LEGO1_EXPORT").cppTypes().annotations());
        infoMap.put(new Info("HDC__*").pointerTypes("HDC"));
        infoMap.put(new Info("HDC").valueTypes("HDC__").pointerTypes("@Cast(\"HDC__*\") PointerPointer", "@ByPtrPtr HDC__*"));

        infoMap.put(new Info("HWND__*").pointerTypes("HWND"));
        infoMap.put(new Info("HWND").valueTypes("HWND__").pointerTypes("@Cast(\"HWND__*\") PointerPointer", "@ByPtrPtr HWND__* "));

        infoMap.put(new Info("HMENU__*").pointerTypes("HMENU"));
        infoMap.put(new Info("HMENU").valueTypes("HMENU__").pointerTypes("@Cast(\"HMENU__*\") PointerPointer", "@ByPtrPtr HMENU__* "));


        infoMap.put(new Info("BOOL", "LegoBool", "MxBool").cast().valueTypes("boolean"));
        infoMap.put(new Info("LegoChar", "MxS8").cast().valueTypes("char"));
        infoMap.put(new Info("MxS16", "MxU8", "undefined").cast().valueTypes("short"));
        infoMap.put(new Info("MxS32", "MxU16", "MxResult", "LegoResult", "LegoTime", "undefined2").cast().valueTypes("int"));
        infoMap.put(new Info("MxU32", "MxLong", "Uint32", "LegoU32", "MxULong", "undefined4").cast().valueTypes("long"));
        infoMap.put(new Info("LegoFloat", "MxFloat").cast().valueTypes("float"));
    }
}




/*
 * Backup in case we try to make all of LEGO1 bindable
 */

//@Properties(value =
//@Platform(
//        includepath = {"/Users/jpeisach/isle-portable/LEGO1/omni/include",
//                "/Users/jpeisach/isle-portable/LEGO1/lego/sources/3dmanager",
//                "/Users/jpeisach/isle-portable/util",
//                "/Users/jpeisach/isle-portable/LEGO1/lego/legoomni/include",
//                "/Users/jpeisach/isle-portable/LEGO1/realtime",
//                "/Users/jpeisach/isle-portable/LEGO1/tgl",
//                "/Users/jpeisach/isle-portable/LEGO1/lego/sources/misc",
//                "/Users/jpeisach/isle-portable/LEGO1/lego/sources/roi",
//                "/Users/jpeisach/isle-portable/LEGO1/viewmanager",
//                "/Users/jpeisach/isle-portable/LEGO1/mxdirectx"},
//        linkpath = {"/Users/jpeisach/isle-portable-lwjgl"},
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