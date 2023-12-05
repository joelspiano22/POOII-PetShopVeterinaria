/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Avendaño
 */

public class Categoria {

    public Categoria() {
    }
    
    public int sumarStock(List<Mascotas> x) {
        int suma = 0;
        for (Mascotas y : x) {
            suma += y.getStock();
        }
        return suma;
    }
     
    public Mascotas precioMenor(List<Mascotas> x) {
        if (x.size() <= 0) {
            return null;
        }

        Mascotas menor = x.get(0);
        for (Mascotas y : x) {
            if (menor.getPrecio()> y.getPrecio()) {
                menor = y;
            }
        }
        return menor;
    }
        
        public ArrayList<ArrayList<Object>> getCoincidenciasDeTipo(List<Mascotas> bd) {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<ArrayList<Object>> salida = new ArrayList<>();
        boolean encontrado = false;
        for (Mascotas x : bd) {
            encontrado = false;
            for (String a : nombres) {
                if (a.equalsIgnoreCase(x.getCate())) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                nombres.add(x.getCate());
            }
        }
        int temporalInt;

        for (String a : nombres) {
            ArrayList<Object> temporal = new ArrayList<>();
            temporal.clear();
            temporalInt = 0;
            temporal.add(a);
            for (Mascotas x : bd) {
                if (a.equalsIgnoreCase(x.getCate())) {
                    temporalInt++;
                }
            }
            temporal.add(temporalInt);
            salida.add(temporal);
        }

        return salida;
    }   
}
