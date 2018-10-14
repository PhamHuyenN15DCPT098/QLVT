<%@page import="java.sql.ResultSet"%>
<%@page import="quanlyvattu.NhanVien"%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println(username + "," + password);
    NhanVien nhanvien = new NhanVien(username, password).dangnhap();
    boolean thongbao = false;
    if (nhanvien != null) {
        thongbao = true;
        session.setAttribute("nhanvien", nhanvien);
    }
    out.print(thongbao);
%>
