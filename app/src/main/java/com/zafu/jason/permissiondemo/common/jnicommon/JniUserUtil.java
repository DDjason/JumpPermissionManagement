package com.zafu.jason.permissiondemo.common.jnicommon;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/12/26$ 16:48$
 * <p/>
 */
public class JniUserUtil {
    static {
        System.loadLibrary("JniTest");
    }

    public static native String printFromJNI();

}
