package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import java.util.ArrayList;
import java.util.List;
import quanlyvattu.NhanVien;
import quanlyvattu.VatTu;
import java.util.Map;

public final class xemDanhSachVatTu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    /*    NhanVien nhanvien = (NhanVien) session.getAttribute("nh
    if (nhanvien == nul
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
                + "<td><input name='"+"mavt"+"' value='"+vt.getMavt()+"' readonly>"+"</td>"
                + "<td><textarea name='"+"tenvt"+"'>"+vt.getTenvt()+"</textarea></td>"
                + "<td><textarea name='"+"dvt"+"'>"+vt.getDvt()+"</textarea></td>"
                + "<td><textarea name='"+"soluongton"+"'>"+vt.getSoluongton()+"</textarea></td>"
                + "<td><input type='"+"submit"+"' formaction='"+"../jsp/capnhatVatTu.jsp"+"' value='"+"Cập nhật"+"'></td>"
                + "<td>Xóa"+"</td>"
                + "</form></tr>";
    }
    table+="</table>";
    out.print(table);
    }
    
 

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
