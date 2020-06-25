package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.attendencemanagementproject.data.DATABASE_HANDLER_Student;


//This is teacher attendence register in this teacher have to enter data and save it into database

public class TeacherAttendenceRegister extends AppCompatActivity {

    private EditText studentId;
    private EditText studentName;
    private EditText studentPhoneNumber;
    private EditText studentFatherName;
    private EditText studentCourse;
    private EditText studentSem;
    private EditText studentYear;
    private EditText studentGender;
    private EditText studentRollNO;
    private EditText studentBranch;
    private EditText studentDob;
    private EditText studentPassward;
    private Button saveButton;


    DATABASE_HANDLER_Student db=new DATABASE_HANDLER_Student(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_attendence_register);

        studentId=findViewById(R.id.studentid);
        studentName=findViewById(R.id.studentnameid);
        studentPhoneNumber=findViewById(R.id.phoneNumberID);
        studentFatherName=findViewById(R.id.FatherNameid);
        studentCourse=findViewById(R.id.stuCourseid);
        studentSem=findViewById(R.id.stuSemid);
        studentYear=findViewById(R.id.stuyearId);
        studentGender=findViewById(R.id.StugenderId);
        studentRollNO=findViewById(R.id.StuRollNoid);
        studentBranch=findViewById(R.id.StuBranchId);
        studentDob=findViewById(R.id.StudobId);
        studentPassward=findViewById(R.id.StuPassId);
        saveButton=findViewById(R.id.StuSaveBTNid);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//ToDo save data in database
//
            }
        });
    }
}