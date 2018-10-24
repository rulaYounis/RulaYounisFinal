package com.example.user.rulayounis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;
    ImageView imageView2;
    Button btGallery,btTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        btGallery = (Button) findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);
        btTakePhoto = (Button) findViewById(R.id.btTakePhoto);
        btTakePhoto.setOnClickListener(this);

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
       // if(requestCode== CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("date");
            imageView2.setImageBitmap(photo);
        Toast.makeText(this, "inside capture", Toast.LENGTH_LONG).show();

    }

}
