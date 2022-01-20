package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShopList extends AppCompatActivity {

    DatabaseReference databaseReference,dataistoriko;
    Spinner spinner;
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> sniperDataList;
    ListView listView;
    ArrayList<String> arrayList= new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ImageView image;
    TextView posoo;
    double sum=0;
    ImageView butpre;
    Button btndel,send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        databaseReference = FirebaseDatabase.getInstance().getReference("Lista").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        //dataistoriko=FirebaseDatabase.getInstance().getReference("Istoriko").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        dataistoriko=FirebaseDatabase.getInstance().getReference("Istoriko").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        listView = (ListView) findViewById(R.id.ListShow);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        butpre=(ImageView)findViewById(R.id.butpre2);
        btndel=(Button)findViewById(R.id.btndelete);
        posoo=(TextView)findViewById(R.id.suntimi);
        send=(Button)findViewById(R.id.ApostPara);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot item:snapshot.getChildren()){
                            dataistoriko.push().setValue(item.getValue());
                        }
                        Intent intent = new Intent(ShopList.this, account.class);
                        startActivity(intent);
                        finish();
                        for(DataSnapshot snapshot1 :snapshot.getChildren()){
                            databaseReference.getRef().removeValue();
                        }
                        Toast.makeText(ShopList.this,"ΕΠΙΤΥΧΗΣ ΑΠΟΣΤΟΛΗ",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Intent intent = new Intent(ShopList.this, MainActivity2.class);
                        startActivity(intent);
                        finish();
                        for(DataSnapshot snapshot1 :snapshot.getChildren()){
                            databaseReference.getRef().removeValue();
                        }
                        Toast.makeText(ShopList.this,"ΕΠΙΤΥΧΗΣ ΔΙΑΓΡΑΦΗ",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
        butpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopList.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value=snapshot.getValue(pgilika.class).toString();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
                double now=snapshot.getValue(pgilika.class).getPrice();
                System.out.println("ap"+now);
                sum=sum+now;
                DecimalFormat f = new DecimalFormat("##.00");
                posoo.setText(String.valueOf(f.format(sum)));
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}