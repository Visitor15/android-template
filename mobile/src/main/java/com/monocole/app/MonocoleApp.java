package com.monocole.app;

import android.app.Application;
import android.content.Context;

import com.monocole.app.dagger.BaseActivityComponent;
import com.monocole.app.dagger.DaggerBaseActivityComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by visitor15 on 10/18/16.
 */

public class MonocoleApp extends Application {

    private static MonocoleApp singleton;

    private static RefWatcher refWatcher;

    private static BaseActivityComponent baseActivityComponent;

    @Override
    public void onCreate() {
        MonocoleApp.singleton = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        init();
        super.onCreate();
    }

    public static MonocoleApp getContext() {
        return MonocoleApp.singleton;
    }

    public static RefWatcher getRefWatcher() {
        return MonocoleApp.singleton.refWatcher;
    }

    private void init() {
        refWatcher              = LeakCanary.install(MonocoleApp.singleton);
        baseActivityComponent   = DaggerBaseActivityComponent.builder().build();
    }

    public BaseActivityComponent getSimpleActivityComponent() {
        return baseActivityComponent;
    }
}
