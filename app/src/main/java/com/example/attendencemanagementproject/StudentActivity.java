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
   // private TextView wrongidvie;
    DATABASE_HANDLER_Student db=new DATABASE_HANDLER_Student(StudentActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentid=findViewById(R.id.stuloginid);
        studentPass=findViewById(R.id.stuloginpassward);
        studentlogin=findViewById(R.id.loginbuttonstudentid);
    //    wrongidvie=findViewById(R.id.wrongid);



        studentlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=studentid.getText().toString();
                String pass=studentPass.getText().toString();

                Log.d("id", "onClick: " + id);
                   boolean passwardchecker=db.check_Password(id,pass);

                   if (passwardchecker)
                   {
                       Intent intent=new Intent(StudentActivity.this,StudentAttendenceView.class);
                       intent.putExtra("stu_key", id);
                       startActivity(intent);
                   }
                   else
                    //   wrongidvie.setText("ID AND PASSWARD NOT CORRECT");
                         Toast.makeText(StudentActivity.this,"wrong",Toast.LENGTH_SHORT).show();


            }
        });
    }
}