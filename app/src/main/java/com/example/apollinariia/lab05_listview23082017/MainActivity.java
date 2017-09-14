package com.example.apollinariia.lab05_listview23082017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.apollinariia.lab05_listview23082017.R.id.info;
import static com.example.apollinariia.lab05_listview23082017.R.styleable.MenuItem;

public class MainActivity extends AppCompatActivity {

    ArrayList<President> presidents;
    ListView listView;
    private Adapter adapter;
    TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.item_info);
        listView=(ListView)findViewById(R.id.list);

        presidents= new ArrayList<>();

        presidents.add(new President(" Stahlberg", " Kaarlo Juho ", "1919  ", "1925"));
        presidents.add(new President(" Relander", " Lauri Kristian ", "1925  ", "1931"));
        presidents.add(new President(" Svinhufvud", " Pehr Evind ", "1931  ", "1937"));
        presidents.add(new President(" Kallio", " Kyosti ", "1937  ", "1940"));
        presidents.add(new President(" Svinhufvud", " Pehr Evind ", "1931  ", "1937"));
        presidents.add(new President(" Svinhufvud", " Pehr Evind ", "1931  ", "1937"));
        presidents.add(new President(" Svinhufvud", " Pehr Evind ", "1931  ", "1937"));


        adapter= new Adapter(presidents,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

               mText.setText("");
               President president= presidents.get(position);
               mText.append(president.getSurname()+ president.getName()+ president.getStartDate() + president.getEndDate());

           }
        });


    }
}

