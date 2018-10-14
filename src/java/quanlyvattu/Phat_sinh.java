/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyvattu;

import java.sql.SQLException;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author USER
 */
public class Phat_sinh {
    int so_phieu;
    String day;
    char loai;
    String ho_ten_khach_hang;
    String manv;
    String makho;

    public Phat_sinh() {
    }

    public Phat_sinh(int so_phieu, String day, char loai, String ho_ten_khach_hang, String manv, String makho) {
        this.so_phieu = so_phieu;
        this.day = day;
        this.loai = loai;   //   nhap/xuat
        this.ho_ten_khach_hang = ho_ten_khach_hang;
        this.manv = manv;
        this.makho = makho;
    }

    public int getSo_phieu() {
        return so_phieu;
    }

    public String getDay() {
        return day;
    }

    public char getLoai() {
        return loai;
    }

    public String getHo_ten_khach_hang() {
        return ho_ten_khach_hang;
    }

    public String getManv() {
        return manv;
    }

    public String getMakho() {
        return makho;
    }

    public void setSo_phieu(int so_phieu) {
        this.so_phieu = so_phieu;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setLoai(char loai) {
        this.loai = loai;
    }

    public void setHo_ten_khach_hang(String ho_ten_khach_hang) {
        this.ho_ten_khach_hang = ho_ten_khach_hang;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setMakho(String makho) {
        this.makho = makho;
    }
    
    public boolean addPhieu(){
        CSDL.moKetNoi("vattu", "root", "root");
        String sql = "Insert into phatsinh (ngay, loai, hotenkh, manv, makho) values ('"+day+"','"+loai+"','"+ho_ten_khach_hang+"','"+manv+"','"+makho+"')";
        boolean kq = true;
        try{
            CSDL.stm.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            kq = false;
        }
        CSDL.dongKetNoi();
        return kq;
    }
    public static void main(String[] arg) {
        Phat_sinh phieu = new Phat_sinh(1, "05/06/2018", 'n', "dmm Mẫu", "nv1", "mk1");
        boolean kq = phieu.addPhieu();
        System.out.println(kq);
    }
}
