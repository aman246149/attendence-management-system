package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendencemanagementproject.data.DATABASE_HANDLER_Student;

public class StudentActivity extends AppCompatActivity {

    private EditText studentid;
    private EditText studentPass;
    private Button  studentlogin;
    boolean passwardchecker;
    boolean id_checker;
    // private TextView wrongidvie;
    DATABASE_HANDLER_Student db=new DATABASE_HANDLER_Student(StudentActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentid=findViewById(R.id.studentloginid);
        studentPass=findViewById(R.id.studentloginpassward);
        studentlogin=findViewById(R.id.loginbuttonStudentid);
        //    wrongidvie=findViewById(R.id.wrongid);



        studentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=studentid.getText().toString().trim();
                String pass=studentPass.getText().toString().trim();

                Log.d("id", "onClick: " + id);
                id_checker=db.if_avilable(id);
                if(id_checker) {
                    passwardchecker = db.check_Password(id, pass);

                    if (passwardchecker) {
                        Intent intent = new Intent(StudentActivity.this, StudentAttendenceView.class);
                        intent.putExtra("stu_key", id);
                        startActivity(intent);
                    } else
                        Toast.makeText(StudentActivity.this, "wrong password", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(StudentActivity.this, "wrong student id", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}