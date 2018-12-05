package ru.arlen.androidfragmentaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static ru.arlen.androidfragmentaction.SendService.GEN_TEXT;

public class TextReceiver extends BroadcastReceiver {
    IActivityCallbacks mCallbacks;

    public TextReceiver(MainActivity context) {
        mCallbacks = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra(GEN_TEXT);
        mCallbacks.setText(text);
    }
}