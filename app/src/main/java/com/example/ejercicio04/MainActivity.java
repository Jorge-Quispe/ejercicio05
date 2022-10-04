package com.example.ejercicio04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ejercicio04.adapter.ProductoAdapter;
import com.example.ejercicio04.dao.ProductoDao;
import com.example.ejercicio04.model.Producto;
import com.example.ejercicio04.util.Mensajes;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {
    private ListView lista1;
    private List<Producto> listaList;
    private ProductoAdapter adapter;
    private ProductoDao productoDao;
    private int idposi;
    private AlertDialog alertDialog, alertconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog = Mensajes.crearAlertaDialog(this);
        alertDialog = Mensajes.crearAlertaDialog(this);
        alertconfirm = Mensajes.crearDialogConfirmacion(this);
        productoDao = new ProductoDao(this);
        listaList = productoDao.listarProductos();
        adapter = new ProductoAdapter(this,listaList);

        lista1 = (ListView) findViewById(R.id.lvLista);
        lista1.setAdapter(adapter);

        lista1.setOnItemClickListener(this);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_productos, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menu_guardar) {
            startActivity(new Intent(this, Principal.class));
        }
        if(id==R.id.action_menu_salir1){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(DialogInterface dialog, int which) {
        int id = listaList.get(idposi).getIdproducto();
        switch (which){
            case 0:
                Intent intent = new Intent(this, Principal.class);
                intent.putExtra("idproducto",id);
                startActivity(intent);
                break;
            case 1:alertconfirm.show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                listaList.remove(idposi);
                productoDao.eliminarProducto(id);
                lista1.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                alertconfirm.dismiss();break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idposi = position;
        alertDialog.show();
    }
}