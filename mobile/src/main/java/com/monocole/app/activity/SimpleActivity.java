package com.monocole.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.monocole.app.BaseActivity;
import com.monocole.app.R;

/**
 * Created by visitor15 on 10/17/16.
 */

public class SimpleActivity extends BaseActivity {

    @Override
    protected View onSimpleCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return parent;
    }

    @Override
    protected void onSimpleResume() {
//        eventBus.register(this);
    }

    @Override
    protected void onSimplePause() {
//        eventBus.unregister(this);
    }

    @Override
    protected void onSimpleStart() {

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
    protected void onSimpleBackPressed() { }

    @Override
    protected void onSimpleCreate(Bundle savedInstanceState) { }
}
