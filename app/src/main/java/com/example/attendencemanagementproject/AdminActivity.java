package com.example.attendencemanagementproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendencemanagementproject.data.Database_Handler_Admin;

public class AdminActivity extends AppCompatActivity {

    private EditText AdmidId;
    private EditText ADminPassward;
    private Button AdminLoginBtn;
    boolean passwardchecker;
    boolean id_checker;

    Database_Handler_Admin db=new Database_Handler_Admin(AdminActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        AdmidId=findViewById(R.id.admin_log_in_id);
        ADminPassward=findViewById(R.id.admin_login_passward);
        AdminLoginBtn=findViewById(R.id.loginbuttonAdminid);

        AdminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String id=AdmidId.getText().toString().trim();
                String pass=ADminPassward.getText().toString().trim();

                id_checker=db.if_avilable(id);
                if(id_checker)
                {
                    passwardchecker=db.check_Password(id,pass);

                    if(passwardchecker)
                    {
                        Intent intent=new Intent(AdminActivity.this,TeacherDEtailsBYadmin.class);
                        startActivity(intent);

                    }
                    else
                        Toast.makeText(AdminActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AdminActivity.this, "wrong Admin id", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}