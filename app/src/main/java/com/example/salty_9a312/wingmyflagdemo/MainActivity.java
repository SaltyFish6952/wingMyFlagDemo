package com.example.salty_9a312.wingmyflagdemo;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] COUNTRY = {
            "Brazil",
            "Canada",
            "Chile",
            "China",
            "France",
            "India",
            "Japan",
            "Mexico",
            "SouthAfrica",
            "Spain",
            "UnitedKingdom",
            "UnitedStates"
    };

    int[] COUNTRY_ID = {
            R.drawable.brazil,
            R.drawable.canada,
            R.drawable.chile,
            R.drawable.china,
            R.drawable.france,
            R.drawable.india,
            R.drawable.japan,
            R.drawable.mexico,
            R.drawable.southafrica,
            R.drawable.spain,
            R.drawable.unitedkingdom,
            R.drawable.unitedstates
    };

    ArrayList<FlagClass> flagList = new ArrayList<>();
    FlagAdapter flagAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        for (int i = 0; i < COUNTRY.length; i++) {
            flagList.add(new FlagClass(COUNTRY[i], COUNTRY_ID[i]));
        }

        flagAdapter = new FlagAdapter(this, R.layout.flag_adapter_layout, flagList);
        listView.setAdapter(flagAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, FlagShowActivity.class);



                intent.putExtra("flagName", COUNTRY[i]);
                intent.putExtra("flagIcon", COUNTRY_ID[i]);



                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fragmentManager = getFragmentManager();

                CustomDialog customDialog = new CustomDialog();


                Bundle args = new Bundle();
                args.putInt("index",i);

                customDialog.setArguments(args);
                customDialog.show(fragmentManager,"del");



                return true;
            }
        });

    }


    public void onUserSelectedItemCallback(int index){
        flagList.remove(index);
        flagAdapter.notifyDataSetChanged();
    }
}
