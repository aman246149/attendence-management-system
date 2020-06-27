package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.attendencemanagementproject.Model.Teacher_Detail;
import com.example.attendencemanagementproject.data.Database_Handler_Teacher;

public class TeacherDEtailsBYadmin extends AppCompatActivity {

    private EditText TeacheNAme;
    private EditText TeacherPAssward;
    private EditText TeacherPhoneNumber;
    private EditText TeacherID;
    private Button saveTEacherData;

    Database_Handler_Teacher db=new Database_Handler_Teacher(TeacherDEtailsBYadmin.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_d_etails_b_yadmin);
        TeacheNAme=findViewById(R.id.adminteachernameid);
        TeacherPAssward=findViewById(R.id.teachernamepassward);
        TeacherPhoneNumber=findViewById(R.id.teachernamemobileno);
        TeacherID=findViewById(R.id.teachernameid);
        saveTEacherData=findViewById(R.id.teachernamesavedatabase);

        saveTEacherData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tname=TeacheNAme.getText().toString().trim();
                String tpassward=TeacherPAssward.getText().toString().trim();
                String tphno=TeacherPhoneNumber.getText().toString().trim();
                int tID= Integer.parseInt(TeacherID.getText().toString().trim());

                Teacher_Detail teacher_detail=new Teacher_Detail();

                teacher_detail.setName(tname);
                teacher_detail.setPassword(tpassward);
                teacher_detail.setMobile_no(tphno);
                teacher_detail.setTeacher_id(tID);

                db.add_Teacher_detail(teacher_detail);

                Log.d("databaseteacher", "onClick: " +"item saved");


            }
        });
    }
}