package com.example.thinks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView s1;
    ImageView s2;
    ImageView s3;
    Button plus;
    Button minusz;
    Button submit;
    TextView number;
    Integer ques;
    Integer rannum;
    Random ran;
    Integer life;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        innit();
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ques<10){
                    ques++;
                    number.setText(String.valueOf(ques));
                }
                else{
                    Toast.makeText(MainActivity.this, "nem lehet több mint10", Toast.LENGTH_SHORT).show();

                }


            }
        });

        minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ques>0){
                    ques--;
                    number.setText(String.valueOf(ques));
                }
                else{
                    Toast.makeText(MainActivity.this, "nem lehet kevesebb mint 0", Toast.LENGTH_SHORT).show();

                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ques >rannum){
                    Toast.makeText(MainActivity.this, "lejebb kell tipppelji", Toast.LENGTH_SHORT).show();
                    lifechange();
                }
                else if(rannum>ques){
                    Toast.makeText(MainActivity.this, "feljebb kell  tipelni", Toast.LENGTH_SHORT).show();
                    lifechange();
                }
                else{
                    Toast.makeText(MainActivity.this, "nyertél", Toast.LENGTH_SHORT).show();
                    newgame();
                }
            }
        });
    }
    public void newgame(){
        rannum=ran.nextInt(11);
        s1.setImageResource(R.drawable.heart2);
        s2.setImageResource(R.drawable.heart2);
        s3.setImageResource(R.drawable.heart2);
        life=3;
        number.setText(String.valueOf(ques));

    }
    public void lifechange(){
            life--;
            if(life==2){
                s3.setImageResource(R.drawable.heart1);
            }
            if(life==1){
                s2.setImageResource(R.drawable.heart1);
            }
            if(life==0){
                s1.setImageResource(R.drawable.heart1);
                newgame();
            }
    }
    public void innit(){
        s1=findViewById(R.id.imageheart);
        s2=findViewById(R.id.imageheart2);
        s3=findViewById(R.id.imageheart3);
        plus=findViewById(R.id.buttonplusz);
        minusz=findViewById(R.id.buttonminusz);
        submit=findViewById(R.id.submit);
        number=findViewById(R.id.number);

        rannum=0;
        ran=new Random();
        ques=ran.nextInt(11);
        life=3;
    }
}