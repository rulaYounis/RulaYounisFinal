package com.example.user.rulayounis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class AllAlarmsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvAllAlarms;
    ArrayList<Alarm> items;
    AlarmCustomAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alarms);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef= database.getReference();

        lvAllAlarms= (ListView) findViewById(R.id.lvAllAlarms);

        items = new ArrayList<>();
        //final Alarm alarm = (Alarm) getIntent().getSerializableExtra("alarm");
      //  if(alarm != null){
     //       items.add(alarm);
      //  }
        adapter= new AlarmCustomAdapter(this,R.layout.alarmcustom_row, items);

        lvAllAlarms.setAdapter(adapter);
        lvAllAlarms.setOnItemClickListener(this);

        myRef.child("Alarms").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Map<String,String> map = (Map<String, String>) dataSnapshot.getValue();
                items.add(new Alarm(1,map.get("name"),map.get("time"),map.get("date"),map.get("task")));
                adapter.notifyDataSetChanged();



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
/*
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
    AlarmCustomAdapter arrayAdapter;
    ArrayList<Alarm> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);
        lvAccounts= (ListView) findViewById(R.id.lvAccounts);


        Alarm alarm = (Alarm) getIntent().getSerializableExtra("alarm");
        if(alarm != null){
            arrayList.add(alarm);
        }
        arrayAdapter= new AlarmCustomAdapter(this,R.layout.custom_row, arrayList);
        lvAccounts.setAdapter(arrayAdapter);

        lvAccounts.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, NewAlarmActivity.class);
        i.putExtra("task",arrayList.get(position).toString());
        startActivity(i);
    }
}

 */
