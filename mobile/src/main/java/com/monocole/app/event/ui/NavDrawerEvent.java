package com.monocole.app.event.ui;

/**
 * Created by visitor15 on 10/23/16.
 */

public class NavDrawerEvent {

    public enum Action {
        ITEM_CLICKED;
    }

    private final Action action;

    private final int id;

    public NavDrawerEvent(final Action action, final int id) {
        this.action = action;
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public int getId() {
        return id;
    }
}
