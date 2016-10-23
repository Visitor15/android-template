package com.monocole.app;

import android.app.Application;

import com.monocole.app.dagger.BaseActivityComponent;
import com.monocole.app.dagger.DaggerBaseActivityComponent;

/**
 * Created by visitor15 on 10/18/16.
 */

public class MonocoleApp extends Application {

    private static MonocoleApp singleton;

    private static BaseActivityComponent baseActivityComponent;

    @Override
    public void onCreate() {
        MonocoleApp.singleton = this;
        init();
        super.onCreate();
    }

    public static MonocoleApp getContext() {
        return MonocoleApp.singleton;
    }

    private void init() {
        baseActivityComponent = DaggerBaseActivityComponent.builder().build();
    }

    public BaseActivityComponent getSimpleActivityComponent() {
        return baseActivityComponent;
    }
}
