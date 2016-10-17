package com.monocole.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected abstract View onSimpleCreateView(View parent, String name, Context context, AttributeSet attrs);

    protected abstract void onSimpleResume();

    protected abstract void onSimplePause();

    protected abstract void onSimpleStart();

    protected abstract void onSimpleNavigationItemSelected(MenuItem item);

    protected abstract void onSimpleOptionsItemSelected(MenuItem item);

    protected abstract void onSimpleCreateOptionsMenu(Menu menu);

    protected abstract void onSimpleBackPressed();

    protected abstract void onSimpleCreate(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onSimpleCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        onSimpleNavigationItemSelected(item);
        return true;
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
        onSimpleResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
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
}
