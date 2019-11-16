/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package controller;

import dao.ImovelVendaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ImovelVenda;

/**
 *
 * @author joao.bonetti
 */
public class ManterImovelVendaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int idImovel = Integer.parseInt(request.getParameter("idImovel"));
                ImovelVenda vender = ImovelVendaDAO.obterImovelVenda(idImovel);
                request.setAttribute("vender", vender);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarImovelVenda.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ClassNotFoundException, SQLException {
        String operacao = request.getParameter("operacao");
        int idImovel = Integer.parseInt(request.getParameter("txtId"));
        String cidade = request.getParameter("txtCidade");
        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        Float area = Float.parseFloat(request.getParameter("txtArea"));
        int nQuartos = Integer.parseInt(request.getParameter("txtNumQuartos"));
        int nBanheiros = Integer.parseInt(request.getParameter("txtNumBanheiros"));
        Float precoAnunciado = Float.parseFloat(request.getParameter("txtValorAnunciado"));
        try {
            ImovelVenda venda = new ImovelVenda(idImovel, cidade, cep, logradouro, numero, area, nQuartos, nBanheiros, precoAnunciado);
            if (operacao.equals("Incluir")) {
                ImovelVendaDAO.gravar(venda);
            } else if (operacao.equals("Editar")){
                ImovelVendaDAO.alterar(venda);
            } else if (operacao.equals("Excluir")){
                ImovelVendaDAO.excluir(venda);
            }
            RequestDispatcher view = request.getRequestDispatcher("PequisaImovelVendaController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);

        } catch (ServletException e) {
            throw e;
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterImovelVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterImovelVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterImovelVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterImovelVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
