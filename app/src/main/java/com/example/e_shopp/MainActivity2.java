package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    DatabaseReference databaseReference;
    Spinner spinner;
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> sniperDataList;
    ListView listView;
    ArrayList<String> arrayList= new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ImageView image;
    chld cl;
    String myGlobal = "";
    ImageView prebut;
    magmenu menu;
    count c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference = FirebaseDatabase.getInstance().getReference(menu.getMenu());
        listView = (ListView) findViewById(R.id.List_itemm2);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        image=(ImageView)findViewById(R.id.imageView5);
        cl=new chld();
        prebut=(ImageView)findViewById(R.id.imagepre);
        menu=new magmenu();
        c=new count();

        prebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity22.class);
                startActivity(intent);
            }
        });


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ShopList.class);
                startActivity(intent);
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value=snapshot.getValue(pgilika.class).getName();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                    {
                        cl.setCl("1");
                        if(c.getI()==1){
                            Intent intent = new Intent(MainActivity2.this, pizzaActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==2){
                            Intent intent = new Intent(MainActivity2.this, coffeeActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        if(c.getI()==0){
                            Intent intent = new Intent(MainActivity2.this, ShowItem1.class);
                            startActivity(intent);
                            System.out.println(cl.getCl());
                            finish();
                        }
                        break;}
                    case 1:{
                        cl.setCl("2");
                        if(c.getI()==1){
                            Intent intent = new Intent(MainActivity2.this, pizzaActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==2){
                            Intent intent = new Intent(MainActivity2.this, coffeeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==0){
                            Intent intent = new Intent(MainActivity2.this, ShowItem1.class);
                            startActivity(intent);
                            System.out.println(cl.getCl());
                            finish();
                        }
                        break;}
                    case 2:{
                        cl.setCl("3");
                        if(c.getI()==1){
                            Intent intent = new Intent(MainActivity2.this, pizzaActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==2){
                            Intent intent = new Intent(MainActivity2.this, coffeeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==0){
                            Intent intent = new Intent(MainActivity2.this, ShowItem1.class);
                            startActivity(intent);
                            System.out.println(cl.getCl());
                            finish();
                        }

                        break;}
                    case 3:{
                        cl.setCl("4");
                        if(c.getI()==1){
                            Intent intent = new Intent(MainActivity2.this, pizzaActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==2){
                            Intent intent = new Intent(MainActivity2.this, coffeeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==0){
                            Intent intent = new Intent(MainActivity2.this, ShowItem1.class);
                            startActivity(intent);
                            System.out.println(cl.getCl());
                            finish();
                        }
                        break;}
                    case 4:{
                        cl.setCl("5");
                        if(c.getI()==1){
                            Intent intent = new Intent(MainActivity2.this, pizzaActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==2){
                            Intent intent = new Intent(MainActivity2.this, coffeeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==0){
                            Intent intent = new Intent(MainActivity2.this, ShowItem1.class);
                            startActivity(intent);
                            System.out.println(cl.getCl());
                            finish();
                        }
                        break;}
                    case 5:{
                        cl.setCl("6");
                        if(c.getI()==1){
                            Intent intent = new Intent(MainActivity2.this, pizzaActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==2){
                            Intent intent = new Intent(MainActivity2.this, coffeeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(c.getI()==0){
                            Intent intent = new Intent(MainActivity2.this, ShowItem1.class);
                            startActivity(intent);
                            System.out.println(cl.getCl());
                            finish();
                        }
                        break;}
                }
            }
        });
    }
}
