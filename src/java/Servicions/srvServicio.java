/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package Servicions;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Modelo.csSolicitante;
/**
 *
 * @author Aroni
 */
@WebService(serviceName = "NewWebService")
public class srvServicio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Incertar")
    public int insertar(@WebParam(name = "idsolicitante") int idsolicitante, @WebParam(name = "dpi") int dpi,
            @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido){
        csSolicitante s = new csSolicitante();
        return s.insertar(nombre, apellido, dpi, idsolicitante);
    }
}