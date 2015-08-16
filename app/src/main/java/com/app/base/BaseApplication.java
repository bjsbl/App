package com.app.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.AppConfig;
import com.app.util.StringUtils;

import java.util.UUID;

import app.com.app.R;

/**
 * Created by Administrator on 2015/8/13 0013.
 */
public class BaseApplication extends Application {
    private static Context context;
    private static String LAST_REFRESH_TIME = "last_refresh_time.pref";
    private static String PREF_NAME = "creativelocker.pref";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static synchronized BaseApplication context() {
        return (BaseApplication) context;
    }

    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

    public String getAppId() {
        String uniqueID = getProperty(AppConfig.CONF_APP_UNIQUEID);
        if (StringUtils.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            setProperty(AppConfig.CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }

    public String getProperty(String key) {
        String res = AppConfig.getAppConfig(this).get(key);
        return res;
    }

    public void setProperty(String key, String value) {
        AppConfig.getAppConfig(this).set(key, value);
    }

    public static SharedPreferences getPreferences(String prefName) {
        return context().getSharedPreferences(prefName, Context.MODE_MULTI_PROCESS);
    }

    public static SharedPreferences getPreferences() {
        return getPreferences(PREF_NAME);
    }

    public static void putToLastRefreshTime(String key, String value) {
        SharedPreferences preferences = getPreferences(LAST_REFRESH_TIME);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        apply(editor);
    }

    public static void apply(SharedPreferences.Editor editor) {
        editor.commit();
    }

    public static void showToastShort(int message) {
        showToast(context().getString(message), Toast.LENGTH_SHORT, 0);
    }

    public static void showToastLong(int message) {
        showToast(context().getString(message), Toast.LENGTH_LONG, 0);
    }

    public static void showToast(String message, int duration, int icon) {
        View view = LayoutInflater.from(context()).inflate(
                R.layout.view_toast, null);
        ((TextView) view.findViewById(R.id.title_tv)).setText(message);
        if (icon != 0) {
            ((ImageView) view.findViewById(R.id.icon_iv))
                    .setImageResource(icon);
            view.findViewById(R.id.icon_iv)
                    .setVisibility(View.VISIBLE);
        }
        Toast toast = new Toast(context());
        toast.setView(view);
        toast.setGravity(Gravity.BOTTOM, 0, 35);
        toast.setDuration(duration);
        toast.show();
    }
}
