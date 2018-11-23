package com.example.user.rulayounis;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave;
    EditText etName;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        btnSave=(Button) findViewById(R.id.btnSave);
        tvName=(TextView)findViewById(R.id.tvName);
        etName= (EditText) findViewById(R.id.etName);
        btnSave.setOnClickListener(this);
        SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);
        String name = pref.getString("name",null);
        if(name!= null)
            tvName.setText(name);



    }

    @Override
    public void onClick(View v) {
        SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);
       //open the file for editing
        SharedPreferences.Editor editor = pref.edit();
       //keyword,value format of values to be saved in the sharedPrefrences
        //can be several values
        editor.putString("name",etName.getText().toString());
       //commit the changes to the file and save
        editor.commit();
    }
}
