package com.monocole.app.dagger.module;

import com.monocole.app.gui.DefaultFabOnClickListener;
import com.monocole.app.gui.DefaultNavDrawerListener;

import dagger.Module;
import dagger.Provides;

/**
 * Created by visitor15 on 10/18/16.
 */
@Module
public class BaseActivityModule {

    @Provides
    public static DefaultNavDrawerListener provideNavDrawAdapter() {
        return new DefaultNavDrawerListener();
    }

    @Provides
    public static DefaultFabOnClickListener provideFabOnClickListener() {
        return new DefaultFabOnClickListener();
    }
}
