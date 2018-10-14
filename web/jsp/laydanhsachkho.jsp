<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="quanlyvattu.Kho"%>
    <%
        List <Kho> dskho = new ArrayList();
        dskho = Kho.layDanhSachKho();
        if(dskho == null)
            return;
        String select ="<select name='"+"makho"+"'>";
        for(Kho kho: dskho){
            select += "<option value = "+kho.getMakho()+">"+kho.getMakho()+"</option>";
        }
        select += "</select>";
        out.println(select);
    %> 