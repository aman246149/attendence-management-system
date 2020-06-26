package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.attendencemanagementproject.Model.Student_Detail;
import com.example.attendencemanagementproject.data.DATABASE_HANDLER_Student;

public class StudentAttendenceView extends AppCompatActivity {

    DATABASE_HANDLER_Student db= new DATABASE_HANDLER_Student(this);

    private TextView viewStudentID;
    private TextView viewStudentNAme;
    private TextView viewStudentPhNO;
    private TextView viewFAtherNAme;
    private TextView viewStudentCOurse;
    private TextView viewSemester;
    private TextView viewYEar;
    private TextView viewGender;
    private  TextView viewRollno;
    private TextView viewBRanch;
    private TextView viewDOb;
    private TextView viewPAssward;
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence_view);

        viewStudentID=findViewById(R.id.viewStudentid);
        viewStudentNAme=findViewById(R.id.viewNameid);
        viewStudentPhNO=findViewById(R.id.viewphoneid);
        viewFAtherNAme=findViewById(R.id.viewFAtherId);
        viewStudentCOurse=findViewById(R.id.viewcourseid);
        viewSemester=findViewById(R.id.viewsemesterid);
        viewYEar=findViewById(R.id.viewyearid);
        viewGender=findViewById(R.id.viewgenderid);
        viewRollno=findViewById(R.id.viewrollid);
        viewBRanch=findViewById(R.id.viewbranchid);
        viewDOb=findViewById(R.id.viewdob);
        viewPAssward=findViewById(R.id.viewpassward);

        Intent intent=getIntent();

        String stuid = intent.getStringExtra("stu_key");

        Log.d("stuid", "onCreate: " + stuid);

        Student_Detail student_detail;
       student_detail= db.get_detail(stuid);

       viewStudentID.setText(String.valueOf(student_detail.getStudent_id()));//
       viewStudentNAme.setText(student_detail.getName());
       viewStudentPhNO.setText(student_detail.getPhone_number());
       viewFAtherNAme.setText(student_detail.getFather_name());
       viewStudentCOurse.setText(student_detail.getCourse());
       viewSemester.setText(String.valueOf(student_detail.getSemester()));
       viewYEar.setText(String.valueOf(student_detail.getYear()));
       viewGender.setText(student_detail.getGender());
       viewRollno.setText(String.valueOf(student_detail.getRoll_number()));
       viewBRanch.setText(student_detail.getBranch());
       viewDOb.setText(student_detail.getDob());
       viewPAssward.setText(student_detail.getPassword());




    }
}