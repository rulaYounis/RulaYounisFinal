package com.example.user.rulayounis;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class NewTaskActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener,View.OnClickListener {
    EditText etTaskName;
    Button btAlarmT,btDateT,btMap,btTaskDone;
    TextView tvTimeT,tvDateT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        EditText etTaskName= (EditText) findViewById(R.id.etTaskName);
        Button btAlarmT= (Button) findViewById(R.id.btAlarmT);
        Button btDateT= (Button) findViewById(R.id.btDateT);
        Button btMap= (Button) findViewById(R.id.btMap);
        Button btTaskDone = (Button) findViewById(R.id.btTaskDone);
        TextView tvTimeT=(TextView) findViewById(R.id.tvTimeT);
        TextView tvDateT= (TextView) findViewById(R.id.tvDateT);
        btAlarmT.setOnClickListener(this);
        btDateT.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btTaskDone.setOnClickListener(this);



    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    @Override
    public void onClick(View v) {

    }
}
