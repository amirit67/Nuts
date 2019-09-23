package com.example.nuts.eventBus;


import androidx.appcompat.widget.Toolbar;

public class ShowToolbarEvent {

    public Toolbar toolbar;
    public boolean isShow;

    public ShowToolbarEvent(Toolbar toolbar, boolean isShow) {
        this.toolbar = toolbar;
        this.isShow = isShow;
    }
}