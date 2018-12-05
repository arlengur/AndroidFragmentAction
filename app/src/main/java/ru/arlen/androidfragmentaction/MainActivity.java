package ru.arlen.androidfragmentaction;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

import static ru.arlen.androidfragmentaction.SendService.INTENT_ACTION;
import static ru.arlen.androidfragmentaction.SendService.newIntent;
import static ru.arlen.androidfragmentaction.ThirdFragment.newInstance;

public class MainActivity extends FragmentActivity implements IActivityCallbacks {
    private TextReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FirstFragment firstFragment = new FirstFragment();
            SecondFragment secondFragment = new SecondFragment();
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.container, firstFragment)
                                       .add(R.id.container, secondFragment)
                                       .commit();
            startService(newIntent(this));
        }
        mReceiver = new TextReceiver(this);
    }

    @Override
    public void pressButton() {
        EditText editText = findViewById(R.id.editTxt);
        String inputedText = editText.getText().toString();
        ThirdFragment thirdFragment = newInstance(inputedText);
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.thirdFragment, thirdFragment)
                                   .commit();
    }

    @Override
    public void setText(String text) {
        EditText editText = findViewById(R.id.editTxt);
        if (editText != null) {
            editText.setText(text);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, new IntentFilter(INTENT_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}
