package com.project.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ToDoAdapter extends ArrayAdapter<String> {
    private String[] arr;
    private Context context;

    public ToDoAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.arr=arr;
        this.context=context;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        String s= arr[position];
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_layout,parent,false);
        TextView t=convertView.findViewById(R.id.textView);
        t.setText(getItem(position));



        Animation animation= AnimationUtils.loadAnimation(context,R.anim.anim_slide_in_left);
        convertView.startAnimation(animation);
        return convertView;
    }
}
