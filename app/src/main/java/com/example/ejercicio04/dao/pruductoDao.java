package com.example.ejercicio04.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejercicio04.config.DBHelper;
import com.example.ejercicio04.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class pruductoDao {
    private DBHelper helper;
    private SQLiteDatabase database;
    public pruductoDao(Context context){
        helper = new DBHelper(context);
    }
    private SQLiteDatabase getDatabase(){
        if(database == null){
            database = helper.getWritableDatabase();
        }
        return database;
    }
private Producto almacenarproducto(Cursor cursor) {

@SuppressLint("Range") Producto producto = new Producto(
cursor.getInt(cursor.getColumnIndex(DBHelper.Productos.idproducto)),
cursor.getString(cursor.getColumnIndex(DBHelper.Productos.codigo)),
        cursor.getString(cursor.getColumnIndex(DBHelper.Productos.idproducto)),
        cursor.getString(cursor.getColumnIndex(DBHelper.Productos.stock)),
        cursor.getString(cursor.getColumnIndex(DBHelper.Productos.precio))
);
return producto;

}
public List<Producto> listarProductos(){
    Cursor cursor = getDatabase().query(DBHelper.Productos.TABLE,DBHelper.Productos.COLUMNAS, null, null, null, null, null);
    List<Producto> lista = new ArrayList<Producto>();

    while(cursor.moveToNext()){
        Producto modelo = almacenarproducto(cursor);
        lista.add(modelo);
    }
    return lista;
    }
public long modificarProducto(Producto producto){
    ContentValues values = new ContentValues();
    values.put(DBHelper.Productos.nombre, producto.getNombre());
    values.put(DBHelper.Productos.codigo, producto.getCodigo());
    values.put(DBHelper.Productos.precio, producto.getPrecio());
    values.put(DBHelper.Productos.stock, producto.getStock());
        if (producto.getIdproducto() != null){
            return database.update(DBHelper.Productos.TABLE, values,
                    "idproducto = ?", new String[]{producto.getIdproducto().toString()});
        }
    return getDatabase().insert(DBHelper.Productos.TABLE,null,values);

}
    public boolean eliminarProducto(int id){
        return getDatabase().delete(DBHelper.Productos.TABLE,"idproducto = ?", new String[]{Integer.toString(id)}) > 0;
    }
    public Producto buscarProductoPorID(int id) {
        Cursor cursor = getDatabase().query(DBHelper.Productos.TABLE,
                DBHelper.Productos.COLUMNAS, "idproducto = ?", new String[]{Integer.toString(id)}, null, null, null);
        if (cursor.moveToNext()) {
            Producto model = almacenarproducto(cursor);
            cursor.close();
            return model;
        }
        return null;
    }
    public void cerrarDB(){
        helper.close();
        database = null;
    }
}
