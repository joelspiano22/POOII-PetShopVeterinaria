/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Mascotas;

/**
 *
 * @author Esteban Avendaño
 */
public class MascotasController {
    //private ArrayList<Mascotas> lstM;
    List<Mascotas> lstM = new ArrayList<>();
    private final String fileName = "Mascota.csv";
    
    
    public MascotasController()
    {
        //lstM = new ArrayList<>();
        cargar();
    }
    
    public MascotasController(ArrayList<Mascotas> lstM) {
        this.lstM = lstM;
        cargar();
    }

    public List<Mascotas> getProducto() {
        return lstM;
    }

    public void setProducto(ArrayList<Mascotas> producto) {
        this.lstM = lstM;
    }
    
    public void add(Mascotas obj)
    {
        lstM.add(obj);
    }
    
    public Mascotas get(int pos)
    {
        return lstM.get(pos);
    }
    
    public void set(Mascotas obj, int i) {
        lstM.set(i, obj);
    }
    
    public int size()
    {
        return lstM.size();
    }
    
    public void remove(Mascotas obj)
    {
        lstM.remove(obj);
    }
    
    public void remove(int i) {
        lstM.remove(i);
    }
    
    public int getCorrelativo(){
       if(size() == 0)
           return 1;
       else{
          return size() + 1;
       }
    }
    
    public Mascotas buscar(int cod)
    {
        for(Mascotas x:lstM)
            if(x.getCod() == cod)
                return x;
        return null;//No lo encontro
    }
    
    //funcion para grabar en el archivo csv
    public void grabar(){
      try{  
         PrintWriter pw;
         String linea;
         pw = new PrintWriter(new FileWriter("Mascota.csv"));         
         for(int i=0;i<size();i++){
             linea = (lstM.get(i).getCod() + ";" +
                      get(i).getDes() + ";" +
                     get(i).getPrecio() + ";" +
                     get(i).getStock() + ";" +
                     get(i).getCate()
                     );
             pw.println(linea); 
         }  
         pw.close();
      }
      catch(IOException e){
         System.out.println(e.getMessage());
      }      
    }
    
    //funcion para cargar los datos del archivo al arreglo
    public void cargar(){
        try{
           BufferedReader br;
           String linea = null;
           String[] array = null;
           br = new BufferedReader(new FileReader("Mascota.csv"));

           while((linea = br.readLine())!= null){
             array = linea.split(";");
             Mascotas a = new Mascotas
                       (Integer.parseInt(array[0].trim()),
                       array[1].trim(),
                       Double.parseDouble(array[2].trim()),
                       Double.parseDouble(array[3].trim()),
                       array[4].trim());


             add(a);
           }
           br.close();
        }
        catch(IOException e){
          System.out.println(e.getMessage());
        }
    }
    
    
}
