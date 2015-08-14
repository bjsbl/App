package com.app.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.model.News;

import app.com.app.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public class NewsAdapter extends ListAdapter<News> {

    @Override
    protected View getModelView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = getLayoutInflater(parent.getContext()).inflate(R.layout.activity_main, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News news = datas.get(position);
        viewHolder.text.setText(news.getTitle());
        viewHolder.btn.setText(news.getAuthor());
        return convertView;
    }

    private static class ViewHolder {
        @Bind(R.id.button)
        Button btn;
        @Bind(R.id.textView)
        TextView text;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
