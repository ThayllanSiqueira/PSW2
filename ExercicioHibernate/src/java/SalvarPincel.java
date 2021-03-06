/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rafael.Soares
 */
public class SalvarPincel extends HttpServlet {

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
              
            try{
                
                Integer idFab = Integer.parseInt(request.getParameter("fab"));
                
                Fabricante f = new Fabricante();
                f.setId(idFab);
                
                Pincel p1 = new Pincel();

                p1.setCor(request.getParameter("cor"));
                p1.setFabricante(f);
                
                String num = request.getParameter("num");
                if(num != null){
                    Integer numi = Integer.parseInt(num);
                    p1.setNum_serie(numi);
                }

                Session sessao = HibernateUtil.
                                    getSessionFactory()
                                    .openSession();

                Transaction tx = sessao.beginTransaction();
                
                try{
                    //sessao.save(f);
                    sessao.save(p1);
                    sessao.flush();

                tx.commit();
                } catch(Exception e){
                    System.out.println("Error" + e.getMessage());
                    e.printStackTrace();
                    tx.rollback();
                }
                
                sessao.close();
                
                out.println("Registro inserido com sucesso!");
            } catch (Exception ex) {
                out.println("Erro ao inserir pincel: " + ex.getMessage());
            }
            
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
