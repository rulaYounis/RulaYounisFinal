package com.example.user.rulayounis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
            imageView.setImageResource(p.getImage());
        }
        return v;

    }
}
