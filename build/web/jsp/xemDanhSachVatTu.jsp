
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="quanlyvattu.NhanVien"%>
<%@page import="quanlyvattu.VatTu" %>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    NhanVien nhanvien = (NhanVien) session.getAttribute("nhanvien");
    if (nhanvien == null){
    out.println("Bạn chưa đăng nhập!");
    return;
    }
    String table="<table border=1>";
    table +="<tr>"
            + "<th>Mã vật tư</th>"
            + "<th>Tên vật tư</th>"
            + "<th>Đơn vị tính</th>"
            + "<th>Số lượng tồn</th>"
            +"<th>Cập nhật</th>"        
            + "</tr>";
    List<VatTu> list= new ArrayList();
    list=VatTu.layDanhSachVatTu();
    if (list==null){
        out.print("Không có vật tư nào");
        return;
    }
    else
    {
        for (VatTu vt: list){
        table +="<tr><form>"
                + "<td><input name='"+"mavt"+"' value='"+vt.getMavt()+"' readonly>"+"</td>"
                + "<td><textarea name='"+"tenvt"+"'>"+vt.getTenvt()+"</textarea></td>"
                + "<td><textarea name='"+"dvt"+"'>"+vt.getDvt()+"</textarea></td>"
                + "<td><textarea name='"+"soluongton"+"'>"+vt.getSoluongton()+"</textarea></td>"
                + "<td><input type='"+"submit"+"' formaction='"+"../jsp/capnhatVatTu.jsp"+"' value='"+"Cập nhật"+"'></td>"
                + "</form></tr>";
    }
        table+="</table>";
        out.print(table);
    }
    
 
%>