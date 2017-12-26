package com.zafu.jason.permissiondemo.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.zafu.jason.permissiondemo.R;
import com.zafu.jason.permissiondemo.databinding.ActOkthhpDemoBinding;
import com.zafu.jason.permissiondemo.viewctrl.OkhttpDemoCtrl;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/26$ 10:10$
 * <p/>
 */
public class OkhttpDemoAct extends Activity {
    private OkhttpDemoCtrl       viewCtrl;
    private ActOkthhpDemoBinding binding;
    private int                  mheight;
    private Button               button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.act_okthhp_demo);
        binding.setViewCtrl(new OkhttpDemoCtrl());
      /*  button = findViewById(R.id.fload_content);
        binding.topHeader.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            boolean isdown = true;

            @Override
            public void onGlobalLayout() {
                mheight = binding.topHeader.getHeight();
                binding.swipeTarget.setOnScollChangedListener(new ObservableScrollView.OnScollChangedListener() {
                    @Override
                    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                        if (y - oldy > 0) {
                            isdown = true;
                        } else {
                            isdown = false;
                        }
                        if (y <= 0) {

                        } else if (y > 0 && y <= mheight) {
                            int[] location = new int[2];
                            binding.topHeader.getLocationOnScreen(location);
                            WidgetController.setLayout(button, 0,y);

                        } else {
                                WidgetController.setLayout(button, 0, y);
                        }
                    }
                });
            }
        });*/
    }
}
