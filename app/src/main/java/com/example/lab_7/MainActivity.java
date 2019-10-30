package com.example.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList addUrl = new ArrayList<String>();;
    static  Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = findViewById(R.id.listView);

        i = getIntent();
        //i.getType();
        // String action = i.getAction();
        //String type = i.getType();
        String data = i.getStringExtra(Intent.EXTRA_TEXT);

        if (data == null) {
            addUrl.add("");
        } else {
            Log.d("addUrl", String.valueOf(addUrl));
            addUrl.add( "" + data + "" );
        }

        final ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, addUrl);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object item = listView.getItemAtPosition(position);
                String URL = (String) addUrl.get(position);

                Log.d("Url is", String.valueOf(URL));
                Log.d("Position ", String.valueOf(position));

                Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
                intent.putExtra("url", URL);
                startActivity(intent);
            }
        });

    }
}
