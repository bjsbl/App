package com.app.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.api.ServerApi;
import com.app.base.BaseActivity;
import com.app.base.BaseApplication;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import app.com.app.R;

/**
 * Created by Administrator on 2015/8/15 0015.
 */
public class LoginActivity extends BaseActivity {

    EditText usernameTxt;
    EditText passwordTxt;
    Button loginBtn;

    @Override
    protected void initView() {
        loginBtn.setOnClickListener(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_login:
                loginHandler();
                break;
            default:
                break;
        }
    }

    private void loginHandler(){
        String username = usernameTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        ServerApi.login(username,password,handler);
    }

    AsyncHttpResponseHandler handler = new AsyncHttpResponseHandler(){

        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {

        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            BaseApplication.showToastShort(R.string.tip_login_error_for_network);
        }
    };

}
