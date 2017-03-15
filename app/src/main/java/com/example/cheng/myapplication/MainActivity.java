package com.example.cheng.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cqyanyu.AppUpdateInfo;
import com.cqyanyu.AutoUpdate;
import com.cqyanyu.CPCheckUpdateCallback;
import com.cqyanyu.UICheckUpdateCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自动更新
        AutoUpdate.uiUpdateAction(this, new UICheckUpdateCallback() {
            @Override
            public void onCheckComplete() {

            }
        });

    }
    public void cpUpdateCheck(View view){
        //手动检测版本
        AutoUpdate.cpUpdateCheck(this, new CPCheckUpdateCallback() {
            @Override
            public void onCheckUpdateCallback(AppUpdateInfo appUpdateInfo) {

            }
        });
    }
}
