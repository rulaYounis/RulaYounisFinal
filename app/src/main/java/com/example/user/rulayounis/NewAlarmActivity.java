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

import java.text.DateFormat;
import java.util.Calendar;

public class NewAlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener,View.OnClickListener{
    private static final int TASK = 0;
    Button btSetDate,btSetAlarm,btChooseActivity, btAddAlarm;
    String time, date, task="1", name;
    EditText etAlarmName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);

        TextView tvTask=(TextView) findViewById(R.id.tvTask);


        if(getIntent() != null) {
            task = getIntent().getStringExtra("task");
            tvTask.setText(getIntent().getStringExtra("task"));

        }


        btSetAlarm = (Button) findViewById(R.id.btSetAlarm);
        btSetAlarm.setOnClickListener(this);
        btChooseActivity = (Button) findViewById(R.id.btChooseActivity);
        btChooseActivity.setOnClickListener(this);
        btSetDate= (Button)findViewById(R.id.btSetDate);
        btSetDate.setOnClickListener(this);

        btAddAlarm= (Button)findViewById(R.id.btAddAlarm);
        btAddAlarm.setOnClickListener(this);

        etAlarmName = findViewById(R.id.etAlarmName);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tvTime=(TextView) findViewById(R.id.tvTime);
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

        TextView tvDate =(TextView) findViewById(R.id.tvDate);
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
           Intent intent= new Intent(this,ChooseAccountActivity.class);
            startActivity(intent);
        }
        if(v == btAddAlarm){
            Intent intent= new Intent(this,AllAlarmsActivity.class);
            name =etAlarmName.getText().toString();
            intent.putExtra("alarm",new Alarm(R.drawable.alarm, name, time, date, task));
            startActivity(intent);
        }
    }
}
