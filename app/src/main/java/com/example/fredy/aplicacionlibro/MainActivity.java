package com.example.fredy.aplicacionlibro;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
//Johann Polania Gonzalez
    //SI FUNCIONO
    //otro cambio
    //CAMBIANDO LO QUE HIZO FREDO STAR
int resourceId;
    TypedArray imgs;
    ViewPager pager = null;
    Button popup_but;
    MenuItem item;
    private static final int SOLICITUD_PERMISO_WRITE = 1;
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
        // Instantiate a ViewPager


        Resources res = getResources();
        //String[] autores = res.getStringArray(R.array.Autores);
        textoAutores = res.getStringArray(R.array.textoAutores);
        String[] listaImagenesAutores = res.getStringArray(R.array.ImagesTextos);
        popup_but = (Button) findViewById(R.id.btCompartir);
      //  imagenView2 = (ImageView) findViewById(R.id.imgModelito);
      //  imagenView2.setVisibility(View.INVISIBLE);
        //******************* edicion johan *******************

         imgs = getResources().obtainTypedArray(R.array.ImagesTextos);


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
                int id=item.getItemId();
                int currentItem=pager.getCurrentItem();
          //      Toast.makeText(MainActivity.this," has tocado: " + item.getTitle(),Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this," has tocado: " + id,Toast.LENGTH_SHORT).show();
              //  id= R.id.uno;
              //  Toast.makeText(MainActivity.this," El id es: " + R.id.uno,Toast.LENGTH_SHORT).show();
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

                  //  Toast.makeText(MainActivity.this,"pagina " + String.valueOf(currentItem) ,Toast.LENGTH_SHORT).show();

                    sharecompartir();
                }

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

        /*
        if(R.drawable.poesia_img3 == resourceId ){
            Toast.makeText(MainActivity.this, "Iguales", Toast.LENGTH_SHORT).show();
        }
        imagenViewJohan = new ImageView(getApplicationContext());
        imagenViewJohan.setImageResource(resourceId);
        LinearLayout.LayoutParams params = new LinearLayout
                .LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);

        // Add image path from drawable folder.
        imagenViewJohan.setLayoutParams(params);
        */
        /*
        imagenView2.setImageResource(resourceId);
        Bitmap bitmap= viewToBitmap(imagenView2,imagenView2.getWidth(),imagenView2.getHeight());
        //Bitmap bitmap= viewToBitmap(imagenViewJohan,1000,1000);
        Intent shareIntent= new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"otra2.jpg");

        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            Log.e("ERROR", e.getMessage() );
        }
        shareIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file:///sdcard/otra2.jpg"));
        startActivity(Intent.createChooser(shareIntent,"Share Imagen"));
*/     int currentItem=pager.getCurrentItem();
        resourceId = imgs.getResourceId(currentItem,-1);
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

            Toast.makeText(this, "Permisos de llamada Concedidos", Toast.LENGTH_SHORT).show();

    }



}
