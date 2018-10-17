package com.example.user.rulayounis;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);
        lvAccounts= (ListView) findViewById(R.id.lvAccounts);
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lvAccounts.setAdapter(arrayAdapter);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
