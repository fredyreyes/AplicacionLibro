package com.example.fredy.aplicacionlibro;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button buttonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate a ViewPager

        Resources res = getResources();
        String[] autores = res.getStringArray(R.array.Autores);
        String[]  textoAutores = res.getStringArray(R.array.textoAutores);


       this.pager = (ViewPager) this.findViewById(R.id.pager);
        buttonShare=(Button)findViewById(R.id.buttonShare);




        // Create an adapter with the fragments we show on the ViewPager
     MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(Autor1Fragment.newInstance(autores[0],textoAutores[0],"",1));
        adapter.addFragment(Autor1Fragment.newInstance(autores[1],textoAutores[1],"",2));
        adapter.addFragment(Autor1Fragment.newInstance(autores[2],textoAutores[2],"",3));
        adapter.addFragment(Autor1Fragment.newInstance(autores[3],textoAutores[3],"",4));
        adapter.addFragment(Autor1Fragment.newInstance(autores[4],textoAutores[4],"",5));
        adapter.addFragment(Autor1Fragment.newInstance(autores[5],textoAutores[5],"",6));


       this.pager.setAdapter(adapter);
       // buttonShare.setOnClickListener(this);


    }



    public void ShowCurrentItem(View v){

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        int currentItem=pager.getCurrentItem();
        Toast toast = Toast.makeText(context,String.valueOf(currentItem), duration);
        toast.show();


    }

}
