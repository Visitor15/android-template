package com.monocole.app.gui;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.monocole.app.R;
import com.monocole.app.event.SimpleEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by visitor15 on 10/18/16.
 */

public class DefaultNavDrawAdapter implements NavDrawAdapter {

    @Override
    public void onNavDrawMenuItemClicked(final MenuItem item, final DrawerLayout drawer) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        EventBus.getDefault().post(new SimpleEvent(id, Integer.toString(id)));

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawer.closeDrawer(GravityCompat.START);
    }
}
