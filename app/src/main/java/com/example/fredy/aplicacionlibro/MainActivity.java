package com.example.fredy.aplicacionlibro;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

//TE AMO JOHAN!!
//JOHANN POLANA GONZALEZ
public class MainActivity extends AppCompatActivity {
//Johann Polania Gonzalez
    //SI FUNCIONO
    //otro cambio
    //CAMBIANDO LO QUE HIZO FREDO STAR

    ViewPager pager = null;


    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate a ViewPager


       this.pager = (ViewPager) this.findViewById(R.id.pager);

        // Create an adapter with the fragments we show on the ViewPager
     MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());
       adapter.addFragment(Autor1Fragment.newInstance("EDUARDO GALEANO","VENAS ABIERTAS","IMAGEN_1",1));
       adapter.addFragment(Autor1Fragment.newInstance("JULIO CORTAZAR","RAYUELA","IMAGEN_1",2));
        adapter.addFragment(Autor1Fragment.newInstance("GABRIEL GARCÍA MARQUEZ","CIEN AÑOS DE SOLEDAD","IMAGEN_1",3));
        adapter.addFragment(Autor1Fragment.newInstance("JOSE ASUNCIÓN SILVA","De sobremesa","IMAGEN3",4));
        adapter.addFragment(Autor1Fragment.newInstance("FREDY REYES","XXX","IMAGEN4",5));

       this.pager.setAdapter(adapter);



    }
}
