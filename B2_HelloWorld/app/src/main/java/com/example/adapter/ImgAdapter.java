package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class ImgAdapter extends ArrayAdapter<Integer> {

    private Context context;
    private int resource;
    private List<Integer> objects;

    public ImgAdapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(this.getContext()).inflate(resource,
                parent,
                false);

        TextView txt = convertView.findViewById(R.id.abc);
        txt.setText(objects.size() + "");
        ImageView imgContent = convertView.findViewById(R.id.imgItem);
        imgContent.setImageResource(objects.get(position));
        return convertView;
    }
}
