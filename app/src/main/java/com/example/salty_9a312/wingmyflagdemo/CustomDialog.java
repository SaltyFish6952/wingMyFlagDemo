package com.example.salty_9a312.wingmyflagdemo;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CustomDialog extends DialogFragment implements View.OnClickListener {

    int index;

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_dialog, container, false);
    }


    @Override
    public void onStart() {
        Button button_yes = getView().findViewById(R.id.custom_yes);
        Button button_no = getView().findViewById(R.id.custom_no);
        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
        index = getArguments().getInt("index");
        super.onStart();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.custom_yes){

            MainActivity activity = (MainActivity) getActivity();
            activity.onUserSelectedItemCallback(index);

        }

        this.dismiss();
    }
}
