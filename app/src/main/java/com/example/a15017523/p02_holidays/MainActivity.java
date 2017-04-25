package com.example.a15017523.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lvTypes);
        types = new ArrayList<String>();
        types.add("Secular");

        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, types);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedType = types.get(i);
                Intent intent =new Intent(getBaseContext(), SecondActivity.class);
                intent.putExtra("type", selectedType);
                startActivity(intent);
            }
        });
    }
}
