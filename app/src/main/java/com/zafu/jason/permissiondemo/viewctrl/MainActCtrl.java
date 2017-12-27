package com.zafu.jason.permissiondemo.viewctrl;

import android.Manifest;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zafu.jason.permissiondemo.MainAct;
import com.zafu.jason.permissiondemo.common.AndroidUtil;
import com.zafu.jason.permissiondemo.common.PermissionsUtil;
import com.zafu.jason.permissiondemo.databinding.ActivityMainBinding;
import com.zafu.jason.permissiondemo.ui.OkhttpDemoAct;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/4$ 10:32$
 * <p/>Description: {@link com.zafu.jason.permissiondemo.MainAct}
 */
public class MainActCtrl {
    private ObservableField<Integer> flag = new ObservableField<>(1);
    private ActivityMainBinding binding;
    private MainAct             activity;
    private Handler             handler;

    public MainActCtrl(MainAct activity, ActivityMainBinding binding) {
        this.binding = binding;
        this.activity = activity;
        handler = activity.handler;
    }

    public void resetPM(View view) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        /*rxPermissions.request(new String[]{Manifest.permission.CAMERA}).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.i("RxPermissions", "" + aBoolean);
            }
        });*/
       /* rxPermissions.requestEach(new String[]{Manifest.permission.WRITE_SETTINGS,Manifest.permission.CAMERA}).subscribe(new Consumer<Permission>() {
            @Override
            public void accept(Permission permission) throws Exception {
                Log.i("Permission",permission.toString());
                if (permission.granted){

                }
            }
        });*/
        rxPermissions.ensure(new String[]{Manifest.permission.CAMERA});
    }

    public void rxjavaTest() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });
        observable.subscribe(new Observer<Integer>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                Log.i("onSubscribe", d.toString());
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                Log.i("onSubscribe", mDisposable.toString());
                Log.i("onSubscribe", value.toString());
                if (value == 2) {
                    Log.d("onNext", "dispose");
                    mDisposable.dispose();
                    Log.d("onNext", "isDisposed : " + mDisposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.i("onError", "onError");
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.i("onComplete", "onComplete");
            }
        });
    }

    public void rxJavaThread() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.i("Observable", "Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                for (int i = 0; ; i++) {
                    e.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i("accept", integer + "");
                        binding.wtf.setText("" + integer);
                        Log.i("Observer", "Observer thread is : " + Thread.currentThread().getName());
                    }
                });
    }

    public ObservableField<Integer> getFlag() {
        return flag;
    }

    private int temp = 0;
    private Looper looper;

    public void onClickBaseProvider(View view) {
        PermissionsUtil.requestPermissions(new String[]{Manifest.permission.READ_SMS,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA});
        /* final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                looper = Looper.myLooper();
                Looper.loop();
                try {
                    sleep(1000);
                    Message message = new Message();
                    message.what = 1002;
                    message.obj = temp + "@@@1002";
                    handler.sendMessage(message);

                    temp++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        });

        thread.start();*/
    }

    public void onClickLooperTest(View view) {
        Log.i("LooperTest", Looper.myLooper().getThread().getName());
        looper.quit();
    }

    public void onClickActOkhttp(View view) {
        Intent intent = new Intent(AndroidUtil.getActivity(view), OkhttpDemoAct.class);
        AndroidUtil.getActivity(view).startActivity(intent);
    }


}
