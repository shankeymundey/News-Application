package com.example.yogesh.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Firstpage extends AppCompatActivity {
    String apityp=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
    }

    public void businessbtn(View view) {
        apityp="https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=dff91617cb8e4a3697098db5d6df7dad";
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key",apityp);
        startActivity(intent);

    }

    public void sportbtn(View view) {
        apityp="https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=dff91617cb8e4a3697098db5d6df7dad";
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key",apityp);
        startActivity(intent);
    }

    public void healthbtn(View view) {
        apityp="https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=dff91617cb8e4a3697098db5d6df7dad";
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key",apityp);
        startActivity(intent);
    }

    public void entertainmentbtn(View view) {
       apityp= "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=dff91617cb8e4a3697098db5d6df7dad";
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key",apityp);
        startActivity(intent);
    }

    public void sciencebtn(View view) {
        apityp= "https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=dff91617cb8e4a3697098db5d6df7dad";
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key",apityp);
        startActivity(intent);
    }

    public void technologybtn(View view) {
        apityp= "https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=dff91617cb8e4a3697098db5d6df7dad";
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key",apityp);
        startActivity(intent);
    }


}
