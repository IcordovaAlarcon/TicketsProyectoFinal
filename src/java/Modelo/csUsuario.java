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
public class csUsuario {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
        public int insertar(String nombre, String contraseña, int idsolicitante, int idusuario){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.usuario(idusuario, idsolicitante, nombre, contraseña) "
                + "values(" + idusuario + ", "+ idsolicitante +", '"+ nombre +"', '"+ contraseña +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta;
        }
    
    public int actualizarUsuario(int idUsuario, int idSolicitante, String nombre, String 
contraseña) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.usuario SET "
 + "nombre = '" + nombre + "', "
 + "contraseña = '" + contraseña + "' "
 + "WHERE idusuario = " + idUsuario + " "
 + "AND idsolicitante = " + idSolicitante)
;
 cl.desconectar();
 con.close();
 stm.close();
 }
catch (Exception ex) {
 }
 return respuesta;
}

    public int eliminarusuario (int idusuario)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.usuario where idusuario="+
idusuario + " ");
cl.desconectar();
con.close();
stm.close();
}
catch (Exception ex)
{
    }
return respuesta;
}

        public ArrayList<Select_Usuario> listarUsuario(){
        
    Select_Usuario S = null;
    ArrayList<Select_Usuario> lista = new ArrayList<Select_Usuario>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.usuario");
        
        while(rs.next()){
        S = new Select_Usuario(rs.getInt(1), rs.getInt(2), rs.getString("nombre"), rs.getString("contraseña"));
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
