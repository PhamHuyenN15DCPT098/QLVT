package quanlyvattu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name="CtrQuanLyVatTu", urlPatterns = {"/CtrQuanLyVatTu"})
public class CtrQuanLyVatTu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrQuanLyVatTu</title>");
            out.println("</head>");
            out.println("<body>");
            String yc = request.getParameter("yc");
            String url = "/QLVATTU/html/";
            if (yc.equals("addvattu")) {
                response.sendRedirect(url + "addVatTu.html");
            }
            if (yc.equals("xemvattu")) {
<<<<<<< HEAD
                response.sendRedirect(url+"../jsp/xemDanhSachVatTu.jsp");
            }
=======
                response.sendRedirect(url+"../jsp/xemDanhSachVatTu.jsp");                
            }          
            if (yc.equals("timtheoma")) {
                response.sendRedirect(url+ "timVatTuTheoMa.html");                
            }  
            if (yc.equals("timtheoten")) {
                response.sendRedirect(url+ "timVatTuTheoTen.html");                
            }  
            if (yc.equals("timhangcon")) {
                response.sendRedirect(url+ "../jsp/timVatTuConHang.jsp");                
            }  
            if(yc.equals("lap_phieu")){
                response.sendRedirect(url+"lap_phieu.html");
            }             
<<<<<<< HEAD
            if (yc.equals("kho")) {
                response.sendRedirect(url+ "../jsp/xemKho.jsp");                
            }  
=======
>>>>>>> d2e5be9248c5802d39f052a0c8e7cc33502f72f8
>>>>>>> fd535fa5dcfe940029f1a6ccd338196f558ff593
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
