package com.monocole.app.dagger;

import com.monocole.app.activity.SimpleActivity;
import com.monocole.app.dagger.module.SimpleActivityModule;
import com.monocole.app.dagger.module.SimpleEventModule;

import dagger.Component;

/**
 * Created by visitor15 on 10/18/16.
 */
@Component(modules = { SimpleActivityModule.class, SimpleEventModule.class})
public interface SimpleActivityComponent {

    void inject(SimpleActivity simpleActivity);
}
