package com.example.user.rulayounis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btSignUp,btSignIn;
    EditText etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSignUp = (Button) findViewById(R.id.btSighUp);
        btSignIn= (Button) findViewById(R.id.btSignIn);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "item menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item menu 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }

    @Override
    public void onClick(View v) {

    }
}

