package com.zkp.com.myapplication.mock;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.zkp.com.myapplication.TestEspressoApp;

public class MockTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(
            ClassLoader cl, String className, Context context)
            throws InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        return super.newApplication(
                cl, TestEspressoApp.class.getName(), context);
    }
}