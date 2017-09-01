package com.zkp.com.myapplication.di.component;

import com.zkp.com.myapplication.MainActivityEspressoTest;
import com.zkp.com.myapplication.di.module.MainActivityModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/7/27.
 */

@Component(modules = MainActivityModule.class)
public interface TestMainActivityComponent extends MainActivityComponent {

    void inject(MainActivityEspressoTest mainActivityEspressoTest);
}
