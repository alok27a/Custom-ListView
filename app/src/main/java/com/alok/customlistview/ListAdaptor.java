package com.alok.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdaptor extends ArrayAdapter<User> {

    public ListAdaptor(Context context, ArrayList<User> userArrayList) {
        super(context, R.layout.custom_list_item, userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item,parent,false);
        }
        TextView userName = convertView.findViewById(R.id.name);
        TextView regno = convertView.findViewById(R.id.register_no);

        userName.setText(user.name);
        regno.setText(user.regno);
        return convertView;
    }
}
