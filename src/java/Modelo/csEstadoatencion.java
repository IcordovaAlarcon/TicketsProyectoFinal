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

/**
 *
 * @author Aroni
 */
public class csEstadoatencion {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
        public int insertar(String estado, int idestado){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.estado(idestado, estado) "
                + "values(" + idestado + ", '"+ estado +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta;
        }
    
    public int actualizarestadoatencion(int idEstado, String estado) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.estadoatencion SET "
 + "estado = '" + estado + "' "
 + "where idestado = " + idEstado);
 cl.desconectar();
 con.close();
 stm.close();
 } 
catch (Exception ex) 
{
 }
 return respuesta;
}

 public int eliminarestado (int idestado)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.estado where idestado="+ idestado);
cl.desconectar();
con.close();
stm.close();
}
catch (Exception ex)
{

}   
return respuesta;    
}
 
     public ArrayList<Select_Estado> listarEstado(){
        
    Select_Estado S = null;
    ArrayList<Select_Estado> lista = new ArrayList<Select_Estado>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.estadoatencion");
        
        while(rs.next()){
        S = new Select_Estado(rs.getInt(1), rs.getString("estado"));
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