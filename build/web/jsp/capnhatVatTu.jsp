<%@page import="quanlyvattu.NhanVien"%>
<%@page import="quanlyvattu.VatTu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*    NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvien");
    if (nhanvien == null) 
    out.println("Bạn chưa đăng nhập!")
    return;
    }*/
    String mavt = request.getParameter("mavt");
    String tenvt = request.getParameter("tenvt");
    String dvt = request.getParameter("dvt");
    int soluongton=Integer.parseInt(request.getParameter("soluongton"));
    boolean ketqua= false;
    String thongbao="";
    ketqua =VatTu.capNhatVatTu(mavt, tenvt, dvt, soluongton);
    if(ketqua==false){
        thongbao="Cập nhật vật tư không thành công";
    }
    else{
           thongbao="Cập nhật vật tư thành công";
        }
    out.print(thongbao);
%>