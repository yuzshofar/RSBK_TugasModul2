/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.konversimatauang;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Khairuzzain Shofar
 */
public class konversiServlet extends HttpServlet {

    @EJB
    private konversimatauang konversimatauang;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h1><center>Tugas RSBK Konversi Mata Uang</center></h1>");
            String nilai = request.getParameter("nilai");
            
            if ((nilai != null) && (nilai.length() > 0)) {
                double d = Double.parseDouble(nilai);
                if (request.getParameter("Rupiah Ke Ringgit") != null){
                    String rprm = konversimatauang.Rp_RM(d);
                    out.println("<center>");
                    out.println("<p> HASIL KONVERSI MATA UANG: "+rprm+"</p>");
                }  
                if (request.getParameter("Rupiah Ke Dollar") != null) {
                    String rpd = konversimatauang.Rp_Dollar(d);
                    out.println("<center>");
                    out.println("<p> HASIL KONVERSI MATA UANG: "+rpd+ " .</p>");
                }
                if (request.getParameter("Rupiah Ke Riyal") != null) {
                    String rpr = konversimatauang.Rp_Riyal(d);
                    out.println("<center>");
                    out.println("<p> HASIL KONVERSI MATA UANG: " +rpr+ " .</p>");
                }
                if (request.getParameter("Rupiah Ke Yen") != null) {
                    String rpy = konversimatauang.Rp_Yen(d);
                    out.println("<center>");
                    out.println("<p> HASIL KONVERSI MATA UANG: "+rpy+ " .</p>");
                }
                
            } else {
                out.println("<center>");
                out.println("<p>Masukan Nilai Uang Rupiahnya:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"nilai\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Rupiah Ke Ringgit\" value=\"Rupiah Ke Ringgit\">"+ "<input type=\"submit\" name=\"Rupiah Ke Dollar\" value=\"Rupiah Ke Dollar\">");
                out.println("<br/>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Rupiah Ke Riyal\" value=\"Rupiah Ke Riyal\">"+ "<input type=\"submit\" name=\"Rupiah Ke Yen\" value=\"Rupiah Ke Yen\">");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
