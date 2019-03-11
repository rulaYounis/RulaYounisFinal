package com.example.user.rulayounis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AlarmCustomAdapter extends ArrayAdapter<Alarm> {
    private int resourceLayout;
    private Context mContext;


    public AlarmCustomAdapter(@NonNull Context context, int resource, @NonNull List<Alarm> objects) {
        super(context, resource, objects);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v== null) {
            v= LayoutInflater.from(mContext).inflate(resourceLayout,parent,false);
        }
        Alarm p = (Alarm) getItem(position);
        if(p!= null){
            TextView tvName = (TextView) v.findViewById(R.id.tvNameCustom);
            tvName.setText(p.getName());
            TextView tvTime = (TextView) v.findViewById(R.id.tvTimeCustom);
            tvTime.setText(p.getTime());
            TextView tvDate = (TextView) v.findViewById(R.id.tvDateCustom);
            tvDate.setText(p.getDate());
            TextView tvTask = (TextView) v.findViewById(R.id.tvTaskCustom);
            tvTask.setText(p.getTask());


            ImageView imageView = (ImageView) v.findViewById(R.id.imageView2);
            if(!p.getImage().equals("")){
                Bitmap image = StringToBitMap(p.getImage());
                Toast.makeText(mContext, p.getImage(), Toast.LENGTH_LONG).show();
                imageView.setImageBitmap(image);
            }else {
                imageView.setImageResource(R.drawable.alarm);
            }
       }
        return v;


    }
    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
