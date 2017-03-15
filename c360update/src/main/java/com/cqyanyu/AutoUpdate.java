package com.cqyanyu;

import android.content.Context;

import com.qihoo.updatesdk.lib.UpdateHelper;


/**
 * Created by cheng on 2016/7/11.
 */
public class AutoUpdate {
    static boolean isInit = false;

    /**
     * 默认UI自动更新
     *
     * @param context
     * @param callback
     */
    public final static void uiUpdateAction(Context context, final UICheckUpdateCallback callback) {
        if (!isInit) {
            UpdateHelper.getInstance().init(context, context.getResources().getColor(context.getResources().getIdentifier("colorPrimary", "color", context.getPackageName())));
            isInit = true;
        }

        UpdateHelper.getInstance().autoUpdate(context.getPackageName());
        callback.onCheckComplete();
    }

    /**
     * 版本检测
     *
     * @param context
     * @param callback
     */
    public static void cpUpdateCheck(final Context context, final CPCheckUpdateCallback callback) {
        if (!isInit) {
            UpdateHelper.getInstance().init(context, context.getResources().getColor(context.getResources().getIdentifier("colorPrimary", "color", context.getPackageName())));
            isInit = true;
        }
        UpdateHelper.getInstance().manualUpdate(context.getPackageName());
        callback.onCheckUpdateCallback(null);
    }


}
