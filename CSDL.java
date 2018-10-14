package quanlyvattu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class CSDL {
    static Connection con;
    static Statement stm;
    public static void moKetNoi(String database, String username, String pass){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, username, pass);
            stm=con.createStatement();
            System.out.println("Mo ket noi thanh cong");
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public static void dongKetNoi(){
        try{
            con.close();
            stm.close();
            System.out.println("Dong ket noi thanh cong");
        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    public static void main (String []arr){
        CSDL.moKetNoi("vattu", "root", "root");
        CSDL.dongKetNoi();
    }
}
