package com.example.firebasefirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentHomePage extends AppCompatActivity {

    private EditText s_hostel;
    private EditText s_room;

    private Button s_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_page);

        s_hostel = findViewById(R.id.s_hostel_name);
        s_room = findViewById(R.id.s_room_no);
        s_check = findViewById(R.id.s_check);

        s_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hostel = s_hostel.getText().toString().toLowerCase();
                String room = s_room.getText().toString().toLowerCase();
                get_status(hostel, room);
            }
        });
    }

    private void get_status(String hostel, String room) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(hostel).child(room).child("Status");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object status = dataSnapshot.getValue();
                Object present = true;
                if(status == present) {
                    Toast.makeText(StudentHomePage.this, "Your parcel has arrived, go and collect it!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StudentHomePage.this, "No pending parcels to collect!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StudentHomePage.this, "Oops! there was an error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}