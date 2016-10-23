package com.monocole.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.monocole.app.gui.DefaultFabOnClickListener;
import com.monocole.app.gui.DefaultNavDrawerEventListener;
import com.monocole.app.gui.DefaultNavDrawerListener;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract View onSimpleCreateView(View parent, String name, Context context, AttributeSet attrs);

    protected abstract void onSimpleResume();

    protected abstract void onSimplePause();

    protected abstract void onSimpleStart();

    protected abstract void onSimpleOptionsItemSelected(MenuItem item);

    protected abstract void onSimpleCreateOptionsMenu(Menu menu);

    protected abstract void onSimpleBackPressed();

    protected abstract void onSimpleCreate(Bundle savedInstanceState);

    @Inject
    DefaultNavDrawerListener defaultNavDrawerListener;

    @Inject
    DefaultFabOnClickListener defaultFabOnClickListener;

    @Inject @Named("defaultBus")
    EventBus eventBus;

    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    protected NavigationView navigationView;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.fab)
    protected FloatingActionButton fab;

    private ActionBarDrawerToggle toggle;

    private DefaultNavDrawerEventListener defaultNavDrawerEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindResources();
        setSupportActionBar(toolbar);
        setListeners();
        onSimpleCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        onSimpleBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        onSimpleCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        onSimpleOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventBus.register(defaultNavDrawerEventListener);
        navigationView.setNavigationItemSelectedListener(defaultNavDrawerListener);
        onSimpleResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        eventBus.unregister(defaultNavDrawerEventListener);
        onSimplePause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onSimpleStart();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(onSimpleCreateView(parent, name, context, attrs), name, context, attrs);
    }

    private void bindResources() {
        MonocoleApp.getContext().getSimpleActivityComponent().inject(this);
        ButterKnife.bind(this);
    }

    private void setListeners() {
        defaultNavDrawerEventListener = new DefaultNavDrawerEventListener(drawerLayout);
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        fab.setOnClickListener(defaultFabOnClickListener);
    }
}
