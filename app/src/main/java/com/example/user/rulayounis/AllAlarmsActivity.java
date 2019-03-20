package com.example.user.rulayounis;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AllAlarmsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
    ListView lvAllAlarms;
    ArrayList<Alarm> items;
    AlarmCustomAdapter adapter;
    private static final int NOTIFICATION_REMINDER_NIGHT = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alarms);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef= database.getReference();

        Intent notifyIntent = new Intent(this,MyReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast

                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),

                1000 * 60 * 60 * 24, pendingIntent);

        lvAllAlarms= (ListView) findViewById(R.id.lvAllAlarms);

        items = new ArrayList<>();
        //final Alarm alarm = (Alarm) getIntent().getSerializableExtra("alarm");
      //  if(alarm != null){
     //       items.add(alarm);
      //  }
        adapter= new AlarmCustomAdapter(this,R.layout.alarmcustom_row, items);

        lvAllAlarms.setAdapter(adapter);
        lvAllAlarms.setOnItemClickListener(this);
        lvAllAlarms.setOnItemLongClickListener(this);


        myRef.child("Alarms").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Map<String,String> map = (Map<String, String>) dataSnapshot.getValue();
                String key = dataSnapshot.getKey();
                Alarm alarm =  new Alarm(map.get("image"),map.get("name"),map.get("time"),map.get("date"),map.get("task"), key);
                items.add(alarm);
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
           // case R.id.AllTasks:
              //  Intent intent1= new Intent(getApplication(),AllTasksActivity.class);
               // startActivity(intent1);
               // break;
        }
        return true;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



    }
    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Date dat = new Date();
        Calendar cal_alarm = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();
        cal_now.setTime(dat);
        cal_alarm.setTime(dat);
        cal_alarm.set(Calendar.HOUR_OF_DAY, 11);
        cal_alarm.set(Calendar.MINUTE, 42);
        cal_alarm.set(Calendar.SECOND, 0);
        if (cal_alarm.before(cal_now)) {
            cal_alarm.add(Calendar.DATE, 1);
        }

        Intent myIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);

        manager.set(AlarmManager.RTC_WAKEUP, cal_alarm.getTimeInMillis(), pendingIntent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Alarm a = items.get(position);

        Intent i = new Intent(this,CameraGalleryActivity.class);
        i.putExtra("alarm",a);
        startActivity(i);
        return true;
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
