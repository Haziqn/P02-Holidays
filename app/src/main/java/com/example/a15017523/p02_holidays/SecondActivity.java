package com.example.a15017523.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    ArrayList<Type> types;
    TypeAdapter typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView)findViewById(R.id.tvWType);
        listView = (ListView)findViewById(R.id.lvHols);

        types = new ArrayList<Type>();
        types.add(new Type("New Year's Day\n1 Jan 2017", true));
        types.add(new Type("Labour Day\n1 May 2017", false));

        typeAdapter = new TypeAdapter(this, R.layout.row, types);
        listView.setAdapter(typeAdapter);

        Intent i = getIntent();
        final String type = i.getStringExtra("type");
        textView.setText(type);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Type selectedType = new Type(types.get(i).getType(), true);
                Toast.makeText(SecondActivity.this, selectedType.getType(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
