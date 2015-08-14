package com.app.base;

import android.os.AsyncTask;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.adapter.ListAdapter;
import com.app.model.Base;
import com.app.util.StringUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public abstract class BaseListFragment<T extends Base> extends BaseFragment implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {

    protected ListView mListView;
    protected ListAdapter<T> mAdapter;
    private ParserTask mParserTask;


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    protected abstract String getCacheKey();

    protected AsyncHttpResponseHandler mHandler = new AsyncHttpResponseHandler() {

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBytes) {
            BaseApplication.putToLastRefreshTime(getCacheKey(), StringUtils.getCurTimeStr());
            mParserTask = new ParserTask(responseBytes);
            mParserTask.execute();
        }

        @Override
        public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
        }
    };

    private List<T> parseList(InputStream is) throws Exception {
        List<T> list = null;
        try {

        } catch (NullPointerException e) {
            list = new ArrayList<T>();
        }
        return list;
    }

    protected boolean compareTo(List<? extends Base> data, Base enity) {
        int s = data.size();
        if (enity != null) {
            for (int i = 0; i < s; i++) {
                if (enity.getId() == data.get(i).getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void executeOnLoadDataSuccess(List<T> data) {
        if (data == null) {
            data = new ArrayList<T>();
        }
        mAdapter.clear();

        for (int i = 0; i < data.size(); i++) {
            if (compareTo(mAdapter.getData(), data.get(i))) {
                data.remove(i);
                i--;
            }
        }
        mAdapter.addData(data);
        mAdapter.notifyDataSetChanged();
    }

    class ParserTask extends AsyncTask<Void, Void, String> {

        private final byte[] reponseData;
        private boolean parserError;
        private List<T> list;

        public ParserTask(byte[] data) {
            this.reponseData = data;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                list = parseList(new ByteArrayInputStream(reponseData));
            } catch (Exception e) {
                e.printStackTrace();
                parserError = true;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (parserError) {
                executeOnLoadDataSuccess(list);
            } else {
                executeOnLoadDataSuccess(list);
            }
        }
    }

    public abstract void sendRequest();
}
