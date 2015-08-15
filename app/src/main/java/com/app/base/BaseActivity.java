package com.app.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.app.AppManager;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/14 0014.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        setContentView(setLayout());
        ButterKnife.bind(this);
    }

    protected abstract int setLayout();

    protected abstract void initView();
}
