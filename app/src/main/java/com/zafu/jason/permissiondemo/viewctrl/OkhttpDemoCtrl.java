package com.zafu.jason.permissiondemo.viewctrl;

import android.util.Log;
import android.view.View;

import com.zafu.jason.permissiondemo.common.utils.StringEmojiFilter;
import com.zafu.jason.permissiondemo.viewmodel.OkhttpDemoMV;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/26$ 10:11$
 * <p/>{@link com.zafu.jason.permissiondemo.ui.OkhttpDemoAct}
 */
public class OkhttpDemoCtrl {
    private OkhttpDemoMV viewModel;

    public OkhttpDemoCtrl() {
        viewModel = new OkhttpDemoMV();
    }

    public void onclickConnect(View view) {
        Log.i("StringEmojiFilter", StringEmojiFilter.containsEmoji(viewModel.getTextSubmit()) + "");
    }

    public OkhttpDemoMV getViewModel() {
        return viewModel;
    }
}
