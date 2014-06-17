package com.misodengaku.lovelivesifpatcher.patcher;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class LoveLiveSIFPatcher implements IXposedHookLoadPackage{

	private static final String PACKAGE_ESF = "klb.android.lovelive";


    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(PACKAGE_ESF))
            return;

        findAndHookMethod("klb.android.GameEngine.GameEngineActivity", lpparam.classLoader, "isSuBinaryPresent",  XC_MethodReplacement.returnConstant(false));
        XposedBridge.log("isSuBinaryPresent hooked.");
    }

}
