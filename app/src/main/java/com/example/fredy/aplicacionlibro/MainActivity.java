package com.example.fredy.aplicacionlibro;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
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


public class MainActivity extends AppCompatActivity {

int resourceId;
    TypedArray imgs;
    TypedArray imgsShare;

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
        setContentView(R.layout.activity_main);
        // Instantiate a ViewPagerf


        objDatabase =  new Favorites(this, "DbAplicacionLibro", null, 1);
        Resources res = getResources();
        //String[] autores = res.getStringArray(R.array.Autores);
        textoAutores = res.getStringArray(R.array.textoAutores);
        String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);
        popup_but = (Button) findViewById(R.id.btCompartir);
      //  imagenView2 = (ImageView) findViewById(R.id.imgModelito);
      //  imagenView2.setVisibility(View.INVISIBLE);
        //******************* edicion johan *******************

          imgs = getResources().obtainTypedArray(R.array.ImagesTextos);
          imgsShare = getResources().obtainTypedArray(R.array.ImagenesCompartir);


        this.pager = (ViewPager) this.findViewById(R.id.pager);
       // buttonShare=(Button)findViewById(R.id.buttonShare);
        //Toolbar toolbar=(Toolbar)(findViewById(R.id.toolbarBooks));
        //toolbar.setTitle("");
        //setSupportActionBar(toolbar);



        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

           // Toast.makeText(MainActivity.this, "Permiso de llamada Concedido", Toast.LENGTH_SHORT).show();

        } else {


            //     explicarUsoPermiso();
            solicitarPermisoEscribir();
        }

        // Create an adapter with the fragments we show on the ViewPager
     MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        for(int i=0;i<imgs.length()-1;i++)
        {
            int urlImagen=imgs.getResourceId(i,-1);

            adapter.addFragment(Autor1Fragment.newInstance(String.valueOf(urlImagen),i));


        }
//184865901792


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

    public void Compartir(View view) {
       // Toast.makeText(this, "Permisos de mensaje Concedidos", Toast.LENGTH_SHORT).show();
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.mi_menu, popup.getMenu());


        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){


            @Override
            public boolean onMenuItemClick(MenuItem item) {

                 int id=item.getItemId();
                 int currentItem=pager.getCurrentItem();
                 SQLiteDatabase dbFavorites = objDatabase.getWritableDatabase();
                if(item.getItemId()==R.id.tres)

                {

                    Cursor c = dbFavorites.rawQuery("SELECT * FROM Favoritos WHERE identificacion=?",new String[] {String.valueOf(currentItem)}) ;

                    if(c.getCount()==0)
                     {
                         Resources res = getResources();
                         int resourceId2 = imgs.getResourceId(currentItem,-1);
                         int idImageShare=imgsShare.getResourceId(currentItem,-1);
                         String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);


                         ContentValues nuevoRegistro = new ContentValues();
                         nuevoRegistro.put("identificacion", currentItem);
                         nuevoRegistro.put("urlImagen",String.valueOf(resourceId2));
                         nuevoRegistro.put("idImageShare",String.valueOf(idImageShare));
                         dbFavorites.insert("Favoritos", null, nuevoRegistro);

                         Toast.makeText(MainActivity.this," Has guardado este texto en Favoritos: ",Toast.LENGTH_SHORT).show();


                     }
                     else
                    {
                        Toast.makeText(MainActivity.this," Este texto ya se encuentra guardado en favoritos",Toast.LENGTH_SHORT).show();

                    }

                    dbFavorites.close();
                }

                if(id == R.id.uno){


                    // Toast.makeText(MainActivity.this,"Haz tocado el Uno",Toast.LENGTH_SHORT).show();
                    // Toast.makeText(MainActivity.this,textoAutores[currentItem],Toast.LENGTH_SHORT).show();
                    // ***************************    Funcion Compartir **************************************************
                    shareIntent= new Intent(android.content.Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Poesía Digital");
                    shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,textoAutores[currentItem]);
                    startActivity(Intent.createChooser(shareIntent,"Share via"));
                }

                if(id == R.id.dos){

                    sharecompartir();
                }


             //   Toast.makeText(MainActivity.this," has tocado: " + item.getItemId(),Toast.LENGTH_SHORT).show();
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
        resourceId = imgsShare.getResourceId(currentItem,-1);
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

    //    Toast.makeText(this, "Permisos de llamada Concedidos", Toast.LENGTH_SHORT).show();

    }



}

