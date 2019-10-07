package com.example.last;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class viewpager extends AppCompatActivity {
private ViewPager viewPager;
private viewpageradaptor viewpageradaptor;
    public static SharedPreferences sharedPreferences;
    public static final String Default="";
    public static String phone;
    public static String uid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        phone=sharedPreferences.getString("Phone",Default);     //Default value get displayed when no data is entered in main activity
        uid=sharedPreferences.getString("Uid",Default);

        if(phone.equals(Default) ||  uid.equals(Default) )
        {

            Toast.makeText(this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent as=new Intent(viewpager.this, navigationview1.class);
            startActivity(as);
//            Toast.makeText(this, "ViewPager: Data found", Toast.LENGTH_SHORT).show();
        }


        viewPager = findViewById(R.id.view_pager);
        viewpageradaptor=new viewpageradaptor(getSupportFragmentManager());
        viewPager.setAdapter(viewpageradaptor);

        Button GETSTARTED= (Button) findViewById(R.id.getstarted);
        GETSTARTED.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(phone.equals(Default) ||  uid.equals(Default) )
                {
                    Toast.makeText(viewpager.this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();


                    Intent i= new Intent(viewpager.this, otp.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent asas=new Intent(viewpager.this, navigationview1.class);
                    startActivity(asas);
                    Toast.makeText(viewpager.this, "ViewPager: Data found", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
