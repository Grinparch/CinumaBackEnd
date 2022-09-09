/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

/**
 *
 * @author jsnie
 */
public class ListaIDUsuariosDTO {
    private String idUsuarios[];

    public ListaIDUsuariosDTO(String[] idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public ListaIDUsuariosDTO() {
    }

    public String[] getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String[] usuarios) {
        this.idUsuarios = usuarios;
    }
}
