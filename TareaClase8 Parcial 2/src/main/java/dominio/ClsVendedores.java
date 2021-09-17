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
public class ClsVendedores {
    private int Codigo;
    private String Nombre;
    private int Enero;
    private int Febrero;
    private int Marzo;

    @Override
    public String toString() {
        return "ClsVendedores{" + "Codigo=" + Codigo + ", Nombre=" + Nombre + ", Enero=" + Enero + ", Febrero=" + Febrero + ", Marzo=" + Marzo + '}';
    }
    
    

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEnero() {
        return Enero;
    }

    public void setEnero(int Enero) {
        this.Enero = Enero;
    }

    public int getFebrero() {
        return Febrero;
    }

    public void setFebrero(int Febrero) {
        this.Febrero = Febrero;
    }

    public int getMarzo() {
        return Marzo;
    }

    public void setMarzo(int Marzo) {
        this.Marzo = Marzo;
    }
    
    
}
