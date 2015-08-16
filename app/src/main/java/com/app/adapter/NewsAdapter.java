package com.app.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
            convertView = getLayoutInflater(parent.getContext()).inflate(R.layout.list_cell_news, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News news = datas.get(position);
        viewHolder.title.setText(news.getTitle());
        viewHolder.description.setText(news.getAuthor());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_title)
        TextView title;
        @Bind(R.id.tv_description)
        TextView description;
        @Bind(R.id.tv_time)
        TextView time;
        @Bind(R.id.iv_link)
        ImageView link;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
