package com.zafu.jason.permissiondemo.viewmodel;

import android.databinding.BaseObservable;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/27$ 10:34$
 * <p/>
 */
public class OkhttpDemoMV extends BaseObservable {
    private String textSubmit;

    public String getTextSubmit() {
        return textSubmit;
    }

    public void setTextSubmit(String textSubmit) {
        this.textSubmit = textSubmit;
    }
}
