package com.example.user.rulayounis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllAlarmsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvAllAlarms;
    ArrayList<Item> items;
    CustomAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alarms);
        lvAllAlarms= (ListView) findViewById(R.id.lvAllAlarms);

        items = new ArrayList<>();
        items.add(new Item(R.drawable.alarm,"first"));
        items.add(new Item(R.drawable.alarm,"second"));
        items.add(new Item(R.drawable.alarm,"third"));
        items.add(new Item(R.drawable.alarm,"fourth"));

        adapter = new CustomAdapter(this,R.layout.costum_row,items);
        lvAllAlarms.setAdapter(adapter);
        lvAllAlarms.setOnItemClickListener(this);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.NewAlarm:
                Intent intent= new Intent(getApplication(),NewAlarmActivity.class);
                startActivity(intent);
                break;
            case R.id.AllTasks:
                Intent intent1= new Intent(getApplication(),AllTasksActivity.class);
                startActivity(intent1);
                break;
        }
        return true;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}
