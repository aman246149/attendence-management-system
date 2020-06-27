package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendencemanagementproject.data.DATABASE_HANDLER_Student;
import com.example.attendencemanagementproject.data.Database_Handler_Teacher;

public class TeacherActivity extends AppCompatActivity {
    private Button LoginButton;
    private EditText TeacherId;
    private EditText TeacherLogin;
    boolean passwardchecker;
    boolean id_checker;

Database_Handler_Teacher db=new Database_Handler_Teacher(TeacherActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        LoginButton=findViewById(R.id.loginbuttonteacherid);
        TeacherId=findViewById(R.id.editTextTextPersonName);
        TeacherLogin=findViewById(R.id.editTextTextPersonName2);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=TeacherId.getText().toString().trim();
                String pass=TeacherLogin.getText().toString().trim();

                id_checker=db.if_avilable(id);
                if(id_checker)
                {
                    passwardchecker=db.check_Password(id,pass);

                    if(passwardchecker)
                    {
                        Intent intent=new Intent(TeacherActivity.this,TeacherAttendenceRegister.class);
                        startActivity(intent);

                    }
                    else
                        Toast.makeText(TeacherActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TeacherActivity.this, "wrong Teacher id", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}