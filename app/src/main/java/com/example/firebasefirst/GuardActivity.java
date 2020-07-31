package com.example.firebasefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuardActivity extends AppCompatActivity {

    private Button Gregister;
    private Button Glogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guard);

        Gregister    = findViewById(R.id.Gregister);
        Glogin       = findViewById(R.id.Glogin);

        Gregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuardActivity.this, GuardRegisterAcivity.class));
                finish();
            }
        });

        Glogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuardActivity.this, GuardLoginActivity.class));
                finish();
            }
        });
    }
}