package com.example.fredy.aplicacionlibro;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrecaucionActivity extends AppCompatActivity {

    ViewPager pager = null;
    TypedArray imgs;
    MyFragmentPagerAdapter pagerAdapter;
    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaucion);

        Resources res = getResources();

        imgs = getResources().obtainTypedArray(R.array.precaucionImagenes);


        this.pager = (ViewPager) this.findViewById(R.id.pagerPrecaucion);



        // Create an adapter with the fragments we show on the ViewPager
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        for(int i=0;i<imgs.length();i++)
        {
            int urlImagen=imgs.getResourceId(i,-1);

            adapter.addFragment(PlantillaFragment.newInstance(String.valueOf(urlImagen),i));


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
