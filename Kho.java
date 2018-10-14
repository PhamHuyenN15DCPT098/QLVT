/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyvattu;

import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Kho {
    String makho;
    String tenkho;
    String diachi;

    public Kho() {
    }
    public Kho(String makho, String tenkho, String diachi) {
        this.makho = makho;
        this.tenkho = tenkho;
        this.diachi = diachi;
    }

    public String getMakho() {
        return makho;
    }

    public String getTenkho() {
        return tenkho;
    }

    public String getDiachi() {
        return diachi;
    }
    public static List<Kho> layDanhSachKho(){
        CSDL.moKetNoi("vattu", "root", "root");
        String sql="select * from kho";
        List<Kho> list= new ArrayList();
        try{
            ResultSet rs=CSDL.stm.executeQuery(sql);
            while(rs.next()){
                Kho kho= new Kho(rs.getString("makho"), rs.getString("tenkho"), rs.getString("diachi"));
                list.add(kho);
            }
        }catch(SQLException sqlEx){
            list=null;
            System.out.println(sqlEx.getMessage());
        }
        CSDL.dongKetNoi();
        return list;
    }
    public static Kho layDThongTinKhoTheoMa(String makho){
        CSDL.moKetNoi("vattu", "root", "root");
        String sql="select * from kho where makho='"+makho+"'";
        Kho kho=null;
        try{
            ResultSet rs=CSDL.stm.executeQuery(sql);
            if (rs.next()){
                kho= new Kho(rs.getString("makho"), rs.getString("tenkho"), rs.getString("diachi"));
            }
        }catch(SQLException sqlEx){
            System.out.println(sqlEx.getMessage());
        }
        CSDL.dongKetNoi();
        return kho;
    }
    @Override
    public String toString(){
        return makho+"-"+tenkho+"-"+diachi;
    }
    public static void main(String []arr){
        List<Kho> list= Kho.layDanhSachKho();
        for (Kho kho:list){
            System.out.println(kho);
        }
    }
}
