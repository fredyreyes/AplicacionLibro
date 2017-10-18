package com.example.fredy.aplicacionlibro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by koanc on 16/10/2017.
 */

public class Favorites extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Favoritos (identificacion INTEGER, urlImagen TEXT)";

    public Favorites(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Favoritos");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
