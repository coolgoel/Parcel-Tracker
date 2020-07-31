package com.example.firebasefirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.HashSet;

public class StudentRegisterActivity extends AppCompatActivity {

    private EditText s_webmail;
    private EditText s_roll;

    private Button s_register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        s_webmail       = findViewById(R.id.semail);
        s_roll          = findViewById(R.id.sroll);
        s_register      = findViewById(R.id.sregister);

        auth = FirebaseAuth.getInstance();

        s_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = s_webmail.getText().toString();
                String roll = s_roll.getText().toString();

                student_register(email, roll);
            }
        });
    }

    private void student_register(final String email, final String roll) {
        auth.createUserWithEmailAndPassword(email, roll).addOnCompleteListener(StudentRegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(StudentRegisterActivity.this, "Student Registration Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(StudentRegisterActivity.this, StudentHomePage.class));
                    finish();
                } else {
                    Toast.makeText(StudentRegisterActivity.this, "Registration Failed! Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}