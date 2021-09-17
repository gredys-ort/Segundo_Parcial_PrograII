/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Gredys
 */
public class Usuario {
    private int IdUsuario;
    private String Username;
    private int Password;
    
    public Usuario(){
        
    }
    
    public Usuario(int IdUsuario){
        this.IdUsuario=IdUsuario;
    }
    
    public Usuario(int IdUsuario,String Username,int Password){
        this.IdUsuario=IdUsuario;
        this.Password=Password;
        this.Username=Username;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "IdUsuario=" + IdUsuario + ", Username=" + Username + ", Password=" + Password + '}';
    }
    
    
    
    
    
    
}
