package com.example.user.rulayounis;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class NewAlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener,View.OnClickListener{
    private static final int TASK = 0;
    Button btSetDate,btSetAlarm,btChooseActivity, btAddAlarm;
    String time=null, date=null, task=null, name=null;
    EditText etAlarmName;
    TextView tvTime,tvDate,tvTask;


    Alarm a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);

         tvTask=(TextView) findViewById(R.id.tvTask);



       // if(getIntent() != null) {
           // task = getIntent().getStringExtra("task");
           // tvTask.setText(getIntent().getStringExtra("task"));

       // }

        tvDate =(TextView) findViewById(R.id.tvDate);
        tvTime=(TextView) findViewById(R.id.tvTime);
        btSetAlarm = (Button) findViewById(R.id.btSetAlarm);
        btSetAlarm.setOnClickListener(this);
        btChooseActivity = (Button) findViewById(R.id.btChooseActivity);
        btChooseActivity.setOnClickListener(this);
        btSetDate= (Button)findViewById(R.id.btSetDate);
        btSetDate.setOnClickListener(this);

        btAddAlarm= (Button)findViewById(R.id.btAddAlarm);
        btAddAlarm.setOnClickListener(this);

        etAlarmName = findViewById(R.id.etAlarmName);

        a = (Alarm) getIntent().getSerializableExtra("alarm");
        if(a != null){
            if(a.getName()!=null){
                etAlarmName.setText(a.getName().toString());
                name=etAlarmName.getText().toString();
            }
            if(a.getDate()!=null){
                    tvDate.setText(a.getDate());
                    date= tvDate.getText().toString();
            }
            if(a.getTime()!=null)
                tvTime.setText(a.getTime());
            time=tvTime.getText().toString();
            if(a.getTask()!=null)
                tvTask.setText(a.getTask());
            task=tvTask.getText().toString();



        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


        time=hourOfDay+":"+minute;
        tvTime.setText(hourOfDay+":"+minute);
    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());


        date=dayOfMonth+"/"+month+"/"+year;
        tvDate.setText(currentDateString);

    }

    @Override
    public void onClick(View v) {

        if(v == btSetDate){
            DialogFragment datePicker= new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(),"date picker");

        }
        if(v== btSetAlarm){
            DialogFragment timePicker= new TimePickerFragment();
            timePicker.show(getSupportFragmentManager(),"time picker");
        }
        if(v== btChooseActivity){
            name =etAlarmName.getText().toString();
           Intent intent= new Intent(this,ChooseAccountActivity.class);

            intent.putExtra("alarm",new Alarm(R.drawable.alarm, name, time, date, task));
            startActivity(intent);
        }
        if(v == btAddAlarm){
            Intent intent= new Intent(this,AllAlarmsActivity.class);
            intent.putExtra("alarm",new Alarm(R.drawable.alarm, name, time, date, task));
          //  intent.putExtra("alarm",new Alarm(R.drawable.alarm, name, time, date, task));
            Alarm alarm = new Alarm(R.drawable.alarm, name, time, date, task);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference newRef = database.getReference();//.child("Person").push();
            newRef.child("Alarms").push().setValue(alarm);
        //    newRef.setValue(alarm);
            startActivity(intent);

        }
    }
}
