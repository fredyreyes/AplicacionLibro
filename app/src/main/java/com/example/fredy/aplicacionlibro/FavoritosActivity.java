package com.example.fredy.aplicacionlibro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class FavoritosActivity extends AppCompatActivity {


    int resourceId;
    TypedArray imgs;
    TypedArray imgShare;
    ViewPager pager = null;
    Button popup_but;
    MenuItem item;
    private static final int SOLICITUD_PERMISO_WRITE = 1;
    Favorites objDatabase;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;
    Button buttonShare;
    String[] textoAutores;
    Intent shareIntent;
    ImageView imagenView2;
    ImageView imagenViewJohan;
    int pruebaArreglo=1;

    @SuppressWarnings("ResourceType")



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        objDatabase =  new Favorites(this, "DbAplicacionLibro", null, 1);
        SQLiteDatabase dbFavorites = objDatabase.getWritableDatabase();
        Cursor c= dbFavorites.rawQuery("SELECT * FROM Favoritos",null);

        Resources res = getResources();
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        //String[] autores = res.getStringArray(R.array.Autores);
        textoAutores = res.getStringArray(R.array.textoAutores);
        String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);
        popup_but = (Button) findViewById(R.id.btCompartir);

        //******************* edicion johan *******************

        imgs = getResources().obtainTypedArray(R.array.ImagesTextos);
        imgShare = getResources().obtainTypedArray(R.array.ImagenesCompartir);
        pager = (ViewPager) this.findViewById(R.id.pagerFavoritos);



        if (ActivityCompat.checkSelfPermission(FavoritosActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {


            // Toast.makeText(MainActivity.this, "Permiso de llamada Concedido", Toast.LENGTH_SHORT).show();

        } else {



            solicitarPermisoEscribir();
        }

        if(c.moveToFirst())
        {
            do{

                int indiceImagen=Integer.parseInt(c.getString(0));
                String urlImagen=c.getString(1);
                adapter.addFragment(Autor1Fragment.newInstance(urlImagen,indiceImagen));

            }
            while (c.moveToNext());



        }
        pager.setAdapter(adapter);





    }


    public void Compartir(View view) {
        // Toast.makeText(this, "Permisos de mensaje Concedidos", Toast.LENGTH_SHORT).show();
        PopupMenu popup = new PopupMenu(FavoritosActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.mi_menu_favoritos, popup.getMenu());


        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){


            @Override
            public boolean onMenuItemClick(MenuItem item) {

                MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
                int id=item.getItemId();
                int currentItem=pager.getCurrentItem();
                SQLiteDatabase dbFavorites = objDatabase.getWritableDatabase();
                if(item.getItemId()==R.id.tresFavoritos)

                {

                    Cursor c = dbFavorites.rawQuery("SELECT * FROM Favoritos",null) ;
                    if(c.moveToPosition(currentItem))
                    {
                        String identificacionFavorito=c.getString(0);
                        Toast.makeText(FavoritosActivity.this," Se ha borrado el item: " + identificacionFavorito,Toast.LENGTH_SHORT).show();
                        dbFavorites.execSQL("DELETE  FROM Favoritos WHERE identificacion=?",new String[] {String.valueOf(identificacionFavorito)});



                            Cursor c2= dbFavorites.rawQuery("SELECT * FROM Favoritos",null);

                            if(c2.moveToFirst())
                            {
                                do{

                                    int indiceImagen=Integer.parseInt(c2.getString(0));
                                    String urlImagen=c2.getString(1);
                                    adapter.addFragment(Autor1Fragment.newInstance(urlImagen,indiceImagen));



                                }


                                while(c2.moveToNext());


                                pager.setCurrentItem(0);

                                pager.setAdapter(adapter);
                            }
                            else
                            {
                                finish();

                            }







                    }



                    dbFavorites.close();
                }

                if(id == R.id.unoFavoritos){


                    // Toast.makeText(MainActivity.this,"Haz tocado el Uno",Toast.LENGTH_SHORT).show();
                    // Toast.makeText(MainActivity.this,textoAutores[currentItem],Toast.LENGTH_SHORT).show();
                    // ***************************    Funcion Compartir **************************************************
                    shareIntent= new Intent(android.content.Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Poesía Digital");
                    shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,textoAutores[currentItem]);
                    startActivity(Intent.createChooser(shareIntent,"Share via"));
                }

                if(id == R.id.dosFavoritos){

                    sharecompartir();
                }


                Toast.makeText(FavoritosActivity.this," has tocado: " + item.getItemId(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();

    }

    public static Bitmap viewToBitmap (View view, int width, int heigth){

        Bitmap bitmap=Bitmap.createBitmap(width,heigth,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return  bitmap;
    }


    void sharecompartir(){
        int currentItem=pager.getCurrentItem();
        resourceId = imgShare.getResourceId(currentItem,-1);
        Bitmap imgBitmap= BitmapFactory.decodeResource(getResources(),resourceId);
        String imgBitmapPath= MediaStore.Images.Media.insertImage(getContentResolver(),imgBitmap,"title",null);
        Uri uri=Uri.parse(imgBitmapPath);

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");

        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        //  shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, This is test Sharing");
        startActivity(Intent.createChooser(shareIntent, "Send your image"));
    }

    private void solicitarPermisoEscribir(){

        //Pedimos el permiso o los permisos con un cuadro de dialogo del sistema
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                SOLICITUD_PERMISO_WRITE);

      //  Toast.makeText(this, "Permisos de llamada Concedidos", Toast.LENGTH_SHORT).show();

    }


}
