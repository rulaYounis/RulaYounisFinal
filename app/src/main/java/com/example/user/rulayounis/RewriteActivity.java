package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RewriteActivity extends AppCompatActivity implements TextWatcher{

    ArrayList<String> arrayList = new ArrayList<>();
    TextView tvMain;
    TextView tvSuccess;
    EditText etReWrite;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite);
        tvMain = (TextView) findViewById(R.id.tvMain);
        tvSuccess = (TextView) findViewById(R.id.tvSuccess);
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
        etReWrite.addTextChangedListener(this);





    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        if(s.equals(arrayList.get(position))){
            tvSuccess.setText("correct");
        }
        else {
            tvSuccess.setText("incorrect");
        }
    }
}
