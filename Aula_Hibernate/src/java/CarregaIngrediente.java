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

/**
 *
 * @author Thayllan
 */
public class CarregaIngrediente extends HttpServlet {

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
           
            Integer idIngrediente;
            
            if(request.getParameter("chave") == null || request.getParameter("chave").equals("")) {
                out.println("Favor informar um id");
            } else {
                
                idIngrediente = Integer.parseInt(request.getParameter("chave"));
                
                try{

                    Ingrediente ingrediente;

                    Session sessao = HibernateUtil.getSessionFactory().openSession();

                    ingrediente = (Ingrediente) sessao.get(Ingrediente.class, idIngrediente);

                    if(ingrediente == null) {
                       out.println("Nao encontrei o ingrediente de id: " + idIngrediente);
                    }
                    else {

                        out.println("Dados do Ingrediente :" + idIngrediente + " ");
                        out.println("Nome:" + ingrediente.getNome());
                        out.println("Quantidade: " + ingrediente.getQtd());
                        out.println("Valor: " + ingrediente.getValor());
                    }
                } catch (Exception ex){
                    out.println("Erro ao buscar ingrediente: " + ex.getMessage());
                }
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
