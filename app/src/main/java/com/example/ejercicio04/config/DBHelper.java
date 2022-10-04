package com.example.ejercicio04.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "producto.bd";
    private static final String TABLE_PRODUCTO = "producto";


    public DBHelper( Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTO + "( "+  "idproducto integer primary key autoincrement, "
        + "codigo text not null ," + "nombre text not null," + "stock text not null," + "precio text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

public static class Productos{
public static final String TABLE = "pruductos";
    public static final String idproducto = "idproducto";
    public static final String codigo = "codigo";
    public static final String nombre = "nombre";
    public static final String stock = "stock";
    public static final String precio = "precio";
    public static final String[] COLUMNAS = new String[]{idproducto,codigo,nombre,stock,precio};
    }
}
