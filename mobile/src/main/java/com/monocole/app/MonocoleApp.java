package com.monocole.app;

import android.app.Application;

import com.monocole.app.dagger.DaggerSimpleActivityComponent;
import com.monocole.app.dagger.SimpleActivityComponent;

/**
 * Created by visitor15 on 10/18/16.
 */

public class MonocoleApp extends Application {

    private static MonocoleApp singleton;

    private static SimpleActivityComponent simpleActivityComponent;

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
        simpleActivityComponent = DaggerSimpleActivityComponent.builder().build();
    }

    public SimpleActivityComponent getSimpleActivityComponent() {
        return simpleActivityComponent;
    }
}
