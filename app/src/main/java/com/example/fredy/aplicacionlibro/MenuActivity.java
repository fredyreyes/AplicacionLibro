package com.example.fredy.aplicacionlibro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

Button bAutores;
Button bCreditos;
Button bTextos;
Button bPrecaucion;
Button bFavoritos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bAutores = (Button) findViewById(R.id.btAutor);
        bCreditos=(Button) findViewById(R.id.bCreditos);
        bPrecaucion=(Button) findViewById(R.id.bPrecaucion);
        bFavoritos=(Button) findViewById(R.id.bFavoritos);
        bTextos=(Button) findViewById(R.id.bTextos);

    }


    public void ShowActivity(View view){

        Intent i;
        switch (view.getId())
        {
            case R.id.bPrecaucion:
                bPrecaucion.setBackgroundResource(R.drawable.precaucion_enabled);

                i = new Intent(this, PrecaucionActivity.class );
                startActivity(i);
                bPrecaucion.setBackgroundResource(R.drawable.precaucion);
                break;

            case R.id.bCreditos:
                bCreditos.setBackgroundResource(R.drawable.creditos_enabled);
                i = new Intent(this, CreditosActivity.class );
                startActivity(i);
                bCreditos.setBackgroundResource(R.drawable.creditos);
                break;

            case R.id.bFavoritos:

                bFavoritos.setBackgroundResource(R.drawable.favoritos_enabled);
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
                bFavoritos.setBackgroundResource(R.drawable.favoritos);
                break;


            case R.id.bTextos:
                bTextos.setBackgroundResource(R.drawable.texto_enabled);
                i = new Intent(this, MainActivity.class );
                startActivity(i);
                bTextos.setBackgroundResource(R.drawable.texto);
                break;
            case R.id.bAutor:

                break;


        }

    }




}
