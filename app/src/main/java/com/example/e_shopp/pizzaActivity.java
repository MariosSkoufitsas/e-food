package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class pizzaActivity extends AppCompatActivity {
    Spinner spiner;
    DatabaseReference databaseReference,dataistoriko;
    List<String> names;
    TextView item11;
    DatabaseReference refff;
    DatabaseReference refff2;
    ListView list;
    int i=1;
    chld cl;
    CheckBox ck11,ck22,ck33;
    CheckBox ck44;
    CheckBox ck55;
    Button btn;
    ImageView ad;
    ImageView mims;
    int poss=1;
    TextView pos,name,telikhtimi;
    ImageView shopL;
    pgilika ilika;
    String name1,ckk1,ckk2,ckk3,ckk4,ckk5,timi;
    ImageView butpre;
    magmenu menu;
    ImageView prev,add,mimus,lista;
    double sum=1.0,alltimi;
    int telpos=1,possssss;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        spiner=findViewById(R.id.spinner);
        names=new ArrayList<>();
        name=(TextView)findViewById(R.id.pizzaname);
        lista=(ImageView)findViewById(R.id.pizzashop);
        telikhtimi=(TextView)findViewById(R.id.pizzatimi);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Pizza_Sizes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot childSnapshot:snapshot.getChildren()){
                    String spinnername=childSnapshot.child("name").getValue(String.class);
                    names.add(spinnername);
                }

                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(pizzaActivity.this, android.R.layout.simple_spinner_item,names);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spiner.setAdapter(arrayAdapter);


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        add=(ImageView)findViewById(R.id.pizzaadd);
        mimus=(ImageView)findViewById(R.id.pizzamimus);
        pos=(TextView)findViewById(R.id.pizzapos);
        add.setClickable(true);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poss=poss+1;
                String s=Integer.toString(poss);
                pos.setText(s);
                telpos=poss;
                double bool=alltimi;
                sum=bool*telpos;
                NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                DecimalFormat df = (DecimalFormat) nf;
                df.applyPattern("#0.00");
                telikhtimi.setText(String.valueOf(df.format(sum)));
            }
        });


        String s=Integer.toString(poss);
        pos.setText(s);
        mimus.setClickable(true);
        mimus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (poss>1){
                    poss=poss-1;
                    String s=Integer.toString(poss);
                    pos.setText(s);
                    telpos=poss;
                    double bool=alltimi;
                    sum=bool*telpos;
                    NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                    DecimalFormat df = (DecimalFormat) nf;
                    df.applyPattern("#0.00");
                    telikhtimi.setText(String.valueOf(df.format(sum)));
                }
            }
        });

        prev =(ImageView)findViewById(R.id.pizzaprev);
        prev.setClickable(true);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pizzaActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pizzaActivity.this, ShopList.class);
                startActivity(intent);
            }
        });

        cl=new chld();
        //ilika.setYliko1(spiner.getSelectedItem().toString());
        ilika=new pgilika();
        menu=new magmenu();
        System.out.println(cl.getCl());
        //ck11=(CheckBox)findViewById(R.id.yliko11);
        ck22=(CheckBox)findViewById(R.id.yliko22);
        ck33=(CheckBox)findViewById(R.id.yliko33);
        ck44=(CheckBox)findViewById(R.id.yliko44);
        ck55=(CheckBox)findViewById(R.id.yliko55);
        btn=(Button)findViewById(R.id.pizzabuton);





        //refff2=FirebaseDatabase.getInstance().getReference().child("lista");
        //dataistoriko=FirebaseDatabase.getInstance().getReference("Istoriko");
        refff = FirebaseDatabase.getInstance().getReference(menu.getMenu()).child(cl.getCl());
        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name1 =snapshot.child("name").getValue().toString();
                //ckk1 = snapshot.child("yliko1").getValue().toString();
                //ck11.setText(ckk1);
                ckk2 = snapshot.child("yliko2").getValue().toString();
                ck22.setText(ckk2);
                ckk3 = snapshot.child("yliko3").getValue().toString();
                ck33.setText(ckk3);
                ckk4 = snapshot.child("yliko4").getValue().toString();
                ck44.setText(ckk4);
                ckk5 = snapshot.child("yliko5").getValue().toString();
                ck55.setText(ckk5);
                timi=snapshot.child("price").getValue().toString();
                telikhtimi.setText(timi);

                alltimi=Double.parseDouble(timi);
                sum=alltimi;
                name.setText(name1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });

        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ilika.setYliko1("Ατομική");
                    possssss=0;
                    sum=Double.parseDouble(timi)*0.8;
                    DecimalFormat f = new DecimalFormat("##.00");
                    telikhtimi.setText(String.valueOf(f.format(sum)));
                }
                if(position==1){
                    ilika.setYliko1("Οικογενοιακή");
                    sum=Double.parseDouble(timi)*1;
                    DecimalFormat f = new DecimalFormat("##.00");
                    f.format(sum);
                    possssss=1;
                    telikhtimi.setText(String.valueOf(f.format(sum)));
                }
                if(position==2){
                    ilika.setYliko1("Γίγας");
                    sum=Double.parseDouble(timi)*1.3;
                    DecimalFormat f = new DecimalFormat("##.00");
                    f.format(sum);
                    possssss=2;
                    telikhtimi.setText(String.valueOf(f.format(sum)));
                }
                if(position==3){
                    ilika.setYliko1("Τετράγωνη");
                    sum=Double.parseDouble(timi)*1.5;;
                    DecimalFormat f = new DecimalFormat("##.00");
                    f.format(sum);
                    possssss=3;
                    telikhtimi.setText(String.valueOf(f.format(sum)));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if(ck11.isChecked()){
                    //ilika.setYliko1(ckk1);
                //}
                if(ck22.isChecked()){
                    ilika.setYliko2(ckk2);
                }
                if(ck33.isChecked()){
                   ilika.setYliko3(ckk3);
                }
                if(ck44.isChecked()){
                    ilika.setYliko4(ckk4);
                }
                if(ck55.isChecked()){
                    ilika.setYliko5(ckk5);
                }
                ilika.setPosothta(poss);
                DecimalFormat f = new DecimalFormat("##.00");
                //double summ=Double.parseDouble(String.valueOf(f.format(sum)));
                double summ=(sum);
                ilika.setPrice(summ);
                ilika.setName(name1);
                //refff2.push().setValue(ilika);
                FirebaseDatabase.getInstance().getReference("Lista").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push().setValue(ilika);
                //dataistoriko.push().setValue(ilika);
                Toast.makeText(pizzaActivity.this,"ΕΠΙΤΥΧΗΣ ΠΡΟΣΘΗΚΗ",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(pizzaActivity.this, pizzaActivity.class);
                startActivity(in);
                finish();
            }

        });

    }
}