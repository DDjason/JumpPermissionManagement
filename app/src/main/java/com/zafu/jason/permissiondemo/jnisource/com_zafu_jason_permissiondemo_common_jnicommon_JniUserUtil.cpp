#include <jni.h>
#include <string.h>
#include "com_zafu_jason_permissiondemo_common_jnicommon_JniUserUtil.h"
//
// Created by Administrator on 2017/12/27.
//

JNIEXPORT jstring JNICALL Java_com_zafu_jason_permissiondemo_common_jnicommon_JniUserUtil_printFromJNI
  (JNIEnv *, jclass){
  return (*env)->NewStringUTF(env,(char*)"hello.JNITest");
  }

