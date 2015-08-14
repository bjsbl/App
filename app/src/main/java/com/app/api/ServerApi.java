package com.app.api;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public class ServerApi {

    public static void getNewsList(AsyncHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        ApiHttpClient.get("action/api/news_list", params, handler);
    }
}
