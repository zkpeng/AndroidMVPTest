package com.zkp.com.myapplication.di.component;

import com.zkp.com.myapplication.activity.MainActivity;
import com.zkp.com.myapplication.di.module.MainActivityModule;

import dagger.Component;

/**
 * @author ZKP
 *         created at:2017/7/27 13:13
 */

@Component(modules = {MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
