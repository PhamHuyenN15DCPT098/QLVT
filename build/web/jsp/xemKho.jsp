<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="quanlyvattu.NhanVien"%>
<%@page import="quanlyvattu.VatTu" %>
<%@page import="quanlyvattu.Kho" %>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvien");
    if (nhanvien == null) {
        out.println("Bạn chưa đăng nhập!");
        return;
    }
    String table = "<table border=1>";
    table += "<tr>"
            + "<th>Mã Kho</th>"
            + "<th>Tên Kho</th>"
            + "<th>Địa Chỉ</th>"        
            + "</tr>";
    List<Kho> list = Kho.layDanhSachKho();
    if (list == null) {
        out.print("Không có kho nào");
        return;
    } else {
        for (Kho kho : list) {
            table += "<tr><form>"
                    + "<td><textarea name='" + "makho" + "' readonly>" + kho.getMakho() + "</textarea></td>"
                    + "<td><textarea name='" + "tenkho" + "'readonly>" + kho.getTenkho() + "</textarea></td>"
                    + "<td><textarea name='" + "diachi" + "'readonly>" + kho.getDiachi() + "</textarea></td>"               
                    + "</form></tr>";
        }
        table += "</table>";
        out.print(table);
    }


%>