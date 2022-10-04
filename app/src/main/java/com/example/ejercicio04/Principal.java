package com.example.ejercicio04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ejercicio04.dao.ProductoDao;
import com.example.ejercicio04.model.Producto;

public class Principal extends AppCompatActivity {
    private EditText codigo, edtNombre, precio, stock;
    private ProductoDao productoDao;
    private Producto producto;
    private int idproducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        productoDao = new ProductoDao(this);
        codigo = (EditText) findViewById(R.id.);

        edtNombre = (EditText) findViewById(R.id.txtNombre);
        precio = (EditText) findViewById(R.id.txtUser);
        stock = (EditText) findViewById(R.id.txtClave);
    }
}