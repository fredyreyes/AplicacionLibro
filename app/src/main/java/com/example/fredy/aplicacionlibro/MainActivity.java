package com.example.fredy.aplicacionlibro;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
        String [] listaImagenesAutores=res.getStringArray(R.array.ImagesTextos);

       this.pager = (ViewPager) this.findViewById(R.id.pager);
       // buttonShare=(Button)findViewById(R.id.buttonShare);
        //Toolbar toolbar=(Toolbar)(findViewById(R.id.toolbarBooks));
        //toolbar.setTitle("");
        //setSupportActionBar(toolbar);



        // Create an adapter with the fragments we show on the ViewPager
     MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(Autor1Fragment.newInstance(listaImagenesAutores[0],1));
        adapter.addFragment(Autor1Fragment.newInstance(listaImagenesAutores[1],2));
        adapter.addFragment(Autor1Fragment.newInstance(listaImagenesAutores[2],3));

        /*
        for(int i=0;i<146;i++)
        {

            adapter.addFragment(Autor1Fragment.newInstance(listaImagenesAutores[i],i+1));

        }

*/


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
