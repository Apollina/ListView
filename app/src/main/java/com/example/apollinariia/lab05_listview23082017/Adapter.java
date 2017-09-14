package com.example.apollinariia.lab05_listview23082017;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.widget.TextView.*;
import static com.example.apollinariia.lab05_listview23082017.R.id.parent;

/**
 * Created by Apollinariia on 8/23/2017.
 */

public class Adapter extends ArrayAdapter<President> implements View.OnClickListener {

    private ArrayList<President> presidentList;
    Context context;



    private static class ViewHolder {
        TextView txtSurname;
        TextView txtName;
        TextView txtStartDate;
        TextView txtEndDate;
    }

    public Adapter(ArrayList<President> president, Context context) {
        super(context, R.layout.raw, president);
        this.presidentList = president;
        this.context = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        President president = (President) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        President president = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.raw, parent, false);
            viewHolder.txtSurname = (TextView) convertView.findViewById(R.id.surname);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtStartDate = (TextView) convertView.findViewById(R.id.startDate);
            viewHolder.txtEndDate = (TextView) convertView.findViewById(R.id.endDate);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtSurname.setText(president.getSurname());
        viewHolder.txtName.setText(president.getName());
        viewHolder.txtStartDate.setText(president.getStartDate());
        viewHolder.txtEndDate.setText(president.getEndDate());
        return convertView;
    }
}


