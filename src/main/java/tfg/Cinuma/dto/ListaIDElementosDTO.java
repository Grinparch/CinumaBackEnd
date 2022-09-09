/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

/**
 *
 * @author jsnie
 */
public class ListaIDElementosDTO {
    private String idElementos[];

    public ListaIDElementosDTO(String[] idElementos) {
        this.idElementos = idElementos;
    }

    public ListaIDElementosDTO() {
    }

    public String[] getIdElementos() {
        return idElementos;
    }

    public void setIdElementos(String[] idElementos) {
        this.idElementos = idElementos;
    }
}
