package com.example.user.rulayounis;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;
    ImageView cameraImage;
    Button btGallery,btTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        cameraImage = (ImageView) findViewById(R.id.cameraImage);

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
        if(requestCode== CAMERA_REQUEST && resultCode== Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            cameraImage.setImageBitmap(photo);
            Alarm a = (Alarm) getIntent().getSerializableExtra("alarm");

            String imagePath= saveImage(photo);
            SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("image",imagePath);
            editor.commit();



            // Toast.makeText(this, "inside capture", Toast.LENGTH_LONG).show();
        }
    }
    public String saveImage(Bitmap bitmap){
        File root = Environment.getExternalStorageDirectory();
        String timeStamp  =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);
        try
        {
            file.createNewFile() ;
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,ostream);
            ostream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"failed to save image",Toast.LENGTH_SHORT).show();
        }
        return filePath;
    }




}
