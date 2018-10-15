<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="quanlyvattu.VatTu" %>
<%@page import="quanlyvattu.NhanVien" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

        List<VatTu> list = VatTu.timVatTuConHang();
        if (list == null) {
            out.print("Khong co vat tu nao");
            return;
        } else {
            String table = "<table border=1>";
            table += "<tr>"
                    + "<th>Mã vật tư</th>"
                    + "<th>Tên vật tư</th>"
                    + "<th>Đơn vị tính</th>"
                    + "<th>Số lượng tồn</th>"
                    + "</tr>";
            for (VatTu vt : list) {
                table += "<tr><form>"
                        + "<td><textarea name='" + "mavt" + "' readonly>" + vt.getMavt() + "</textarea></td>"
                        + "<td><textarea name='" + "tenvt" + "'>" + vt.getTenvt() + "</textarea></td>"
                        + "<td><textarea name='" + "dvt" + "'>" + vt.getDvt() + "</textarea></td>"
                        + "<td><textarea name='" + "soluongton" + "'>" + vt.getSoluongton() + "</textarea></td>"
                        + "</form></tr>";
            }
            table += "</table>";
            out.print(table);
        }  
%>