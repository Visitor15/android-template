package com.monocole.app.gui;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

import com.monocole.app.MonocoleApp;
import com.monocole.app.event.SimpleEvent;
import com.monocole.app.event.ui.NavDrawerEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by visitor15 on 10/23/16.
 */

public class DefaultNavDrawerEventListener {

    private final DrawerLayout drawerLayout;

    public DefaultNavDrawerEventListener(final DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSimpleEvent(NavDrawerEvent event) {
        this.drawerLayout.closeDrawer(GravityCompat.START, true);
        Toast.makeText(MonocoleApp.getContext(), event.getAction().name(), Toast.LENGTH_SHORT).show();
    }
}
