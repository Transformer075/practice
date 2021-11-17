package com.example.sample_practice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Array;
import java.util.ArrayList;

public class MyArray extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<String> friendsArray;

    public MyArray(Activity context, ArrayList<String> friendsArray){
    super(context, R.layout.customised_layout, friendsArray);
    this.context = context;
    this.friendsArray = friendsArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflator = context.getLayoutInflater();
        View SingleIdentity = inflator.inflate(R.layout.customised_layout, null, true);
        TextView textView = SingleIdentity.findViewById(R.id.contentView);
        //Button btn = SingleIdentity.findViewById(R.id.button5);
        textView.setText(friendsArray.get(position));
        return SingleIdentity;
    }
}
