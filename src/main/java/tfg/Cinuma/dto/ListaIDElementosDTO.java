/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import java.util.List;

/**
 *
 * @author jsnie
 */
public class ListaIDElementosDTO {
    private List<String> idElementos;

    public ListaIDElementosDTO(List<String> idElementos) {
        this.idElementos = idElementos;
    }

    public ListaIDElementosDTO() {
    }

    public List<String> getIdElementos() {
        return idElementos;
    }

    public void setIdElementos(List<String> idElementos) {
        this.idElementos = idElementos;
    }
}
