<%@page import="quanlyvattu.VatTu"%>
<%@page import="quanlyvattu.NhanVien"%>
<%
    NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvien");
    if (nhanvien == null) {
    out.println("B?n ch?a ??ng nh?p");
    return;
    }
    String mavt = request.getParameter("mavt");
    String tenvt = request.getParameter("tenvt");
    String dvt = request.getParameter("dvt");
    int soluongton=Integer.parseInt(request.getParameter("soluongton"));  
    int dongia=Integer.parseInt(request.getParameter("dongia"));
 
    VatTu vattu = new VatTu(mavt, tenvt, dvt, soluongton, dongia);
    boolean thongbao =vattu.addVatTu();
    out.print(thongbao);
%>