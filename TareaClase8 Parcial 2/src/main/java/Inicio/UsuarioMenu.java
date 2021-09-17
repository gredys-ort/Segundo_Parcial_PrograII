/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Interfaz.Intefaces;
import datos.UsuarioJDBC;
import dominio.Usuario;
import java.sql.*;

import java.util.*;

/**
 *
 * @author Gredys
 */
public class UsuarioMenu {

    public static void ej1() {
        //paso 1 definir el string de conexion
        String url = "jdbc:mysql://localhost:3306/dbvendedores?zeroDateTimeBehavior=CONVERT_TO_NULL";

        try {
            //paso 2 crear el obj conexion
            Connection conexion = DriverManager.getConnection(url, "root", "MYSQL2021");
            //paso 3 crear el obj statement
            Statement sentencia = conexion.createStatement();
            //paso 4 crear instruccion sql
            String sql = "select * from usuario";
            //paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);

            //paso 6 procesar el resultado
            while (resultado.next()) {
                System.out.println("IdUsuario=" + resultado.getInt(1));
                System.out.println("Username=" + resultado.getString(2));
                System.out.println("Password=" + resultado.getInt(3));

            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }
    }

    public static void insert() {
        UsuarioJDBC UserJDBC = new UsuarioJDBC();
        Usuario insert = new Usuario();

        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese Username");
        String Username = t.nextLine();

        System.out.println("Ingrese Password");
        int Password = t.nextInt();

        insert.setUsername(Username);
        insert.setPassword(Password);
        UserJDBC.insert(insert);

        List<Usuario> todos = UserJDBC.select();

        for (Usuario usuario : todos) {
            System.out.println("Usuario = " + usuario);
        }
    }

    public static void borrador() {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        Usuario delete = new Usuario();
        Scanner t = new Scanner(System.in);

        System.out.println("Ingrese el ID del Usuario");
        int Id = t.nextInt();

        delete.setIdUsuario(Id);
        usuarioJDBC.delete(delete);

        List<Usuario> todos = usuarioJDBC.select();

        for (Usuario usuario : todos) {
            System.out.println("Usuario = " + usuario);
        }

    }

    public static void seleccionar() {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        List<Usuario> todos = usuarioJDBC.select();

        for (Usuario ven : todos) {
            System.out.println("Usuario:" + ven);
        }

    }

    public static void actualizar() {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        Usuario actua = new Usuario();
        Scanner t = new Scanner(System.in);

        System.out.println("Ingrese el Username");
        String Username = t.nextLine();

        System.out.println("Ingrese el Password");
        int Password = t.nextInt();

        System.out.println("Ingrese el Id");
        int Id = t.nextInt();

        actua.setUsername(Username);
        actua.setPassword(Password);
        actua.setIdUsuario(Id);

        usuarioJDBC.update(actua);

        List<Usuario> todos = usuarioJDBC.select();

        for (Usuario usuario : todos) {
            System.out.println("usuario = " + usuario);
        }
    }

    public static void main(String[] args) {
        Intefaces inte = new Intefaces();
        inte.setVisible(true);
    }

}
