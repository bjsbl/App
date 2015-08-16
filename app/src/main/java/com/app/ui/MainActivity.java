package com.app.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.app.AppManager;
import com.app.base.BaseApplication;
import com.app.fragment.IndexFragment;
import com.app.fragment.MeFragment;

import java.util.Vector;
import java.util.logging.Handler;

import app.com.app.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/15 0015.
 */
public class MainActivity extends FragmentActivity implements OnTabChangeListener {

    @Bind(android.R.id.tabhost)
    FragmentTabHost tabhost;
    private Handler exitHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppManager.getAppManager().addActivity(this);
        initTabs();
        tabhost.setCurrentTab(0);
        tabhost.setOnTabChangedListener(this);
        tabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
    }


    private void initTabs() {
        MainTab a = new MainTab(0, R.string.main_tab_name_a, R.drawable.bar_icon, IndexFragment.class);
        MainTab b = new MainTab(0, R.string.main_tab_name_b, R.drawable.bar_icon, MeFragment.class);
        MainTab c = new MainTab(0, R.string.main_tab_name_c, R.drawable.bar_icon, MeFragment.class);
        Vector<MainTab> tabs = new Vector<MainTab>();
        tabs.add(a);
        tabs.add(b);
        tabs.add(c);
        for (MainTab t : tabs) {
            TabHost.TabSpec tab = tabhost.newTabSpec(getString(a.getResName()));
            View indicator = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            title.setText(getString(a.getResName()));
            Drawable drawable = this.getResources().getDrawable(a.getResIcon());
            tab.setIndicator(indicator);
            tabhost.addTab(tab,t.getTabClass(),null);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            BaseApplication.showToastLong(R.string.tip_double_click_exit);
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onTabChanged(String tabId) {

    }
}
