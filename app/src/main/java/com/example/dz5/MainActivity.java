package com.example.dz5;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] countries = { "Аргентина", "Бразилия", "Чили", "Колумбия"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, countries);
        setListAdapter(mAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Class cl = Argentina.class;
                switch (position) {
                    case 0:
                        cl = Argentina.class;
                        break;
                    case 1:
                        cl = Brasil.class;
                        break;
                    case 2:
                        cl = Chile.class;
                        break;
                    case 3:
                        cl = Columbia.class;
                }
                Intent intent = new Intent(MainActivity.this, cl);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Вы выбрали " +
                        parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }
        };
        getListView().setOnItemClickListener(itemListener);
    }
}
