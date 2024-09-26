/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Aroni
 */
public class Select_Escritorio {
    
        private int idescritorio, idempleado;
    private String sistema;
    
    
    public Select_Escritorio (int idescritorio, String sistema, int idempleado){
        this.idescritorio = idescritorio;
        this.sistema = sistema;
        this.idempleado = idempleado;

        
    }

    public int getIdescritorio() {
        return idescritorio;
    }

    public void setIdescritorio(int idescritorio) {
        this.idescritorio = idescritorio;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
    
    
    
}
