package com.monocole.app.gui;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by visitor15 on 10/23/16.
 */

public class DefaultFabOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
