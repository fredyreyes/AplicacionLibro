package com.example.fredy.aplicacionlibro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

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

            case R.id.bFavoritos:
                Favorites objDatabase =  new Favorites(this, "DbAplicacionLibro", null, 1);
                SQLiteDatabase dbFavorites = objDatabase.getWritableDatabase();
                Cursor c= dbFavorites.rawQuery("SELECT * FROM Favoritos",null);
                if(c.moveToFirst())
                {
                    dbFavorites.close();
                    i = new Intent(this, FavoritosActivity.class );
                    startActivity(i);

                }
                else
                {
                    dbFavorites.close();
                    Toast.makeText(MenuActivity.this, "No tiene favoritos guardados", Toast.LENGTH_SHORT).show();


                }

                break;


            case R.id.bTextos:
                i = new Intent(this, MainActivity.class );
                startActivity(i);
                break;
            case R.id.bAutor:
                i = new Intent(this, Autores.class );
                startActivity(i);
                break;


        }

    }




}
