/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import tfg.Cinuma.Modelo.Elemento;

/**
 *
 * @author jsnie
 */
public class ListaElementosDTO {
    private Elemento elementos[];

    public ListaElementosDTO(Elemento[] elementos) {
        this.elementos = elementos;
    }

    public ListaElementosDTO() {
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public void setElementos(Elemento[] elementos) {
        this.elementos = elementos;
    }
    
    
}
