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
public class csEmpleado {
     private Connection con;
    private Statement stm;
    private ResultSet rs;
    
        public int insertar(String nombre, String apellido, int dpi, String puesto, int idempleado){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.solicitante(idempleado, nombre, apellido, dpi, puesto) "
                + "values(" + idempleado +", '"+ nombre +"', '"+ apellido  +","+ dpi +",'"+ puesto +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta;
        }
        
public int actualizarempleado(int idEmpleado, String nombre, String apellido, int 
dpi, String puesto) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.empleado SET "
 + "nombre = '" + nombre + "', "
 + "apellido = '" + apellido + "', "
 + "dpi = " + dpi + ", "
 + "puesto = '" + puesto + "' "
 + "WHERE idempleado = " + idEmpleado )
; 
 cl.desconectar();
 con.close();
 stm.close();
 } catch (Exception ex) {
 } 
 return respuesta;
}
public int eliminarempleado (int idempleado)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.empleado where idempleado="+
idempleado + " ");
cl.desconectar();
con.close();
stm.close();
}
catch (Exception ex)
{
        
}
return respuesta;
 }
    public ArrayList<Select_Empleado> listarEmpleado(){
        
    Select_Empleado S = null;
    ArrayList<Select_Empleado> lista = new ArrayList<Select_Empleado>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.empleado");
        
        while(rs.next()){
        S = new Select_Empleado(rs.getInt(1), rs.getString("nombre"), rs.getString("apellido"), rs.getInt(4), rs.getString("puesto"));
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

