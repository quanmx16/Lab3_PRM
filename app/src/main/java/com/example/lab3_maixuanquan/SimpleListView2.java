package com.example.lab3_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SimpleListView2 extends AppCompatActivity {
    private ArrayList<String> listViewItems;
    private ListView listView;

    private Button btnAdd;
    private Button btnUpdate;
    private EditText etItemName;
    private int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view2);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        etItemName = findViewById(R.id.etItemName);
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
                selectedIndex = position;
                etItemName.setText(listViewItems.get(position));
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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etItemName.getText().toString())) {
                    etItemName.setError("Required");
                    return;
                } else {
                    listViewItems.add(etItemName.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                    etItemName.setText("");
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etItemName.getText().toString())) {
                    etItemName.setError("Required");
                    return;
                } else {
                    listViewItems.set(selectedIndex, etItemName.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                    etItemName.setText("");
                }
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SimpleListView2.this, SimpleListView3.class);
                startActivity(myIntent);
            }
        });
    }


}