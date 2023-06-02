package com.example.lab3_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleListView extends AppCompatActivity {

    private ArrayList<String> listViewItems;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        listView = findViewById(R.id.listView);
        listViewItems = new ArrayList<>();
        listViewItems.add("Android");
        listViewItems.add("PHP");
        listViewItems.add("IOS");
        listViewItems.add("Unity");
        listViewItems.add("ASP.net");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listViewItems);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listViewItems.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        listView.setAdapter(arrayAdapter);

    }
}