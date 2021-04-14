package com.example.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Animals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animals);
    }

    public void lion(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","Lion");
        startActivity(i);
    }

    public void tiger(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","Tiger");
        startActivity(i);
    }

    public void jaguar(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","Jaguar");
        startActivity(i);
    }

    public void cheetah(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","Cheetah");
        startActivity(i);
    }

    public void muledeer(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","Muledeer");
        startActivity(i);
    }

    public void snowleopard(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","snowleopard");
        startActivity(i);
    }

    public void zebra(View view) {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","zebra");
        startActivity(i);
    }

    public void snake(View view)
    {
        Intent i = new Intent(this, Model.class);
        i.putExtra("keyname","Snake");
        startActivity(i);
    }




    public void exit(View view) {
        finish();
        System.exit(0);
    }
}
