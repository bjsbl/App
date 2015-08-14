package com.app.fragment;

import android.view.View;
import android.widget.AdapterView;

import com.app.api.ServerApi;
import com.app.base.BaseListFragment;
import com.app.model.News;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public class NewsFragment extends BaseListFragment<News> {

    @Override
    public void sendRequest() {
        ServerApi.getNewsList(mHandler);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);
    }

    @Override
    protected String getCacheKey() {
        return "NewsFragment";
    }
}
