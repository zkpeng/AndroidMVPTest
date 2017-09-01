package com.zkp.com.myapplication;

import android.content.Context;

import com.zkp.com.myapplication.di.component.DaggerTestMainActivityComponent;
import com.zkp.com.myapplication.di.component.MainActivityComponent;
import com.zkp.com.myapplication.di.module.TestMainActivityModule;

/**
 * @author ZKP
 *         created at:2017/7/27 13:10
 */

public class TestEspressoApp extends App {

    @Override
    protected MainActivityComponent createComponent(Context context) {
        return DaggerTestMainActivityComponent.builder()
                .mainActivityModule(new TestMainActivityModule(context))
                .build();
    }
}
