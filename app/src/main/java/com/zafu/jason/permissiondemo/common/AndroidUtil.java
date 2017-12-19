package com.zafu.jason.permissiondemo.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/4$ 14:03$
 * <p/>
 */
public class AndroidUtil {
    /**
     * 通过 View 获取Activity
     */
    public static Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) view.getRootView().getContext();
    }
}
