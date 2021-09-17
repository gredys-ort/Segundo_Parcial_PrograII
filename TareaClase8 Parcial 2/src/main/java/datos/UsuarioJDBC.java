/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Interfaz.Intefaces;
import dominio.Usuario;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Gredys
 */
public class UsuarioJDBC {
    private static final String SQL_SELECT = "select * from usuario";
    private static final String SQL_INSERT = "insert into usuario (Username,Password) " + " values (?,?)";
    private static final String SQL_UPDATE = "update usuario set Username=?, Password=?" + " where IdUsuario=?";
    private static final String SQL_DELETE = "delete from usuario where IdUsuario=?";
    private static final String SQL_SELECT_VALIDACION = "select * from usuario where Username=?" + " and Password=?";
    
    public List<Usuario> select(){
        Connection conn= null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Usuario usuario=null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        try{
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int IdUsuario = rs.getInt("IdUsuario");
                String Username = rs.getString("Username");
                int Password = rs.getInt("Password");
                
                usuario = new Usuario();
                usuario.setIdUsuario(IdUsuario);
                usuario.setUsername(Username);
                usuario.setPassword(Password);
                
                usuarios.add(usuario);
            }
            
        } catch (SQLException ex){
            
            ex.printStackTrace(System.out);
            
        } finally{
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return usuarios;
    }
    
    
    public boolean select_validacion(Usuario datos){
        Connection conn= null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Usuario usuario= new Usuario();
        
        boolean tiene_permiso = false;
        
     try{
            conn = ClsConexion.getConnection();
            Intefaces inter = new Intefaces();
            inter.txtUsername.getText();
            inter.txtPassword.getText(); 
            String condicion = SQL_SELECT + " where Username ='"+ datos.getUsername()+"'" + " and password = '"+ datos.getPassword()+"'";
            stmt = conn.prepareStatement(condicion);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                tiene_permiso= true;
                int IdUsuario = rs.getInt("IdUsuario");
                String Username = rs.getString("Username");
                int Password = rs.getInt("Password");
                
                usuario = new Usuario();
                usuario.setIdUsuario(IdUsuario);
                usuario.setUsername(Username);
                usuario.setPassword(Password);
                
                
            }
            
        } catch (SQLException ex){
            
            ex.printStackTrace(System.out);
            
        } finally{
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return tiene_permiso;
    }
    
    
    public int insert(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setInt(2, usuario.getPassword());
            System.out.println("Ejecutando Cuerito"+ SQL_SELECT);
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        } finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
        
    }
    public int delete(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            System.out.println("Ejecutando Cuerito"+ SQL_DELETE);
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        } finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
    
    public int update(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setInt(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuario());
            

            System.out.println("ejecutando cuerito:" + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }
    
    
}
        
        

