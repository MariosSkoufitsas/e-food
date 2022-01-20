package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText  name,mail,phone,addres,pas1;
    Button regbut;
    FirebaseAuth fAuth;
    addressname namee;
    ImageView mapssss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.nametxt);
        mail=findViewById(R.id.emailtxt);
        phone=findViewById(R.id.phonetxt);
        addres=findViewById(R.id.Addresstxt);
        pas1=findViewById(R.id.Password1txt);
        regbut=findViewById(R.id.registerButton);
        mapssss=findViewById(R.id.gpsregister);
        namee =new addressname();
        mapssss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namee.setSurename(name.getText().toString());
                namee.setEmail(mail.getText().toString());
                namee.setPhone(phone.getText().toString());
                namee.setPassword(pas1.getText().toString());
                Intent intent = new Intent(Register.this, adress.class);
                startActivity(intent);
            }
        });
        addres.setText(namee.getName());
        name.setText(namee.getSurename());
        mail.setText(namee.getEmail());
        phone.setText(namee.getPhone());
        pas1.setText(namee.getPassword());
        fAuth=FirebaseAuth.getInstance();
        regbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mail.getText().toString().trim();
                String password=pas1.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    mail.setError("Δεν έχεις βάλει E-mail");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    pas1.setError("Δεν έχεις βάλει password");
                    return;
                }
                if (password.length()<6){
                    pas1.setError("Το password πρέπει να είναι τουλάχιστον 6 χαρακτήρες");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            atomo at=new atomo(
                                    name.getText().toString(), mail.getText().toString(),phone.getText().toString(),addres.getText().toString(),namee.getLat(),namee.getLog());
                            FirebaseDatabase.getInstance().getReference("Users").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(at).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            });

                            Toast.makeText(Register.this,"Ο ΧΡΗΣΤΗΣ ΔΗΜΙΟΥΡΓΗΘΗΚΕ",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplication(),conect.class));
                        }
                        else{
                            Toast.makeText(Register.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}