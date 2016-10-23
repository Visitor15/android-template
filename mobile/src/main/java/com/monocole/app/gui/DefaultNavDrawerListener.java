package com.monocole.app.gui;

import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import com.monocole.app.R;
import com.monocole.app.event.SimpleEvent;
import com.monocole.app.event.ui.NavDrawerEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by visitor15 on 10/22/16.
 */

public class DefaultNavDrawerListener implements OnNavigationItemSelectedListener {

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        EventBus.getDefault().post(new NavDrawerEvent(NavDrawerEvent.Action.ITEM_CLICKED, id));

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
