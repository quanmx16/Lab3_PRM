package com.example.lab3_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.lab3_maixuanquan.adapter.PlayerAdapter;
import com.example.lab3_maixuanquan.object.Player;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SimpleListView4 extends AppCompatActivity {

    private ArrayList<Player> players;
    private ListView playerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view4);
        playerListView = findViewById(R.id.playerList);
        addPlayer();
        PlayerAdapter playerAdapter = new PlayerAdapter(players, this, R.layout.player_layout);
        playerListView.setAdapter(playerAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SimpleListView4.this, SimpleListView.class);
                startActivity(myIntent);
            }
        });
    }

    private void addPlayer() {
        players = new ArrayList<>();
        Player player = new Player("Pele", R.drawable.pele, R.drawable.brazil, "October 23, 1940(age 72)");
        Player player2 = new Player("Diego Maradona", R.drawable.maradona, R.drawable.argentina, "October 30, 1960(age 52)");
        Player player3 = new Player("Johan Cruyff", R.drawable.johan, R.drawable.netherland, "April 25, 1947(age 65)");
        Player player4 = new Player("Michel Platini", R.drawable.platini, R.drawable.france, "June 21, 1955(age 57)");
        players.add(player);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }
}