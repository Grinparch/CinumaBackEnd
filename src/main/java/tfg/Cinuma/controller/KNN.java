/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.ArrayList;
import java.util.List;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.Modelo.Usuario;

/**
 *
 * @author jsnie
 */
public class KNN {
    int k;

    public KNN(int k) {
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
    
    public List<String> usuariosMasCercanos(List<Float> listaPuntuacion, List<String> listaAOrdenar){
        float tempPunt;
        String tempPer;
        
        if(k>listaPuntuacion.size()){
            setK(listaPuntuacion.size());
        }
        
        for (int m = 0; m < listaPuntuacion.size();m++) {
            for (int n = 0; n < listaPuntuacion.size();n++) {
                if(n+1<listaPuntuacion.size()-1){
                    if(listaPuntuacion.get(n)<listaPuntuacion.get(n+1)){
                        tempPunt = listaPuntuacion.get(n);
                        tempPer  = listaAOrdenar.get(n);
                        listaPuntuacion.set(n, listaPuntuacion.get(n+1));
                        listaPuntuacion.set(n+1, tempPunt);
                        listaAOrdenar.set(n, listaAOrdenar.get(n+1));
                        listaAOrdenar.set(n+1, tempPer);
                    }
                }
            }
        }
        
        List<String> listaADevolver = new ArrayList<>();
        
        for(int i=0;i<k;i++){
            listaADevolver.add(i, listaAOrdenar.get(i));
        }
        
        return listaADevolver;
    }

    
}
