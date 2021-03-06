package com.example.user.rulayounis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ChooseAccountActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvAccounts;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();
    Alarm a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);
        lvAccounts= (ListView) findViewById(R.id.lvAccounts);

        a = (Alarm) getIntent().getSerializableExtra("alarm");

        arrayList.add("memory task");
        arrayList.add("rewrite task");
        arrayList.add("math task");
        arrayList.add("questions task");
        arrayList.add("synonyms task");
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lvAccounts.setAdapter(arrayAdapter);

        lvAccounts.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, NewAlarmActivity.class);
        //i.putExtra("task", arrayList.get(position).toString());s
        a.setTask(arrayList.get(position).toString());
        i.putExtra("alarm", a);
        startActivity(i);

    }
}
