<%@page import="quanlyvattu.Phieu"%>
<%@page import="quanlyvattu.NhanVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String hotenkh = request.getParameter("hotenkh");
    String loai = request.getParameter("loai");
    String makho = request.getParameter("makho");
    NhanVien nv = (NhanVien)session.getAttribute("nhanvien");
    Phieu p = new Phieu(loai, hotenkh, nv.getManv(), makho);
    boolean kq = p.addPhieu();
    String thongbao;
    if(kq == false){
        thongbao = "Chưa thêm phiếu được";
    }else{
        thongbao = "";
        session.setAttribute("hotenkh", hotenkh);
        session.setAttribute("loai", loai);
        session.setAttribute("makho", makho);
        response.sendRedirect("../html/nhapChiTietPhieu.html");
    }
    out.print(thongbao);
%>