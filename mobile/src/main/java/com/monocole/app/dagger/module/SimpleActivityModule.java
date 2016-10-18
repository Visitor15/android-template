package com.monocole.app.dagger.module;

import com.monocole.app.gui.DefaultNavDrawAdapter;
import com.monocole.app.gui.NavDrawAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by visitor15 on 10/18/16.
 */
@Module
public class SimpleActivityModule {

    @Provides
    public static NavDrawAdapter provideNavDrawAdapter() {
        return new DefaultNavDrawAdapter();
    }
}
