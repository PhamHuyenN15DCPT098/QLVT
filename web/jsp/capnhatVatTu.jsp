<%@page import="quanlyvattu.NhanVien"%>
<%@page import="quanlyvattu.VatTu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvien");
    if (nhanvien == null) {
    out.println("Bạn chưa đăng nhập!");
    return;
    }
    String mavt = request.getParameter("mavt");
    String tenvt = request.getParameter("tenvt");  
    String dvt = request.getParameter("dvt");  
    int soluongton=Integer.parseInt(request.getParameter("soluongton"));
    int dongia=Integer.parseInt(request.getParameter("dongia"));
    if (soluongton<0 || dongia<0){
        response.sendRedirect("xemDanhSachVatTu.jsp");
        return;
    }
    boolean ketqua;
    ketqua =VatTu.capNhatVatTu(mavt, tenvt, dvt, soluongton, dongia);
    response.sendRedirect("../jsp/xemDanhSachVatTu.jsp");
%>