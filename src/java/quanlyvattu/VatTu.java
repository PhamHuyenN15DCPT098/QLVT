package quanlyvattu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import quanlyvattu.CSDL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ba Mau
 */
public class VatTu {

    String mavt;
    String tenvt;
    String dvt;
    int soluongton;
    Map<String, VatTu> vattus = new HashMap();
    
    
    public VatTu(String mavt, String tenvt, String dvt, int soluongton) {
        this.mavt = mavt;
        this.tenvt = tenvt;
        this.dvt = dvt;
        this.soluongton = soluongton;
    }

    public VatTu() {
    }

    public String getMavt() {
        return mavt;
    }

    public void setMavt(String mavt) {
        this.mavt = mavt;
    }

    public String getTenvt() {
        return tenvt;
    }

    public void setTenvt(String tenvt) {
        this.tenvt = tenvt;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public int getSoluongton() {
        return soluongton;
    }
    
    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public Map<String, VatTu> getVatTus() {
        return vattus;
    }
    
    public VatTu timVatTu(String mavt) {
        VatTu vattu = vattus.get(mavt);
        return vattu;
    }
    
    public boolean addVatTu() {
        CSDL.moKetNoi("vattu", "root", "root");
        String sql = " insert into vattu values ('" + mavt + "','" + tenvt + "','" + dvt + "'," + soluongton + ")";
        boolean ketqua = true;
        try {
            CSDL.stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ketqua = false;
        }
        CSDL.dongKetNoi();
        return ketqua;
    }

    public static List<VatTu> layDanhSachVatTu() {
        CSDL.moKetNoi("vattu", "root", "root");
        List<VatTu> listvattu = new ArrayList();
        String sql = " select * from vattu";
        try {
            ResultSet rs = CSDL.stm.executeQuery(sql);
            while (rs.next()) {
                VatTu vattu = new VatTu(rs.getString("mavt"), rs.getString("tenvt"), rs.getString("dvt"), rs.getInt("soluongton"));
                listvattu.add(vattu);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            listvattu = null;
        }
        CSDL.dongKetNoi();
        return listvattu;
    }

    public static VatTu timTheoMaVatTu(String mavt) {
        CSDL.moKetNoi("vattu", "root", "root");
        String sql = "select * from vattu where mavt='" + mavt + "'";
        VatTu vattu = null;
        try {
            ResultSet rs = CSDL.stm.executeQuery(sql);
            if (rs.next()) {
                vattu = new VatTu(rs.getString("mavt"), rs.getString("tenvt"), rs.getString("dvt"), rs.getInt("soluongton"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        CSDL.dongKetNoi();
        return vattu;
    }

    public static List<VatTu> timVatTuTheoTenVatTu(String tenvt) {
        CSDL.moKetNoi("vattu", "root", "root");
        String sql = "SELECT * FROM vattu WHERE tenvt like '%" + tenvt + "%'";
        List<VatTu> listvattu = null;
        try {
            ResultSet rs = CSDL.stm.executeQuery(sql);
            listvattu = new ArrayList();
            while (rs.next()) {
                VatTu vattu = new VatTu(rs.getString("mavt"), rs.getString("tenvt"),
                        rs.getString("dvt"), rs.getInt("soluongton"));
                listvattu.add(vattu);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        CSDL.dongKetNoi();
        return listvattu;
    }

    public static List<VatTu> timVatTuConHang() {
        CSDL.moKetNoi("vattu", "root", "root");
        String sql = "select * from vattu where soluongton = 0";
        List<VatTu> listvattu = null;
        try {
            ResultSet rs = CSDL.stm.executeQuery(sql);
            listvattu = new ArrayList();
            while (rs.next()) {
                VatTu vattu = new VatTu(rs.getString("mavt"), rs.getString("tenvt"), rs.getString("dvt"), rs.getInt("soluongton"));
                listvattu.add(vattu);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        CSDL.dongKetNoi();
        return listvattu;
    }

    public static boolean capNhatVatTu(String mavt, String tenvt, String dvt, int soluongton){
        VatTu vattu= VatTu.timTheoMaVatTu(mavt);
        boolean ketqua;
        if(vattu==null){
            ketqua=false;
        }else{
            CSDL.moKetNoi("vattu", "root", "root");
            String sql= "update vattu set tenvt='" + tenvt + "',dvt='" + dvt + "', soluongton="+soluongton+"" + " where mavt='" + mavt+"'";
            try{
                CSDL.stm.executeUpdate(sql);
                ketqua=true;
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                ketqua=false;
            }
        }
        CSDL.dongKetNoi();
        return ketqua;
    }
    
    public static boolean xoaVatTu(String mavt){
        VatTu vattu= VatTu.timTheoMaVatTu(mavt);
        boolean ketqua;
        if(vattu==null){
            ketqua=false;
        }else{
            CSDL.moKetNoi("vattu", "root", "root");
            String sql= "delete from vattu where mavt='" + mavt+"'";
            try{
                CSDL.stm.executeUpdate(sql);
                ketqua=true;
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                ketqua=false;
            }
        }
        CSDL.dongKetNoi();
        return ketqua;
    }
    public static boolean capNhatSoLuongTon(String mavt, int soluongton) {
        VatTu vattu = VatTu.timTheoMaVatTu(mavt);
        boolean ketqua;
        if (vattu == null || vattu.getSoluongton() + soluongton < 0) {
            ketqua = false;
        } else {
            CSDL.moKetNoi("vattu", "root", "root");
            String sql = "UPDATE vattu SET soluongton=" + (vattu.getSoluongton() + soluongton)
                    + " WHERE mavt='" + mavt + "'";
            try {
                CSDL.stm.executeUpdate(sql);
                ketqua = true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                ketqua = false;
            }
        }
        CSDL.dongKetNoi();
        return ketqua;
    }

    @Override
    public String toString() {
        return "Mã VT: " + mavt + "--Tên VT: " + tenvt + "--Đơn Vị Tính: " + dvt + "--Số Lượng Tồn Kho: " + soluongton;
    }

    public static void main(String[] arg) {

//        VatTu vattu = new VatTu("T3", "Tivi LG", "Cái", 50);
//        if (vattu.addVatTu() == true) {
//            System.out.println("Nhập Thành Công");
//        } else {
//            System.out.println("Nhập Không Thành Công");
//        }

//        List<VatTu> listvattu = VatTu.layDanhSachVatTu();
//        for(VatTu vattu:listvattu){
//            System.out.println(vattu);
//        }   
//        VatTu vattu = VatTu.timTheoMaVatTu("t3");
//        if (vattu != null) {
//            System.out.println(vattu);
//        } else {
//            System.out.println("Khong Tim Thay Vat Tu");
//        }
//        List<VatTu> listvattu =VatTu.timVatTuTheoTenVatTu("panasonic");
//        for(VatTu vattu: listvattu){
//            System.out.println(vattu);
//    }
       
//        boolean ketqua=VatTu.capNhatVatTu("T3", "Tivi Samsung", "Cái", 30);
//        if(ketqua==true){
//            System.out.println("Cap nhat thanh cong");
//        }else{
//            System.out.println("Cap Nhat Khong Thanh Cong");
//        }
        boolean ketqua=VatTu.xoaVatTu("t02");
        if(ketqua==true){
            System.out.println("Xoa thanh cong");
        }else{
            System.out.println("Xoa Khong Thanh Cong");
        }
    }
}
