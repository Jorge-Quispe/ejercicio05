package com.example.ejercicio04.model;

public class Producto {

    private Integer idproducto;
    private String codigo;
    private String nombre;
    private String stock;
    private String precio;

    public Producto(Integer idproducto, String codigo, String nombre, String stock, String precio) {
        this.idproducto = idproducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getStock() {
        return stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
