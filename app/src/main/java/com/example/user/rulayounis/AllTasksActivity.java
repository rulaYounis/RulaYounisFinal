package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AllTasksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvAllTasks;
    ArrayList<Item> items;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
        lvAllTasks= (ListView) findViewById(R.id.lvAllTasks);

        items = new ArrayList<>();
        items.add(new Item(R.drawable.alarm,"first"));
        items.add(new Item(R.drawable.alarm,"second"));
        items.add(new Item(R.drawable.alarm,"third"));
        items.add(new Item(R.drawable.alarm,"fourth"));

        adapter = new CustomAdapter(this,R.layout.custom_row,items);
        lvAllTasks.setAdapter(adapter);
        lvAllTasks.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
