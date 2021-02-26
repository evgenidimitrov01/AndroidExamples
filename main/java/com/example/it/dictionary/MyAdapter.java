package com.example.it.dictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    Context mCtx;
    String[] data;
    private static LayoutInflater inflater = null;

    public MyAdapter(Context context, String[] data)
    {
        this.mCtx = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View view = contentView;
        if(view == null)
            view = inflater.inflate(R.layout.row_item, null);
        TextView text = view.findViewById(R.id.text);
        text.setText(data[position]);
        return view;
    }
}
