<%@page import="quanlyvattu.VatTu" %>
<%@page import="quanlyvattu.NhanVien" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
   String mavt = request.getParameter("mavt");
   out.println(mavt);
   VatTu vattu =new VatTu();
   boolean ketqua=vattu.xoaVatTu(mavt);
   
   response.sendRedirect("xemDanhSachVatTu.jsp");
  
   out.print(ketqua);
   
%>