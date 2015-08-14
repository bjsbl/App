package com.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.model.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public abstract class ListAdapter<T extends Base> extends BaseAdapter {

    protected ArrayList<T> datas = new ArrayList<T>();
    private LayoutInflater mInflater;

    protected LayoutInflater getLayoutInflater(Context context) {
        if (mInflater == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return mInflater;
    }

    public ArrayList<T> getData() {
        return datas == null ? (datas = new ArrayList<T>()) : datas;
    }

    public void addData(List<T> data) {
        if (datas != null && data != null && !data.isEmpty()) {
            datas.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addItem(T obj) {
        if (datas != null) {
            datas.add(obj);
        }
        notifyDataSetChanged();
    }

    public void addItem(int pos, T obj) {
        if (datas != null) {
            datas.add(pos, obj);
        }
        notifyDataSetChanged();
    }

    public void removeItem(Object obj) {
        datas.remove(obj);
        notifyDataSetChanged();
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        if (datas.size() > 0) {
            return datas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getModelView(position,convertView,parent);
    }

    protected abstract View getModelView(int position, View convertView, ViewGroup parent);
}
