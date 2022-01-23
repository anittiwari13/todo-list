package com.project.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText Val;
    Button button;
    String[] arr = new String[10];
    Animation animation;
    int index=0;
    DatabaseHelper handler= new DatabaseHelper(this, "taskdb",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        Val= findViewById(R.id.Val);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val= Val.getText().toString();
//                SharedPreferences sP= getSharedPreferences("MyPref",MODE_PRIVATE);
//                SharedPreferences.Editor ed=sP.edit();
//                ed.putString("name",arr);
                arr[index]=val;

                handler.addTask(new Tasks(index+1,val));
                //handler.showTask(3);
                handler.close();
                index++;
            }
        });
        ToDoAdapter ad = new ToDoAdapter(this,R.layout.todo_layout,arr);
        listView.setAdapter(ad);
    }
}