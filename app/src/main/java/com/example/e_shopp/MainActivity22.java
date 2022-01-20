package com.example.e_shopp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity22 extends AppCompatActivity {

    EditText txtname,txtage,txtphone,txtHeigth;
    Button btSave;
    DatabaseReference reff;
    Member member;
    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<String> arrayList= new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    magmenu menu;
    ImageView showk;
    ImageView Gril,Pizza,cafe,maps;
    count c;
    TextView namecategory;
    LatLng myLokate;
    public int i=0;
    private static String Magazi="Grill", menoy1="Menu_grill_1",menoy2="Menu_grill_2",menoy3="Menu_grill_3",menoy4="Menu_grill_4",menoy5="Menu_grill_5";
    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        listView=(ListView)findViewById(R.id.List_itemm);
        c=new count();
        namecategory=(TextView)findViewById(R.id.onomaest);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        menu=new magmenu();
        databaseReference= FirebaseDatabase.getInstance().getReference(Magazi);
        namecategory.setText("ΨΗΤΟΠΩΛΕΙΑ");
        Gril=(ImageView)findViewById(R.id.ViewGril);
        maps=(ImageView)findViewById(R.id.maps);
        Pizza=(ImageView)findViewById(R.id.ViewPizza);
        cafe=(ImageView)findViewById(R.id.ViewCafes);
        showk=(ImageView)findViewById(R.id.ViewShow);

        if (c.getI()==0){
            showk.setImageResource(R.drawable.grill_bg);
            namecategory.setText("ΨΗΤΟΠΩΛΕΙΑ");
        }
        if (c.getI()==1){
            showk.setImageResource(R.drawable.pizzas_bg);
            namecategory.setText("ΠΙΤΣΑΡΙΕΣ");
        }
        if (c.getI()==2){
            showk.setImageResource(R.drawable.cafes_bg);
            namecategory.setText("ΚΑΦΕΤΕΡΙΕΣ");
        }
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (c.getI()){
                    case 0:
                        Intent intent = new Intent(MainActivity22.this, MapsActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity22.this, MapsPizza.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case 2:
                        Intent intent3 = new Intent(MainActivity22.this, MapsCoffee.class);
                        startActivity(intent3);
                        finish();
                        break;
                }
            }
        });
        Gril.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setI(0);
                Magazi="Grill";
                menoy1="Menu_grill_1";
                menoy2="Menu_grill_2";
                menoy3="Menu_grill_3";
                menoy4="Menu_grill_4";
                menoy5="Menu_grill_5";
                Intent intent = new Intent(MainActivity22.this, MainActivity22.class);
                startActivity(intent);
                databaseReference= FirebaseDatabase.getInstance().getReference(Magazi);
                System.out.println(Magazi);
                finish();
            }
        });
        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setI(1);
                Magazi="Pizzaries";
                menoy1="Menu_pizzaria_1";
                menoy2="Menu_pizzaria_2";
                menoy3="Menu_pizzaria_3";
                menoy4="Menu_pizzaria_4";
                menoy5="Menu_pizzaria_5";
                Intent intent = new Intent(MainActivity22.this, MainActivity22.class);
                startActivity(intent);
                databaseReference= FirebaseDatabase.getInstance().getReference(Magazi);
                System.out.println(Magazi);
                finish();
                showk.setImageResource(R.drawable.pizzas_bg);
            }
        });
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setI(2);
                Magazi="Cafes";
                menoy1="Menu_cafe_1";
                menoy2="Menu_cafe_2";
                menoy3="Menu_cafe_3";
                menoy4="Menu_cafe_4";
                menoy5="Menu_cafe_5";
                Intent intent = new Intent(MainActivity22.this, MainActivity22.class);
                startActivity(intent);
                databaseReference= FirebaseDatabase.getInstance().getReference(Magazi);
                System.out.println(Magazi);
                finish();
            }
        });
        reff=FirebaseDatabase.getInstance().getReference("Users").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name1 =snapshot.child("lat").getValue().toString();
                double lating =Double.parseDouble(name1);
                String name2 =snapshot.child("log").getValue().toString();
                double Long =Double.parseDouble(name2);
                myLokate = new LatLng(lating, Long);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        LatLng grill1 = new LatLng(40.642915, 22.941871);
        LatLng grill2 = new LatLng(40.634322, 22.942160);
        LatLng grill3 = new LatLng(40.631448, 22.952435);
        LatLng grill4 = new LatLng(40.608779, 22.979342);
        LatLng grill5 = new LatLng(40.621777, 22.956243);

        LatLng pizza1 = new LatLng(40.668356985973276, 22.90923905792156);
        LatLng pizza2 = new LatLng(40.62766262514976, 22.947358299597838);
        LatLng pizza3 = new LatLng(40.622259371790065, 22.960660433425353);
        LatLng pizza4 = new LatLng(40.634237816230126, 22.952798225225425);
        LatLng pizza5 = new LatLng(40.636173679501816, 22.952739636890342);

        LatLng coffee1 = new LatLng(40.642730, 22.930432);
        LatLng coffee2 = new LatLng(40.6020967400314, 22.969365932294803);
        LatLng coffee3 = new LatLng(40.60069525812926, 22.95414188934142);
        LatLng coffee4 = new LatLng(40.63423211413022, 22.939140485218857);
        LatLng coffee5 = new LatLng(40.60362163007629, 22.974937984658563);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                for (DataSnapshot item:snapshot.getChildren()){
                    switch (c.getI()){
                        case 0:
                            if(CalculationByDistance(myLokate,grill1)<=2.00000 && i==0){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,grill2)<=2.00000 && i==1){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,grill3)<=2.00000 && i==2){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,grill4)<=2.00000 && i==3){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,grill5)<=2.00000 && i==4){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            break;
                        case 1:
                            if(CalculationByDistance(myLokate,pizza1)<=2.00000 && i==0){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,pizza2)<=2.00000 && i==1){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,pizza3)<=2.00000 && i==2){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,pizza4)<=2.00000 && i==3){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            if(CalculationByDistance(myLokate,pizza5)<=2.00000 && i==4){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();

                            }
                            break;
                        case 2:
                            if(CalculationByDistance(myLokate,coffee1)<=2.00000 && i==0){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(CalculationByDistance(myLokate,coffee2)<=2.00000 && i==1){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(CalculationByDistance(myLokate,coffee3)<=2.00000 && i==2){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(CalculationByDistance(myLokate,coffee4)<=2.00000 && i==3){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(CalculationByDistance(myLokate,coffee5)<=2.00000 && i==4){
                                String value =item.getValue(String.class);
                                arrayList.add(value);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            break;
                    }
                    i=i+1;
                }
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                if (position==0){
                    menu.setMenu(menoy1);
                    Intent intent = new Intent(MainActivity22.this, MainActivity2.class);
                    startActivity(intent);
                    finish();

                }
                if (position==1){
                    menu.setMenu(menoy2);
                    Intent intent = new Intent(MainActivity22.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                if (position==2) {
                    menu.setMenu(menoy3);
                    Intent intent = new Intent(MainActivity22.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                if (position==3) {
                    menu.setMenu(menoy4);
                    Intent intent = new Intent(MainActivity22.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                if (position==4) {
                    menu.setMenu(menoy5);
                    Intent intent = new Intent(MainActivity22.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}