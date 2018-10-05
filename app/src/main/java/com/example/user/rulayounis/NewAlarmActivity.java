package com.example.user.rulayounis;

import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class NewAlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm);
        Button btSetAlarm = (Button) findViewById(R.id.btSetAlarm);
        btSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker= new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tvTime=(TextView) findViewById(R.id.tvTime);
        tvTime.setText("Hour:"+hourOfDay+"minutes:"+minute);
    }
}
