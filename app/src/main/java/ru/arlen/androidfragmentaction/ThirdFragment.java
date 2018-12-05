package ru.arlen.androidfragmentaction;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    public static final String TEXT = "TEXT";

    public static ThirdFragment newInstance(String text) {
        ThirdFragment f = new ThirdFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        f.setArguments(args);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = getActivity().getApplicationContext();
        TextView textView = new TextView(context);
        String text = getArguments().getString(TEXT);
        textView.setText(text);
        return textView;
    }
}
