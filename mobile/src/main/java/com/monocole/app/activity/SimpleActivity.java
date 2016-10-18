package com.monocole.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.monocole.app.BaseActivity;
import com.monocole.app.MonocoleApp;
import com.monocole.app.R;
import com.monocole.app.event.SimpleEvent;
import com.monocole.app.gui.NavDrawAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by visitor15 on 10/17/16.
 */

public class SimpleActivity extends BaseActivity {

    @Inject
    NavDrawAdapter navDrawAdapter;

    @Inject @Named("defaultBus")
    EventBus eventBus;

    @Override
    protected View onSimpleCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return parent;
    }

    @Override
    protected void onSimpleResume() {
        eventBus.register(this);
    }

    @Override
    protected void onSimplePause() {
        eventBus.unregister(this);
    }

    @Override
    protected void onSimpleStart() {

    }

    @Override
    protected void onSimpleNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navDrawAdapter.onNavDrawMenuItemClicked(item, drawer);
    }

    @Override
    protected void onSimpleOptionsItemSelected(MenuItem item) {
//        Handle action bar item clicks here. The action bar will
//        automatically handle clicks on the Home/Up button, so long
//        as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // Do stuff
        }
    }

    @Override
    protected void onSimpleCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
    }

    @Override
    protected void onSimpleBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSimpleCreate(Bundle savedInstanceState) {
        MonocoleApp.getContext().getSimpleActivityComponent().inject(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSimpleEvent(SimpleEvent event) {
        Toast.makeText(this, event.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
