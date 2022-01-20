package com.example.e_shopp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openList();
            }
        }*/
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, conect.class);
                startActivity(intent);
                finish();
            }

        },5000);




        /*handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(MainActivity.this, Lista.class);
                //Intent intent =new Intent(this, Lista.class);
                //startActivity(i);
               // startActivity(new Intent(MainActivity.this, Lista.class),0);
                Intent intent =new Intent(MainActivity.this, Lista.class);
                startActivity(intent);
                finish();


            }},5000);*/

    }
/*public void openList(){
        Intent intent = new Intent(this,MainActivity22.class);
        startActivity(intent);
}*/
}


/*

Edit
        Implementing K.H.'s answer:

public class SplashScreen extends AppCompatActivity {

    private Handler the_transition_handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startTheTransitionAfterTheSplashScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        the_transition_handler.removeCallbacksAndMessages(null);
    }

    private void startTheTransitionAfterTheSplashScreen() {
        the_transition_handler = new Handler();
        the_transition_handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent intentSplashScreenToActivityJustAfterSplashScreen = new Intent(SplashScreen.this, ActivityJustAfterSplashScreen.class);
                startActivity(intentSplashScreenToActivityJustAfterSplashScreen);
                overridePendingTransition(R.anim.animation_enter_activity, R.anim.animation_leave_activity);
                finish();
            }
        }, 1000);
    }
}
 */