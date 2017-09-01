package com.zkp.com.myapplication;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.mob.MobApplication;
import com.zkp.com.myapplication.di.component.DaggerMainActivityComponent;
import com.zkp.com.myapplication.di.component.MainActivityComponent;
import com.zkp.com.myapplication.di.module.MainActivityModule;

/**
 * @author ZKP
 *         created at:2017/7/27 13:10
 */

public class App extends MobApplication {

    private MainActivityComponent mainActivityComponent;

    @VisibleForTesting
    protected MainActivityComponent createComponent(Context context) {
        return DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(context))
                .build();
    }

    public static MainActivityComponent getMainActivityComponent(Context context) {
        App app = (App) context.getApplicationContext();
        if (app.mainActivityComponent == null) {
            app.mainActivityComponent = app.createComponent(context);
        }
        return app.mainActivityComponent;
    }
}
