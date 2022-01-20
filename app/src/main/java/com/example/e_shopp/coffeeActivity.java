package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
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
import java.util.Locale;

public class coffeeActivity extends AppCompatActivity {

    TextView names,pos,telikhtimi;
    TextView item11;
    DatabaseReference refff,refff2,dataistoriko;
    String name1;
    magmenu menu;
    chld cl;
    Button prost;
    pgilika ilika;
    ImageView shopL,add,mimus,prev;
    int poss=1;
    RadioButton but1,but11,but22;
    double sum=1.0,alltimi;
    int telpos=1;
    String timi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);


        ilika=new pgilika();
        but1=(RadioButton)findViewById(R.id.radioButton1);
        but1.setChecked(true);
        but11=(RadioButton)findViewById(R.id.radioButton4);
        but11.setChecked(true);
        but22=(RadioButton)findViewById(R.id.radioButton5);
        telikhtimi=(TextView)findViewById(R.id.coffeetimi);

        menu=new magmenu();
        add=(ImageView)findViewById(R.id.coffeeadd);
        mimus=(ImageView)findViewById(R.id.coffemimus);
        pos=(TextView)findViewById(R.id.coffpos);
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

        shopL=(ImageView)findViewById(R.id.imagelist2);

        shopL.setClickable(true);
        shopL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(coffeeActivity.this, ShopList.class);
                startActivity(intent);
            }
        });

        prev=(ImageView)findViewById(R.id.coffeprev);
        prev.setClickable(true);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(coffeeActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        prost=(Button)findViewById(R.id.coffebutton);
        cl=new chld();
        names=(TextView)findViewById(R.id.ViewCoffe);
        //refff2=FirebaseDatabase.getInstance().getReference().child("lista");
        //dataistoriko=FirebaseDatabase.getInstance().getReference("Istoriko");
        refff = FirebaseDatabase.getInstance().getReference(menu.getMenu()).child(cl.getCl());
        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name1 =snapshot.child("name").getValue().toString();
                names.setText(name1);
                timi=snapshot.child("price").getValue().toString();
                telikhtimi.setText(timi);
                alltimi=Double.parseDouble(timi);
                sum=alltimi;


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });





        prost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilika.setPosothta(poss);
                Boolean aCheck= but1.isChecked();
                RadioButton but2 = (RadioButton) findViewById(R.id.radioButton2);
                Boolean bCheck= but2.isChecked();
                RadioButton but3 = (RadioButton) findViewById(R.id.radioButton3);
                Boolean cCheck= but3.isChecked();

                if(aCheck==true){
                    ilika.setYliko1("Σκέτος");
                }
                if(bCheck==true){
                    ilika.setYliko1("Μέτριος");
                }
                if(cCheck==true){
                    ilika.setYliko1("Γλυκός");
                }


                Boolean eCheck= but11.isChecked();

                Boolean fCheck= but22.isChecked();


                if(eCheck==true){
                    ilika.setYliko2("Μονός");
                    sum=sum*1;
                    telikhtimi.setText(String.valueOf(sum));
                }
                if(fCheck==true){
                    ilika.setYliko2("Διπλός");
                    sum=sum*2;
                    telikhtimi.setText(String.valueOf(sum));
                }


                ilika.setName(name1);
                //DecimalFormat f = new DecimalFormat("##.00");
                //double summ=Double.parseDouble(String.valueOf(f.format(sum)));
                //double summ = Double.parseDouble(String.format("%.2f", sum));
                double summ=(sum);
                ilika.setPrice(summ);



                //refff2.push().setValue(ilika);
                FirebaseDatabase.getInstance().getReference("Lista").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push().setValue(ilika);
                //dataistoriko.push().setValue(ilika);

                Toast.makeText(coffeeActivity.this,"ΕΠΙΤΥΧΗΣ ΠΡΟΣΘΗΚΗ",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(coffeeActivity.this, coffeeActivity.class);
                startActivity(in);
                finish();
            }
        });


    }
}