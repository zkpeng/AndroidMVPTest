package com.zkp.com.myapplication.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * progressdialog 工具类
 *
 * @author ZKP
 *         created at:2017/7/19 10:42
 */

public class DialogUtils {

    private static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("正在加载数据...");
        }
        progressDialog.show();
    }

    public static void hideProgressDialog(Context context) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
