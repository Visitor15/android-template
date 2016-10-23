package com.monocole.app.dagger.module;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by visitor15 on 10/18/16.
 */
@Module
public class BaseEventModule {

    @Provides @Named(value = "defaultBus")
    public EventBus provideDefaultEventBus() {
        return EventBus.getDefault();
    }
}
