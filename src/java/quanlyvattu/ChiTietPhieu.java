/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyvattu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ChiTietPhieu {
    int ma_phieu;
    String mavt;
    int soluong;
    float dongia;
    float trigia;

    public ChiTietPhieu() {
    }

    public ChiTietPhieu(int ma_phieu, String mavt, int soluong, float dongia, int trigia) {
        this.ma_phieu = ma_phieu;
        this.mavt = mavt;
        this.soluong = soluong;
        this.dongia = dongia;
        this.trigia = trigia;
    }

    public ChiTietPhieu(int ma_phieu, String mavt, int soluong, float dongia) {
        this.ma_phieu = ma_phieu;
        this.mavt = mavt;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getMaPhieu() {
        return ma_phieu;
    }

    public String getMavt() {
        return mavt;
    }

    public int getSoluong() {
        return soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public float getTrigia() {
        return trigia;
    }

    public void setTrigia(float trigia) {
        this.trigia = trigia;
    }
    
    public boolean nhapCTPhieu(){
       CSDL.moKetNoi("vattu", "root", "root");
       trigia=dongia*soluong;
       String sql="insert into ct_phieu values("+ma_phieu+",'"+mavt+"',"+soluong+","+dongia+","+trigia+")";
       boolean kq=true;
       try{
           CSDL.stm.executeUpdate(sql);
           System.out.println("nhap phieu thanh cong");
       }catch(SQLException sqlEx){
           kq=false;
           System.out.println(sqlEx.getMessage());
       }
       CSDL.dongKetNoi();
       return kq;
       
    }
    public static List<ChiTietPhieu> xemDanhSachChiTietPhieu(){
        CSDL.moKetNoi("vattu", "root", "root");
        String sql="select *from ct_phieu";
        List<ChiTietPhieu> list= new ArrayList();
        try{
            ResultSet rs=CSDL.stm.executeQuery(sql);
            while(rs.next()){
                ChiTietPhieu ctphieu= new ChiTietPhieu(rs.getInt("ma_phieu"),
                rs.getString("mavt"), rs.getInt("soluong"),rs.getInt("dongia"),
                rs.getInt("trigia"));
                list.add(ctphieu);
            }
        }catch(SQLException sqlEx){
            list=null;
            System.out.println(sqlEx.getMessage());
        }
        CSDL.dongKetNoi();
        return list;
    }
    
    public static void main (String []arr){
     
        
        ChiTietPhieu ctphieu1=new ChiTietPhieu(124,"cn1",12,12000);
        ctphieu1.trigia=ctphieu1.getSoluong()*ctphieu1.getDongia();
        ctphieu1.nhapCTPhieu();
        
    }
   
}
