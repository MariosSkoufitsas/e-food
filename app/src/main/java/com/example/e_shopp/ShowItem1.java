package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
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

public class ShowItem1 extends AppCompatActivity {
    TextView item11;
    DatabaseReference refff,refff2,dataistoriko;
    ListView list;
    int i=1;
    chld cl;
    CheckBox ck1;
    CheckBox ck2;
    CheckBox ck3;
    CheckBox ck4;
    CheckBox ck5;
    Button btn;
    ImageView ad;
    ImageView mims;
    int pos=1;
    TextView poss,telikhtimi;
    ImageView shopL;
    pgilika ilika;
    String name1,ckk1,ckk2,ckk3,ckk4,ckk5,timi;
    ImageView butpre;
    magmenu menu;
    double sum=1.0,alltimi;
    int telpos=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item1);
        item11=(TextView)findViewById(R.id.item1);
        list=(ListView)findViewById(R.id.List_itemm2);
        cl=new chld();
        System.out.println(cl.getCl());
        ck1=(CheckBox)findViewById(R.id.yliko1);
        ck2=(CheckBox)findViewById(R.id.yliko2);
        ck3=(CheckBox)findViewById(R.id.yliko3);
        ck4=(CheckBox)findViewById(R.id.yliko4);
        btn=(Button)findViewById(R.id.buttonpros);
        ad=(ImageView)findViewById(R.id.grilladd);
        mims=(ImageView)findViewById(R.id.grillmomus);
        poss=(TextView) findViewById(R.id.grillpos);
        shopL=(ImageView)findViewById(R.id.pizzashop);
        String s=Integer.toString(pos);
        telikhtimi=(TextView)findViewById(R.id.griltimi);
        ck5=(CheckBox)findViewById(R.id.yliko5);
        poss.setText(s);
        menu=new magmenu();
        ilika=new pgilika();
        butpre=(ImageView)findViewById(R.id.pizzaprev);
        butpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ShowItem1.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        shopL.setClickable(true);
        shopL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowItem1.this, ShopList.class);
                startActivity(intent);
            }
        });
        ad.setClickable(true);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=pos+1;
                telpos=pos;
                String s=Integer.toString(pos);
                poss.setText(s);
                double bool=alltimi;
                sum=bool*telpos;
                NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                DecimalFormat df = (DecimalFormat) nf;
                df.applyPattern("#0.00");
                telikhtimi.setText(String.valueOf(df.format(sum)));
            }
        });
        mims.setClickable(true);
        mims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos>1){
                    pos=pos-1;
                    String s=Integer.toString(pos);
                    poss.setText(s);
                    telpos=pos;
                    double bool=alltimi;
                    sum=bool*telpos;
                    NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                    DecimalFormat df = (DecimalFormat) nf;
                    df.applyPattern("#0.00");
                    telikhtimi.setText(String.valueOf(df.format(sum)));
                }
            }
        });
        refff = FirebaseDatabase.getInstance().getReference(menu.getMenu()).child(cl.getCl());
        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name1 =snapshot.child("name").getValue().toString();
                ckk1 = snapshot.child("yliko1").getValue().toString();
                ck1.setText(ckk1);
                ckk2 = snapshot.child("yliko2").getValue().toString();
                ck2.setText(ckk2);
                ckk3 = snapshot.child("yliko3").getValue().toString();
                ck3.setText(ckk3);
                ckk4 = snapshot.child("yliko4").getValue().toString();
                ck4.setText(ckk4);
                ckk5 = snapshot.child("yliko5").getValue().toString();
                ck5.setText(ckk5);
                timi=snapshot.child("price").getValue().toString();
                telikhtimi.setText(timi);
                alltimi=Double.parseDouble(timi);
                sum=alltimi;
                item11.setText(name1);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ck1.isChecked()){
                   ilika.setYliko1(ckk1);
                }
                if(ck2.isChecked()){
                    ilika.setYliko2(ckk2);
                }
                if(ck3.isChecked()){
                    ilika.setYliko3(ckk3);
                }
                if(ck4.isChecked()){
                    ilika.setYliko4(ckk4);
                }
                if(ck5.isChecked()){
                    ilika.setYliko5(ckk5);
                }
                ilika.setPosothta(pos);
                //DecimalFormat f = new DecimalFormat("##.00");
                //double summ=Double.parseDouble(String.valueOf(f.format(sum)));
                double summ=(sum);

                ilika.setPrice(summ);
                ilika.setPrice(summ);
                ilika.setName(name1);
                FirebaseDatabase.getInstance().getReference("Lista").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push().setValue(ilika);
                Toast.makeText(ShowItem1.this,"ΕΠΙΤΥΧΗΣ ΠΡΟΣΘΗΚΗ",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(ShowItem1.this, ShowItem1.class);
                startActivity(in);
                finish();
            }
        });
    }
}