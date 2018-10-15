<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="quanlyvattu.VatTu" %>
<%@page import="quanlyvattu.NhanVien" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String mavt = request.getParameter("mavt");
    VatTu vattu = VatTu.timTheoMaVatTu(mavt);
    if (vattu == null) {
        String table="empty";
        out.print(table);
        return;
    } else {
        String table = "<table border=1>";
        table += "<tr>"
                + "<th>Mã vật tư</th>"
                + "<th>Tên vật tư</th>"
                + "<th>Đơn vị tính</th>"
                + "<th>Số lượng tồn</th>" 
                + "<th>Đơn giá</th>" 
                + "</tr>";
        List<VatTu> list = new ArrayList();
        list.add(vattu);
        if (list == null) {
            out.print("Không tìm thấy vật tư");
            return;
        } else {
            for (VatTu vt : list) {
                table += "<tr><form>"
                        + "<td><textarea name='" + "mavt" + "' readonly>" + vt.getMavt() + "</textarea></td>"
                        + "<td><textarea name='" + "tenvt" + "'readonly>" + vt.getTenvt() + "</textarea></td>"
                        + "<td><textarea name='" + "dvt" + "'readonly>" + vt.getDvt() + "</textarea></td>"
                        + "<td><textarea name='" + "soluongton" + "'readonly>" + vt.getSoluongton() + "</textarea></td>"
                        + "<td><textarea name='" + "dongia" + "'readonly>" + vt.getDongia()+ "</textarea></td>"
                        + "</form></tr>";
            }
            table += "</table>";
            out.print(table);
        }
    }
%>