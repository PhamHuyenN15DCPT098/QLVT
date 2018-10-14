package quanlyvattu;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class NhanVien {

    String manv;
    int vaitro;
    String hoten;
    String phai;
    String diachi;
    String ngaysinh;
    String sdt;
    int luong;
    String macn;
    String username;
    String password;

    public NhanVien() {
    }

    public NhanVien(String manv, String hoten, String username, String password) {
        this.manv = manv;
        this.hoten = hoten;
        this.username = username;
        this.password = password;
    }

    public NhanVien(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getManv() {
        return manv;
    }

    public int getVaitro() {
        return vaitro;
    }

    public String getHoten() {
        return hoten;
    }

    public String getPhai() {
        return phai;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public int getLuong() {
        return luong;
    }

    public String getMacn() {
        return macn;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
 
    public NhanVien dangnhap() {
        CSDL.moKetNoi("vattu", "root", "root");
        String sql = "SELECT * FROM nhanvien WHERE username='" + 
                username + "' and password='"+password+"'";
        NhanVien nhanvien = null;
        try {
            ResultSet rs = CSDL.stm.executeQuery(sql);
            if (rs.next()) {
                nhanvien = new NhanVien(rs.getString("manv"),rs.getString("hoten"),
                        rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
        CSDL.dongKetNoi();
        return nhanvien;
    }
   
    public static void main(String[] Arr) {
//        NhanVien nhanvien=new NhanVien("1",1,"pham huyền","nữ","691 Hoàng Sa","1997/03/01","012324324",10000000,"cn1","pham.huyen","1234");
//       boolean kq=nhanvien.nhapNhanVien();
//        List<NhanVien> list = NhanVien.timNVTheoTen("Huyen");
//        for (NhanVien nv : list) {
//            System.out.println(nv);
//        }

//        NhanVien nv= NhanVien.timNVTheoMaNV("01");
//        System.out.println(nv);

//         List<NhanVien> list = NhanVien.timNVTheoSdt("012");
//        for (NhanVien nv : list) {
//            System.out.println(nv);
//        }

//        NhanVien nv= NhanVien.dangnhap("pham.huyen", "1234");
//        System.out.println(nv);
    }
}
