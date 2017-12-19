package com.zafu.jason.permissiondemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zafu.jason.permissiondemo.common.ContextHolder;
import com.zafu.jason.permissiondemo.databinding.ActivityMainBinding;
import com.zafu.jason.permissiondemo.viewctrl.MainActCtrl;

public class MainAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextHolder.init(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewCtrl(new MainActCtrl(this, binding));
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    String str = (String) msg.obj;
                    Log.i("handleMessage", str);
                    break;
                default:
                    break;
            }
        }
    };



}
