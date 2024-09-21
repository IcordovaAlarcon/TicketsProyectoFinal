/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aroni
 */
public class csSolicitante {
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    
    public csSolicitante(){
        this.con=null;
        this.stm=null;
    }
    
    public int insertar(String nombre, String apellido, int dpi, int idsolicitante){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.solicitante(idsolicitante, dpi, nombre, apellido) "
                + "values(" + idsolicitante + ", "+ dpi +", '"+ nombre +"', '"+ apellido +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        
        return respuesta;
    }
    public int actualizarSolicitante(String nombre, String apellido, int dpi, int idSolicitante)
 {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
    
    try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate ("update Ticket.dbo.solicitante SET nombre = '" + nombre + "', " + "apellido = '" + apellido + "', " + "dpi = " + dpi + " " + "WHERE idsolicitante = " + idSolicitante);    
        c1.desconectar();
        con.close();
        stm.close();
    } catch (Exception ex) {
    }
    return respuesta;
  }
   
    public ArrayList<Select_Solicitante> listarSolicitante(){
        
    Select_Solicitante S = null;
    ArrayList<Select_Solicitante> lista = new ArrayList<Select_Solicitante>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.solicitante");
        
        while(rs.next()){
        S = new Select_Solicitante(rs.getInt(1), rs.getInt(2), rs.getString("nombre"), rs.getString("apellido"));
        lista.add(S);
        }
        c1.desconectar();
        con.close();
        stm.close();
    }
    catch (Exception ex){
        
    }
    return lista;
}
}


