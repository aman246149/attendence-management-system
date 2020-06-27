package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button continuebutton;
    private RadioButton studentRad;
    private RadioButton teacherRad;
    private RadioButton adminRad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continuebutton=findViewById(R.id.continueid);
        studentRad=findViewById(R.id.studentid);
        teacherRad=findViewById(R.id.adminteachernameid);
        adminRad=findViewById(R.id.adminid);
        radioGroup=findViewById(R.id.radioGroupid);
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (adminRad.isChecked())
               {
                   Intent intent=new Intent(MainActivity.this,AdminActivity.class);
                   startActivity(intent);
               }
               else if (studentRad.isChecked())
               {
                   Intent intent=new Intent(MainActivity.this,StudentActivity.class);
                   startActivity(intent);
               }
               else if (teacherRad.isChecked())
               {
                   Intent intent=new Intent(MainActivity.this,TeacherActivity.class);
                   startActivity(intent);
               }
            }
        });
    }
}