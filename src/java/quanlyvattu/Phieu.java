/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyvattu;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author USER
 */
public class Phieu {
    int so_phieu;
    String day;
    LocalDate date;
    String loai;
    String ho_ten_khach_hang;
    String manv;
    String makho;

    public Phieu() {
    }

    public Phieu(String loai, String ho_ten_khach_hang, String manv, String makho) {
        this.date = LocalDate.now();
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

    public String getLoai() {
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

    public void setLoai(String loai) {
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
        String sql = "Insert into phieu (ngay, loai, hotenkh, manv, makho) values ('"+date+"','"+loai+"','"+ho_ten_khach_hang+"','"+manv+"','"+makho+"')";
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
<<<<<<< HEAD
        Phieu phieu = new Phieu(1, 'n', "mẫu", "nv1", "mk1");
=======
        Phieu phieu = new Phieu("nhap", "dmm Mẫu", "nv1", "mk1");
>>>>>>> 60cbedb02ef3eac714cf3d17af023a8cf7ab4d7d
        boolean kq = phieu.addPhieu();
        System.out.println(kq);
    }
}
