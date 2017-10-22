package com.example.fredy.aplicacionlibro;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Autores extends AppCompatActivity {

    ViewPager pagerAutores = null;
    TypedArray imgs;
    MyFragmentPagerAdapter pagerAdapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autores);

        Resources res = getResources();
        String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);
        imgs = getResources().obtainTypedArray(R.array.ImageAutores);

        this.pagerAutores = (ViewPager) this.findViewById(R.id.pagerAutores);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        for(int i=0;i<imgs.length()-1;i++)
        {
            int urlImagen=imgs.getResourceId(i,-1);

            adapter.addFragment(PlantillaFragment.newInstance(String.valueOf(urlImagen),i));


        }
        this.pagerAutores.setAdapter(adapter);


    }


    public void devolverme(View view) {
       // i = new Intent(this, MenuActivity.class );
        //startActivity(i);
        finish();
       // Toast.makeText(this, "aqui me devuelvo", Toast.LENGTH_SHORT).show();
    }
}
