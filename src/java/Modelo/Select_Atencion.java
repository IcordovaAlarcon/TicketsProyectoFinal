/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Aroni
 */
public class Select_Atencion {
        private int idatencion,idempresa, idmotivo, idestado, idticket;
    private String descripcion;
    
    
    public Select_Atencion (int idatencion, String descripcion, int idempresa,int idmotivo, int idestado, int idticket){
        this.idatencion = idatencion;
        this.descripcion = descripcion;
        this.idempresa = idempresa;
        this.idmotivo = idmotivo;
        this.idestado = idestado;
        this.idticket = idticket;
    }

    public int getIdatencion() {
        return idatencion;
    }

    public void setIdatencion(int idatencion) {
        this.idatencion = idatencion;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(int idmotivo) {
        this.idmotivo = idmotivo;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
