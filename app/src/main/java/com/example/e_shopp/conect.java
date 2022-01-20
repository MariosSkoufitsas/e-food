package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class conect extends AppCompatActivity {
    TextView acc,pass,name;
    Button login;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conect);
        pass=findViewById(R.id.logPassword);
        name=findViewById(R.id.lognaome);
        login=findViewById(R.id.buttonLog);
        fAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=name.getText().toString().trim();
                String password=pass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    name.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    pass.setError("Password is Requid.");
                    return;
                }
                if (password.length()<6){
                    pass.setError("Password Must be>=6 characters");
                    return;
                }
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(getApplication(),account.class));
                        }
                        else{
                            Toast.makeText(conect.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        acc=(TextView)findViewById(R.id.accountText);
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(conect.this, Register.class);
                startActivity(intent);
            }
        });
    }
}