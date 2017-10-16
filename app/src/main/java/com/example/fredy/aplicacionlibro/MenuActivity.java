package com.example.fredy.aplicacionlibro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void ShowActivity(View view){

        Intent i;
        switch (view.getId())
        {
            case R.id.bPrecaucion:
                i = new Intent(this, PrecaucionActivity.class );
                startActivity(i);
                break;

            case R.id.bCreditos:
                i = new Intent(this, CreditosActivity.class );
                startActivity(i);
                break;

            case R.id.bTextos:
                i = new Intent(this, MainActivity.class );
                startActivity(i);
                break;


        }








    }


}
