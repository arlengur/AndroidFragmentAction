package ru.arlen.androidfragmentaction;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.util.UUID;

public class SendService extends Service {
    public static final String INTENT_ACTION = "ru.arlen.INTENT_ACTION";
    public static final String GEN_TEXT = "GEN_TEXT";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent newIntent = new Intent(INTENT_ACTION);
        String randomString = UUID.randomUUID().toString();
        newIntent.putExtra(GEN_TEXT, randomString);
        sendBroadcast(newIntent);

        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SendService.class);
    }

}
