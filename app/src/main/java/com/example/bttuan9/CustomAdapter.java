package com.example.bttuan9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Model> Data;
    LayoutInflater layoutInflater;
    Model sModel;

    public CustomAdapter(Context context, ArrayList<Model> Data) {
        this.context = context;
        this.Data = Data;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Data.size();
    }

    @Override
    public Object getItem(int i) {
        return Data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Data.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.row, null, true);
        }
        //link views
        ImageView img = rowView.findViewById(R.id.anh);
        TextView tx1 = rowView.findViewById(R.id.tv1);
        TextView tx2 = rowView.findViewById(R.id.tv2);

        sModel = Data.get(position);

        img.setImageResource(sModel.getImage());
        tx1.setText(sModel.getName());
        tx2.setText(sModel.getDesc());
        return rowView;
    }

}
