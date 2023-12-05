/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Esteban Avendaño
 */
public class Mascotas {
    private int cod;
    private String des;
    private double precio;
    private double stock;
    private String cate;
    
    public Mascotas() {
        
    }

    public Mascotas(int cod, String des, double precio, double stock, String cate) {
        this.cod = cod;
        this.des = des;
        this.precio = precio;
        this.stock = stock;
        this.cate = cate;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
}
