package com.example.user.rulayounis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btAddAcc,btSignIn;
    EditText etEmail,etPassword;
    private FirebaseAuth mAuth;
    final String TAG = "Firebase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        btAddAcc = (Button) findViewById(R.id.btAddAcc);


        btSignIn= (Button) findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
    }

   // @Override
     //public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu, menu);
        //return true;
    //}

  //  @Override
   // public boolean onOptionsItemSelected(MenuItem item) {
     //   switch (item.getItemId()) {
           // case R.id.item1:
              //  Toast.makeText(this, "item menu 1", Toast.LENGTH_SHORT).show();
              //  break;
          //  case R.id.item2:
              //  Toast.makeText(this, "com.example.user.rulayounis.Item menu 2", Toast.LENGTH_SHORT).show();
              //  break;
     //   }
      //  return true;

  //  }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }
    public void createUserWithEmailAndPassword(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // ...
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v==btSignIn){
           createUserWithEmailAndPassword("rula.yns@gmail.com","123456");
        }
    }
}

