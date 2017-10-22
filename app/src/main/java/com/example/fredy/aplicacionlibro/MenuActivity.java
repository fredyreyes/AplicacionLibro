package com.example.fredy.aplicacionlibro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static com.example.fredy.aplicacionlibro.R.id.bFavoritos;
import static com.example.fredy.aplicacionlibro.R.id.bPrecaucion;

public class MenuActivity extends AppCompatActivity {

    /*
Button bAutores;
Button bCreditos;
Button bTextos;
Button bPrecaucion;
Button bFavoritos;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /*
        bAutores = (Button) findViewById(R.id.btAutor);
        bCreditos=(Button) findViewById(R.id.bCreditos);
        bPrecaucion=(Button) findViewById(bPrecaucion);
        bFavoritos=(Button) findViewById(bFavoritos);
        bTextos=(Button) findViewById(R.id.bTextos);

        bPrecaucion.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    bPrecaucion.setBackgroundResource(R.drawable.precaucion_enabled);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    bPrecaucion.setBackgroundResource(R.drawable.precaucion);
                }
                return false;
            }
        });




        bAutores.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    bAutores.setBackgroundResource(R.drawable.autores_enabled);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    bAutores.setBackgroundResource(R.drawable.autores);
                }
                return false;
            }
        });



        bCreditos.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    bCreditos.setBackgroundResource(R.drawable.creditos_enabled);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    bCreditos.setBackgroundResource(R.drawable.creditos);
                }
                return false;
            }
        });


        bTextos.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    bTextos.setBackgroundResource(R.drawable.texto_enabled);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    bTextos.setBackgroundResource(R.drawable.texto);
                }
                return false;
            }
        });




        bFavoritos.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    bFavoritos.setBackgroundResource(R.drawable.favoritos_enabled);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    bFavoritos.setBackgroundResource(R.drawable.favoritos);
                }
                return false;
            }
        });


*/

    }






    public void ShowActivity(View view){

        Intent i;
        switch (view.getId())
        {
            case bPrecaucion:


                i = new Intent(this, PrecaucionActivity.class );
                startActivity(i);

                break;

            case R.id.bCreditos:

                i = new Intent(this, CreditosActivity.class );
                startActivity(i);

                break;

            case bFavoritos:


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
