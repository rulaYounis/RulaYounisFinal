package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireActivity extends AppCompatActivity {
    EditText etEmail1,etPass;
    Button btSave;
    TextView tvEmail,tvProfession;
    ListView lvUsers;
    ArrayList<String> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
        final FirebaseDatabase  database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef= database.getReference().child("Name");
        etEmail1= (EditText) findViewById(R.id.etEmail1);
        etPass = (EditText) findViewById(R.id.etPass);
        btSave=( Button) findViewById(R.id.btSave);
        tvEmail= (TextView) findViewById(R.id.tvEmail);
        tvProfession= (TextView) findViewById(R.id.tvProfession);
        lvUsers = (ListView) findViewById(R.id.lvUsers);
        users= new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,users);
        lvUsers.setAdapter(adapter);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tvEmail.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
