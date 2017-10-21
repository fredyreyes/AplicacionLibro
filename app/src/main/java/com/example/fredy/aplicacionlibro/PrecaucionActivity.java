package com.example.fredy.aplicacionlibro;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class PrecaucionActivity extends AppCompatActivity {

    ViewPager pager = null;
    TypedArray imgs2;
    MyFragmentPagerAdapter pagerAdapter;
    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaucion);

        Resources res = getResources();
        String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);

        this.pager = (ViewPager) this.findViewById(R.id.pager);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        for(int i=0;i<imgs2.length()-1;i++)
        {
            int urlImagen=imgs2.getResourceId(i,-1);

            adapter.addFragment(Autor1Fragment.newInstance(String.valueOf(urlImagen),i));


        }
        this.pager.setAdapter(adapter);
    }

    public void ShowCurrentItem(View v){

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        int currentItem=pager.getCurrentItem();
        //   Toast toast = Toast.makeText(context,String.valueOf(currentItem), duration);
        //  toast.show();

    }
}
