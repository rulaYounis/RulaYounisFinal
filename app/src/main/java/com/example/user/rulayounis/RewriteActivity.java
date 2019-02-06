package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RewriteActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> arrayList = new ArrayList<>();
    TextView tvMain;
    TextView tvSuccess;
    EditText etReWrite;
    Button btCheck;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite);
        tvMain = (TextView) findViewById(R.id.tvMain);
        tvSuccess = (TextView) findViewById(R.id.tvSuccess);
        btCheck = (Button) findViewById(R.id.btCheck);
        etReWrite =(EditText) findViewById(R.id.etReWrite);
        arrayList.add("My friends and I are going to the cinema tonight ");
        arrayList.add("We should work hard in order to get what we want");
        arrayList.add("math task");
        arrayList.add("questions task");
        arrayList.add("synonyms task");
        arrayList.add("questions task");
        arrayList.add("questions task");
        arrayList.add("questions task");
        arrayList.add("questions task");
        arrayList.add("questions task");
        position=(int)((Math.random() * (9))+1);
        tvMain.setText(arrayList.get(position));
        btCheck.setOnClickListener(this);





    }



    @Override
    public void onClick(View v) {
        if(v==btCheck){
            if(etReWrite.getText().toString().equals(tvMain.getText().toString()))
                tvSuccess.setText("correct");
            else
                tvSuccess.setText("incorrect");
        }
    }
}
