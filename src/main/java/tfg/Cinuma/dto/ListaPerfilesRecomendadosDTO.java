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
public class ListaPerfilesRecomendadosDTO {
    private List<String> idPerfiles;

    public ListaPerfilesRecomendadosDTO(List<String> idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public ListaPerfilesRecomendadosDTO() {
    }

    public List<String> getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(List<String> idPerfiles) {
        this.idPerfiles = idPerfiles;
    }


}
