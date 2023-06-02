package com.example.lab3_maixuanquan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab3_maixuanquan.R;
import com.example.lab3_maixuanquan.object.Player;

import java.util.ArrayList;

public class PlayerAdapter extends BaseAdapter {

    private ArrayList<Player> playerList;
    private Context context;
    private int layout;

    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public PlayerAdapter(ArrayList<Player> playerList, Context context, int layout) {
        this.playerList = playerList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);

        ImageView playerImage = convertView.findViewById(R.id.PlayerImage);
        ImageView nationImage = convertView.findViewById(R.id.NationImage);
        TextView name = convertView.findViewById(R.id.txtPlayerName);
        TextView description = convertView.findViewById(R.id.txtDescription);

        playerImage.setImageResource(playerList.get(position).getImage());
        nationImage.setImageResource(playerList.get(position).getNation());
        name.setText(playerList.get(position).getName());
        description.setText(playerList.get(position).getDescription());
        return convertView;
    }
}
