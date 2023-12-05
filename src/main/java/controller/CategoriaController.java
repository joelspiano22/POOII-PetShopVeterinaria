/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */

public class CategoriaController {
    private List<String> cate=new ArrayList<>();
    private final String directoryRoute="./src/main/java/data/";
    private final String fileName="categoria.csv";
    
    public CategoriaController() {
        cargar();
    }

    public List<String> getCategorias() {
        return cate;
    }

    public void setCategorias(List<String> cate) {
        this.cate = cate;
    }
    public int size()
    {
        return cate.size();
    }
    public void cargar()
    {
        try{
            BufferedReader br;
            String linea = null;
            String[] array = null;
            
            br = new BufferedReader(new FileReader(directoryRoute+fileName));
            
            while((linea = br.readLine())!= null){
                array = linea.split(";");
                for(String x: array)
                {
                    cate.add(x.trim());
                }
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}