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
        /*findAndHookMethod("klb.android.GameEngine", lpparam.classLoader, "isSuBinaryPresent", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called before the clock was updated by the original method
                param.setResult(false);
            }
            //@Override
            //protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            //    // this will be called after the clock was updated by the original method
            //}
        });*/
        findAndHookMethod("klb.android.GameEngine.GameEngineActivity", lpparam.classLoader, "isSuBinaryPresent",  XC_MethodReplacement.returnConstant(false));
        XposedBridge.log("LoveLiveSIFPatcher Inited.");
    }
    /*
	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
		if(!resparam.packageName.equals(PACKAGE_ESF)){
			return;
		}

		XModuleResources modRes = XModuleResources.createInstance(modulePath, resparam.res);
        resparam.res.setReplacement(PACKAGE_ESF, "public", "cam_snap_0", modRes.fwd(R.raw.killed));
        resparam.res.setReplacement(PACKAGE_ESF, "public", "cam_snap_1", modRes.fwd(R.raw.killed));
        resparam.res.setReplacement(PACKAGE_ESF, "public", "cam_snap_2", modRes.fwd(R.raw.killed));
        resparam.res.setReplacement(PACKAGE_ESF, "public", "cam_snap_3", modRes.fwd(R.raw.killed));
		//resparam.res.setReplacement(PACKAGE_ESF, "string", "multi_select", modRes.fwd(R.string.multi_select));
		//resparam.res.setReplacement(PACKAGE_ESF, "string", "long_click_to_open_menu", modRes.fwd(R.string.long_click_to_open_menu));


	}
	*/

}
