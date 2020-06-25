package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.attendencemanagementproject.Modle.Student_Detail;
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

                Student_Detail student_detail=new Student_Detail();



                int studentid= Integer.parseInt(studentId.getText().toString().trim());
                String Name=studentName.getText().toString().trim();
                String Phone=studentPhoneNumber.getText().toString().trim();
                String father=studentFatherName.getText().toString().trim();
                String course=studentCourse.getText().toString().trim();
                int sem= Integer.parseInt(studentSem.getText().toString().trim());
                int year= Integer.parseInt(studentYear.getText().toString().trim());
                String gender=studentGender.getText().toString().trim();
                int rollno= Integer.parseInt(studentRollNO.getText().toString().trim());
                String branch=studentBranch.getText().toString().trim();
                String dob=studentDob.getText().toString().trim();
                String passward=studentPassward.getText().toString().trim();

                student_detail.setStudent_id(studentid);
                student_detail.setName(Name);
                student_detail.setPhone_number(Phone);
                student_detail.setFather_name(father);
                student_detail.setCourse(course);
                student_detail.setSemester(sem);
                student_detail.setYear(year);
                student_detail.setGender(gender);
                student_detail.setRoll_number(rollno);
                student_detail.setBranch(branch);
                student_detail.setDob(dob);
                student_detail.setPassword(passward);

                db.add_student_detail(student_detail);


                Log.d("database", "onClick: " +"item saved");

            }
        });
    }
}