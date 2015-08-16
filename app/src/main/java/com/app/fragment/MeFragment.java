package com.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.base.BaseFragment;

import app.com.app.R;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/16 0016.
 */
public class MeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_information, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
