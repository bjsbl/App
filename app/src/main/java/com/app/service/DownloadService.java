package com.app.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.app.AppConfig;

/**
 * Created by Administrator on 2015/8/15 0015.
 */
public class DownloadService extends Service {

    private NotificationManager mNotificationManager;
    private String downloadUrl;
    private String mTitle = "正在下载%s";
    private Context mContext = this;
    public static final String BUNDLE_KEY_DOWNLOAD_URL = "download_url";
    public static final String BUNDLE_KEY_TITLE = "title";
    private String saveFileName = AppConfig.DEFAULT_SAVE_FILE_PATH;
    private DownloadBinder binder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        downloadUrl = intent.getStringExtra(BUNDLE_KEY_DOWNLOAD_URL);
        saveFileName = saveFileName + downloadUrl;
        mTitle = String.format(mTitle, intent.getStringExtra(BUNDLE_KEY_TITLE));
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new DownloadBinder();
        mNotificationManager = (NotificationManager) getSystemService(android.content.Context.NOTIFICATION_SERVICE);
    }

    public class DownloadBinder extends Binder {

    }
}
