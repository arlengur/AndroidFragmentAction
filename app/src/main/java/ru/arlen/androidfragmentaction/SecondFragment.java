package ru.arlen.androidfragmentaction;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment {
    IActivityCallbacks mCallbacks;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallbacks = ((MainActivity) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Нужно привести Activity к интерфейсу IActivityCallbacks");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, null);
        View btn = view.findViewById(R.id.btnCreate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.pressButton();
            }
        });
        return view;
    }
}
