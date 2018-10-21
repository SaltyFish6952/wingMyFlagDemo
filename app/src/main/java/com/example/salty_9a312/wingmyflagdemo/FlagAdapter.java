package com.example.salty_9a312.wingmyflagdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FlagAdapter extends ArrayAdapter<FlagClass> {

    ArrayList<FlagClass> flagList = new ArrayList<>();

    public FlagAdapter(@NonNull Context context, int resource, @NonNull ArrayList<FlagClass> objects) {
        super(context, resource, objects);
        flagList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.flag_adapter_layout, null);

        TextView textView = view.findViewById(R.id.flag_name);
        ImageView imageView = view.findViewById(R.id.flag_icon);

        textView.setText(flagList.get(position).getFlagName());
        imageView.setImageResource(flagList.get(position).getFlagImage());

        return view;
    }
}
