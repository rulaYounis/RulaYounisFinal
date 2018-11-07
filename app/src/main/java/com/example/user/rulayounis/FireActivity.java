package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

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
        final DatabaseReference myRef= database.getReference();
        etEmail1= (EditText) findViewById(R.id.etEmail1);
        etPass = (EditText) findViewById(R.id.etPass);
        btSave=( Button) findViewById(R.id.btSave);
/*        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= etEmail1.getText().toString();
                myRef.child("Users/Name").setValue(email);


            }
        });*/
        tvEmail= (TextView) findViewById(R.id.tvEmail);
        tvProfession= (TextView) findViewById(R.id.tvProfession);
        lvUsers = (ListView) findViewById(R.id.lvUsers);
        users= new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,users);
        lvUsers.setAdapter(adapter);
/*        myRef.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> map = (Map<String, String>) dataSnapshot.getValue();
                String name = map.get("Name");
                String profession = map.get("Profession");
                tvEmail.setText(name);
                tvProfession.setText(profession);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        myRef.child("Users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.getValue(String.class);
                users.add(name);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
