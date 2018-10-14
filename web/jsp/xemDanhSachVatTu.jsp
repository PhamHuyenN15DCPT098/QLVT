l<%@page import="quanlyvattu.VatTu" %>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    VatTu vattu = (VatTu) session.getAttribute("vattu");
    Map<String, VatTu> vattus = vattu.getVatTu();
    if (vattus==null||vattus.isEmpty()) {
        out.println("empty");
        return;
    }
    for (String mavt : vattus.keySet()) {    
        
        VatTu vattu1=vattus.get(mavt);
        out.println(vattu1);
                   
    }
  
 
%>