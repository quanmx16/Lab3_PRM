package com.example.lab3_maixuanquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab3_maixuanquan.R;
import com.example.lab3_maixuanquan.object.Fruit;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private List<Fruit> fruitList;
    private int layout;

    public FruitAdapter(Context context, List<Fruit> fruitList, int layout) {
        this.context = context;
        this.fruitList = fruitList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtName = convertView.findViewById(R.id.fruit_name);
        TextView txtDescription = convertView.findViewById(R.id.description);
        ImageView image = convertView.findViewById(R.id.fruit_image);

        txtName.setText(fruitList.get(position).getName());
        txtDescription.setText(fruitList.get(position).getDescription());
        image.setImageURI(fruitList.get(position).getImage());
        return convertView;
    }
}
