package com.sevtinge.cemiuiler.module.powerkeeper

import com.github.kyuubiran.ezxhelper.EzXHelper
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.ObjectUtils
import com.sevtinge.cemiuiler.module.base.BaseHook

object CustomRefreshRate : BaseHook() {
    override fun init() {
        val result1 = PowerKeeperDexKit.mPowerKeeperResultMethodsMap!!["fucSwitch"]
            result1!!.filter { it.isMethod }.map {
                it.getMethodInstance(EzXHelper.safeClassLoader).createHook {
                    before { param ->
                        ObjectUtils.setObject(param.thisObject, "mIsCustomFpsSwitch", "true")
                        // setObject(param.thisObject, "fucSwitch", true)
                        // val qwq = getObjectOrNull(param.thisObject, "mIsCustomFpsSwitch")
                        // Log.i("hook mIsCustomFpsSwitch success, its:$qwq")
                    }
                }
            }
    }
}
