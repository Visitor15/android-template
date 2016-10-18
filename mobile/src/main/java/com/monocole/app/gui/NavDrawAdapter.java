package com.monocole.app.gui;

import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

/**
 * Created by visitor15 on 10/18/16.
 */

public interface NavDrawAdapter {

    void onNavDrawMenuItemClicked(final MenuItem item, final DrawerLayout drawer);
}
