
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="quanlyvattu.NhanVien"%>
<%@page import="quanlyvattu.VatTu" %>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*    NhanVien nhanvien = (NhanVien) session.getAttribute("nh
    if (nhanvien == null){
    out.println("Bạn chưa đăng nhập!");
    return;
    }*/
    String table="<table border=1>";
    table +="<tr>"
            + "<th>Mã vật tư</th>"
            + "<th>Tên vật tư</th>"
            + "<th>Đơn vị tính</th>"
            + "<th>Số lượng tồn</th>"
            +"<th>Cập nhật</th>"
            +"<th>Xóa</th>"
            + "</tr>";
    List<VatTu> list= new ArrayList();
    list=VatTu.layDanhSachVatTu();
    if (list==null){
        out.print("Khong co vat tu nao");
        return;
    }
    else
    {
        for (VatTu vt: list){
        table +="<tr><form>"
                + "<td><textarea name='"+"mavt"+"' readonly>"+vt.getMavt()+"</textarea></td>"
                + "<td><textarea name='"+"tenvt"+"'>"+vt.getTenvt()+"</textarea></td>"
                + "<td><textarea name='"+"dvt"+"'>"+vt.getDvt()+"</textarea></td>"
                + "<td><textarea name='"+"soluongton"+"'>"+vt.getSoluongton()+"</textarea></td>"
                + "<td><input type='"+"submit"+"' formaction='"+"capnhatVatTu.jsp"+"' value='"+"Cập nhật"+"' ></td>"
                + "<td><input type='"+"submit"+"' formaction='"+"xoaVatTu.jsp"+"' value='"+"Xóa"+"' ></td>"
                + "</form></tr>";
    }
    table+="</table>";
    out.print(table);
    }
    
 
%>