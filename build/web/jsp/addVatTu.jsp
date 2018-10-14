<%@page import="quanlyvattu.VatTu"%>
<%
    
    String mavt = request.getParameter("mavt");
    String tenvt = request.getParameter("tenvt");
    String dvt = request.getParameter("dvt");
    int soluongton=Integer.parseInt(request.getParameter("soluongton")); 
    System.out.println(mavt + "," + tenvt + "," + dvt+ ","+soluongton);
    VatTu vattu = new VatTu(mavt, tenvt, dvt, soluongton);
    boolean thongbao =vattu.addVatTu();
    out.print(thongbao);
%>