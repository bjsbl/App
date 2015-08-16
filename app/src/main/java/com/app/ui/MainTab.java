package com.app.ui;

/**
 * Created by Administrator on 2015/8/16 0016.
 */
public class MainTab {
    private int index;
    private int resName;
    private int resIcon;
    private Class<?> tabClass;

    public MainTab(int index, int resName, int resIcon, Class<?> tabClass) {
        this.index = index;
        this.resName = resName;
        this.resIcon = resIcon;
        this.tabClass = tabClass;
    }

    public int getIndex() {
        return index;
    }

    public int getResName() {
        return resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public Class<?> getTabClass() {
        return tabClass;
    }
}
