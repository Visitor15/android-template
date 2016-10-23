package com.monocole.app.dagger;

import com.monocole.app.BaseActivity;
import com.monocole.app.dagger.module.BaseActivityModule;
import com.monocole.app.dagger.module.BaseEventModule;

import dagger.Component;

/**
 * Created by visitor15 on 10/18/16.
 */
@Component(modules = { BaseActivityModule.class, BaseEventModule.class})
public interface BaseActivityComponent {

    void inject(BaseActivity baseActivity);
}
