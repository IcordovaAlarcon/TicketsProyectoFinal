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
public class csEmpresa {
 private Connection con;
    private Statement stm;
    private ResultSet rs;

        public int insertar(String nombre, String direccion, String sucursal, int idempresa){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.empresa(idempresa, nombre, direccion, sucursal) "
                + "values(" + idempresa + ", '"+ nombre +"', '"+ direccion +", '"+ sucursal +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta;
        }
    
public int actualizarEmpresa(int idEmpresa, String nombre, String direccion, String 
sucursal) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.empresa SET "
 + "nombre = '" + nombre + "', "
 + "direccion = '" + direccion + "', "
 + "sucursal = '" + sucursal + "' "
 + "WHERE idempresa = " + idEmpresa) 
 ;
 
 cl.desconectar();
 con.close();
 stm.close();
 } 
 catch (Exception ex) {
 }
return respuesta;
}

public int eliminarempresa (int idempresa)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.empresa where idempresa="+
idempresa + " ");
cl.desconectar();
con.close();
stm.close();
}
catch (Exception ex)
{
}
return respuesta;
}

    public ArrayList<Select_Empresa> listarSolicitante(){
        
    Select_Empresa S = null;
    ArrayList<Select_Empresa> lista = new ArrayList<Select_Empresa>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.empresa");
        
        while(rs.next()){
        S = new Select_Empresa(rs.getInt(1), rs.getString("nombre"), rs.getString("direccion"), rs.getString("sucursal"));
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

