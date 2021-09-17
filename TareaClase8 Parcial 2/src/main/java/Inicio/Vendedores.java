/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Interfaz.Intefaces2;
import datos.ClsVendedorJDBC;
import dominio.ClsVendedores;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gredys
 */
public class Vendedores {

    public static void ej1() {
        //paso 1 definir el string de conexion
        String url = "jdbc:mysql://localhost:3306/dbvendedores?zeroDateTimeBehavior=CONVERT_TO_NULL";

        try {
            //paso 2 crear el obj conexion
            Connection conexion = DriverManager.getConnection(url, "root", "MYSQL2021");
            //paso 3 crear el obj statement
            Statement sentencia = conexion.createStatement();
            //paso 4 crear instruccion sql
            String sql = "select * from tb_vendedores";
            //paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);

            //paso 6 procesar el resultado
            while (resultado.next()) {
                System.out.println("Codigo=" + resultado.getInt(1));
                System.out.println("Nombre=" + resultado.getString(2));
                System.out.println("Enero=" + resultado.getInt(3));
                System.out.println("Febrero=" + resultado.getInt(4));
                System.out.println("Marzo=" + resultado.getInt(5));
            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }
    }


//    public static void borrador() {
//        ClsVendedorJDBC vendedorJDBC = new ClsVendedorJDBC();
//        ClsVendedores delete = new ClsVendedores();
//        Scanner t = new Scanner(System.in);
//
//        System.out.println("Ingrese el Codigo de Vendedor a Eliminar");
//        int codigo = t.nextInt();
//
//        delete.setCodigo(codigo);
//        vendedorJDBC.delete(delete);
//
//        List<ClsVendedores> todos = vendedorJDBC.seleccion();
//
//        for (ClsVendedores vendedor : todos) {
//            System.out.println("vendedor = " + vendedor);
//        }
//
//    }

//    public static void seleccionar() {
//        ClsVendedorJDBC vendedorJDBC = new ClsVendedorJDBC();
//        List<ClsVendedores> todos = vendedorJDBC.seleccion();
//
//        for (ClsVendedores ven : todos) {
//            System.out.println("Vendedor:" + ven);
//        }
//
//    }

//    public static void actualizar() {
//        ClsVendedorJDBC vendedorJDBC = new ClsVendedorJDBC();
//        ClsVendedores actua = new ClsVendedores();
//        Scanner t = new Scanner(System.in);
//
//        System.out.println("Ingrese el Nombre");
//        String nombre = t.nextLine();
//
//        System.out.println("Ingrese enero");
//        int enero = t.nextInt();
//
//        System.out.println("Ingrese febrero");
//        int febrero = t.nextInt();
//
//        System.out.println("Ingrese marzo");
//        int marzo = t.nextInt();
//
//        System.out.println("Ingrese el Codigo de Vendedor");
//        int codigo = t.nextInt();
//
//        actua.setNombre(nombre);
//        actua.setEnero(enero);
//        actua.setFebrero(febrero);
//        actua.setMarzo(marzo);
//        actua.setCodigo(codigo);
//        vendedorJDBC.update(actua);
//
//        List<ClsVendedores> todos = vendedorJDBC.seleccion();
//
//        for (ClsVendedores vendedor : todos) {
//            System.out.println("vendedor = " + vendedor);
//        }
//    }

}

        