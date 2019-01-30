package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class RewriteActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite);
        arrayList.add("My friends and I are going to the cinema tonight ");
        arrayList.add("We should work hard in order to get what we want");
        arrayList.add("math task");
        arrayList.add("questions task");
        arrayList.add("synonyms task");
        int position=(int)((Math.random() * (10))+1);



    }
}
