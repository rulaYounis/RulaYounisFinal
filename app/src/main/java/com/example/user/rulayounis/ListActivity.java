package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvCountries;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvCountries= (ListView) findViewById(R.id.lvCountries);
        arrayList.add("germany");
        arrayList.add("france");
        arrayList.add("italy");
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lvCountries.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       String selectedItem= arrayList.get(position);
        if(position==0){

        }
        if(selectedItem.equals("germany")){

        }

    }
}
