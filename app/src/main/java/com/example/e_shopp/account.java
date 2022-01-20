package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class account extends AppCompatActivity {
    Button next,log,istoriko;
    TextView name,name22,name33,name44;
    DatabaseReference refff;
    String name1,name2,name3,name4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        next=findViewById(R.id.metabbat);
        log=findViewById(R.id.logout);
        name=findViewById(R.id.Viewname);
        name22=findViewById(R.id.Viewname2);
        name33=findViewById(R.id.Viewname3);
        name44=findViewById(R.id.Viewname4);
        FirebaseAuth fAuth;
        istoriko=(Button)findViewById(R.id.history);

        istoriko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(account.this, istoriko.class);
                startActivity(in);
                finish();

            }
        });

        refff=FirebaseDatabase.getInstance().getReference("Users").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        refff.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            name1 =snapshot.child("username").getValue().toString();
                                            name.setText(name1);

                                            name2 =snapshot.child("email").getValue().toString();
                                            name22.setText(name2);

                                            name3 =snapshot.child("phone").getValue().toString();
                                            name33.setText(name3);

                                            name4 =snapshot.child("homeaddres").getValue().toString();
                                            name44.setText(name4);
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });


                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplication(), MainActivity22.class));
                    }
                });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(),conect.class));
            }
        });
    }
}