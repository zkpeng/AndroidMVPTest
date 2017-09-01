package com.zkp.com.myapplication.repository.datasource;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.request.RequestCall;
import com.zkp.com.myapplication.utils.Constant;
import com.zkp.com.myapplication.utils.DateUtils;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/7/24.
 */

public class RequestCallUtils {

    public static final String BASE_URL = "http://apicloud.mob.com/appstore/history/query";

    public static RequestCall buildRequestCall() {
        return OkHttpUtils.get()
                .url(BASE_URL)
                .addParams("key", Constant.APP_KEY)
                .addParams("day", DateUtils.getTodayStr(Calendar.getInstance()))
                .build();
    }
}
