package com.app.api;

import com.app.base.BaseApplication;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public class ApiClient {

    public static String getUserAgent(BaseApplication appContext) {
        StringBuilder ua = new StringBuilder("");
        ua.append('/' + appContext.getPackageInfo().versionName + '_'
                + appContext.getPackageInfo().versionCode);// app版本信息
        ua.append("/Android");// 手机系统平台
        ua.append("/" + android.os.Build.VERSION.RELEASE);// 手机系统版本
        ua.append("/" + android.os.Build.MODEL); // 手机型号
        ua.append("/" + appContext.getAppId());// 客户端唯一标识
        return ua.toString();
    }
}
