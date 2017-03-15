package com.cqyanyu;

import android.content.Context;
import android.widget.Toast;

import com.baidu.autoupdatesdk.AppUpdateInfoForInstall;
import com.baidu.autoupdatesdk.BDAutoUpdateSDK;


/**
 * Created by cheng on 2016/7/11.
 */
public class AutoUpdate {

    /**
     * 默认UI自动更新
     *
     * @param context
     * @param callback
     */
    public final static void uiUpdateAction(Context context, final UICheckUpdateCallback callback) {
        BDAutoUpdateSDK.uiUpdateAction(context, callback);
    }

    /**
     * 版本检测
     *
     * @param context
     * @param callback
     */
    public static void cpUpdateCheck(final Context context, final CPCheckUpdateCallback callback) {
        BDAutoUpdateSDK.cpUpdateCheck(context, new com.baidu.autoupdatesdk.CPCheckUpdateCallback() {
            @Override
            public void onCheckUpdateCallback(com.baidu.autoupdatesdk.AppUpdateInfo appUpdateInfo, AppUpdateInfoForInstall appUpdateInfoForInstall) {
                if (appUpdateInfo == null) {
                    Toast toast = Toast.makeText(context, "已是最新版本了", Toast.LENGTH_LONG);
                    toast.show();
                    callback.onCheckUpdateCallback(null);
                } else {
                    AppUpdateInfo updateInfo = new AppUpdateInfo();
                    updateInfo.setAppName(appUpdateInfo.getAppSname());
                    updateInfo.setSize(appUpdateInfo.getAppSize());
                    updateInfo.setVersionCode(appUpdateInfo.getAppVersionCode());
                    updateInfo.setVersionName(appUpdateInfo.getAppVersionName());
                    callback.onCheckUpdateCallback(updateInfo);
                    BDAutoUpdateSDK.uiUpdateAction(context, new com.baidu.autoupdatesdk.UICheckUpdateCallback() {
                        @Override
                        public void onCheckComplete() {

                        }
                    });
                }

            }
        });
    }


}
