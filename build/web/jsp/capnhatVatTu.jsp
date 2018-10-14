<%@page import="quanlyvattu.VatTu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//    KhachHang khachhang = (KhachHang) session.getAttribute("khachhang");
//    if (khachhang == null) {
//        out.println("Bạn chưa đăng nhập!");
//        return;
//    }
    String mavt = request.getParameter("mavt");
    String tenvt = request.getParameter("tenvt");
    String dvt = request.getParameter("dvt");
    int soluongton=Integer.parseInt(request.getParameter("soluongton"));
    boolean ketqua =VatTu.capNhatVatTu(mavt, tenvt, dvt, soluongton);
    vattu.capNhatVatTu(mavt, tenvt, dvt, soluongton);
    response.sendRedirect("../html/xemDanhSachVatTu.html");
%>