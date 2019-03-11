package com.example.user.rulayounis;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;
    ImageView cameraImage;
    Button btGallery,btTakePhoto;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef= database.getReference();
    Alarm alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        cameraImage = (ImageView) findViewById(R.id.cameraImage);

        btGallery = (Button) findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);
        btTakePhoto = (Button) findViewById(R.id.btTakePhoto);
        btTakePhoto.setOnClickListener(this);

        alarm = (Alarm) getIntent().getSerializableExtra("alarm");

    }

    @Override
    public void onClick(View v) {
        if(v==btTakePhoto){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,CAMERA_REQUEST);
        }else{


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode== CAMERA_REQUEST && resultCode== Activity.RESULT_OK) {

            Bitmap photo = (Bitmap) data.getExtras().get("data");
            String image  = BitMapToString(photo);
            if(alarm != null) {
                alarm.setImage(image);
                myRef.child("Alarms").child(alarm.getKey()).setValue(alarm);
                cameraImage.setImageBitmap(photo);
            }
            Intent i = new Intent(getApplicationContext(), AllAlarmsActivity.class);
            startActivity(i);

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

}
