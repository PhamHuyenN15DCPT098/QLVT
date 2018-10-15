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
    boolean ketqua;
    ketqua =VatTu.capNhatVatTu(mavt, tenvt, dvt, soluongton);
<<<<<<< HEAD
    response.sendRedirect("../jsp/xemDanhSachVatTu.jsp");
=======
    response.sendRedirect("xemDanhSachVatTu.jsp");   
>>>>>>> d2e5be9248c5802d39f052a0c8e7cc33502f72f8
%>