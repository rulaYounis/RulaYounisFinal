package com.example.user.rulayounis;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class NewAlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener,View.OnClickListener{
    Button btSetDate,btSetAlarm,btChooseActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);
        btSetAlarm = (Button) findViewById(R.id.btSetAlarm);
        btSetAlarm.setOnClickListener(this);
        btChooseActivity = (Button) findViewById(R.id.btChooseActivity);
        btChooseActivity.setOnClickListener(this);
        btSetDate= (Button)findViewById(R.id.btSetDate);
        btSetDate.setOnClickListener(this);


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tvTime=(TextView) findViewById(R.id.tvTime);
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
            Intent intent= new Intent(getApplication(),ChooseAccountActivity.class);
            startActivity(intent);
        }


    }
}
