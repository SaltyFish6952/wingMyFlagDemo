package com.example.salty_9a312.wingmyflagdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FlagShowActivity extends AppCompatActivity {

    String flagName;
    int flagIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_show);

        Intent intent = getIntent();

        flagName = intent.getStringExtra("flagName");
        flagIcon = intent.getIntExtra("flagIcon",0);

        ImageView imageView = this.findViewById(R.id.nationFlag);
        TextView textView = this.findViewById(R.id.nationName);

        imageView.setImageResource(flagIcon);
        textView.setText(flagName);

    }
}
