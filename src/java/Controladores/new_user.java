/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Datos.Usuario;
import Persistencia.DBQuerys;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author dorianivc
 */
public class new_user extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
         rd.forward(request, response);
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("Apellido");
        String password= request.getParameter("password");
        String tipo_usuario=request.getParameter("tipo_usuario");
        String cedula= request.getParameter("cedula");
        Integer tipo_user= Integer.parseInt(tipo_usuario);
        Usuario usuario = new Usuario();
        usuario.setCedula(cedula);
        if(apellido != null){
            usuario.setNombre(nombre+" "+ apellido);
        }else{
            usuario.setNombre(nombre);
        }
        usuario.setPassword(password);
        usuario.setTipoUsuario(tipo_user);
        DBQuerys querys= new DBQuerys();
         
        try {
            querys.crer_usuario(usuario);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
