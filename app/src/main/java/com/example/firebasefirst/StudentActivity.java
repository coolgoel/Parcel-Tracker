package com.example.firebasefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentActivity extends AppCompatActivity {

    private Button sregsiter;
    private Button slogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        sregsiter = findViewById(R.id.SRegister);
        slogin = findViewById(R.id.SLogin);

        sregsiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, StudentRegisterActivity.class));
                finish();
            }
        });

        slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, StudentLoginActivity.class));
                finish();
            }
        });
    }
}