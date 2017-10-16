package com.example.fredy.aplicacionlibro;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
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
    Button popup_but;
    MenuItem item;
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
        //String[] autores = res.getStringArray(R.array.Autores);
        //String[] textoAutores = res.getStringArray(R.array.textoAutores);
        String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);
        popup_but = (Button) findViewById(R.id.btCompartir);


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
        adapter.addFragment(Autor1Fragment.newInstance(listaImagenesAutores[3],4));
        adapter.addFragment(Autor1Fragment.newInstance(listaImagenesAutores[4],5));
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

    public void Compartir(View view) {
       // Toast.makeText(this, "Permisos de mensaje Concedidos", Toast.LENGTH_SHORT).show();
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.mi_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){


            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this," has tocado: " + item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();

    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.uno) {
            Toast.makeText(this, "Permisos de llamada Concedidos", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
    */

    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.uno:
                Toast.makeText(MainActivity.this, "Editing!", Toast.LENGTH_SHORT).show();
                mode.finish(); // Action picked, so close the contextual menu
                return true;
            case R.id.dos:
                // Trigger the deletion here
                mode.finish(); // Action picked, so close the contextual menu
                return true;
            default:
                return false;
        }
    }

}
