package com.example.thinks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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