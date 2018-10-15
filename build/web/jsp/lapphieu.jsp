<%@page import="quanlyvattu.Phieu"%>
<%@page import="quanlyvattu.NhanVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String hotenkh = request.getParameter("hotenkh");
    out.println(hotenkh);
    String loai = request.getParameter("loai");
    out.println(loai);
    String makho = request.getParameter("makho");
    out.println(makho);
    NhanVien nv = (NhanVien)session.getAttribute("nhanvien");
    out.println(nv.getManv());
    Phieu p = new Phieu(loai, hotenkh, nv.getManv(), makho);
    boolean kq = p.addPhieu();
    String thongbao;
    if(kq == false){
        thongbao = "Chưa thêm phiếu được";
    }else{
        thongbao = "";
        response.sendRedirect("../html/nhapChiTietPhieu.html");
    }
    out.print(thongbao);
%>