package com.example.a15017523.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017523 on 25/4/2017.
 */

public class TypeAdapter extends ArrayAdapter<Type> {
    private ArrayList<Type> types;
    private Context context;
    private TextView textView;
    private ImageView imageView;


    public TypeAdapter( Context context, int resource, ArrayList<Type> types) {
        super(context, resource, types);
        this.types = types;
        this.context = context;
    }

    public View getView(int position, View oonvertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        textView = (TextView) rowView.findViewById(R.id.tvName);
        imageView = (ImageView) rowView.findViewById(R.id.ivLogo);

        Type currentType = types.get(position);


        textView.setText(currentType.getType());

        if(currentType.getaBoolean()){
            imageView.setImageResource(R.drawable.newyear);
        } else {
            imageView.setImageResource(R.drawable.labourday);
        }
        return rowView;
    }
}
