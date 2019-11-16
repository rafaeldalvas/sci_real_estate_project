/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CorretorDAO;
import dao.ImovelVendaDAO;
import dao.VendidosDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Corretor;
import model.ImovelVenda;
import model.Venda;

/**
 *
 * @author joao.bonetti
 */
public class ManterVendidosController extends HttpServlet {

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
                int idVenda = Integer.parseInt(request.getParameter("idVenda"));
                Venda vendido = VendidosDAO.obterVendido(idVenda);
                request.setAttribute("vendido", vendido);
            }
            request.setAttribute("imoveis", ImovelVendaDAO.obterImovelVendas());
            request.setAttribute("corretores", CorretorDAO.obterCorretores());
            RequestDispatcher view = request.getRequestDispatcher("/venderImovel.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ClassNotFoundException, SQLException, IOException {
        String operacao = request.getParameter("operacao");
        int idVenda = Integer.parseInt(request.getParameter("txtIdVenda"));
        int imovelVendido = Integer.parseInt(request.getParameter("optImovelVendido"));
        int responsavelVenda = Integer.parseInt(request.getParameter("optResponsavelVenda"));
        String nomeComprador = request.getParameter("txtNomeComprador");
        String cpfComprador = request.getParameter("txtCpfComprador");
        Float valorEntrada = Float.parseFloat(request.getParameter("txtValorEntrada"));
        int numPercelas = Integer.parseInt(request.getParameter("txtNumPercelas"));
        Float valorParcela = Float.parseFloat(request.getParameter("txtValorParcela"));
        Float valorVenda = Float.parseFloat(request.getParameter("txtvalorVenda"));
        String dataVenda = request.getParameter("txtDataVenda");
       
            ImovelVenda imovel = null;
            if (imovelVendido != 0) {
                imovel = ImovelVendaDAO.obterImovelVenda(imovelVendido);
            }
            Corretor corretor = null;
            if (responsavelVenda != 0) {
                corretor = CorretorDAO.obterCorretor(responsavelVenda);
            }
            Venda vendido = new Venda(idVenda, imovel, corretor, nomeComprador,
                    cpfComprador, valorEntrada, numPercelas, valorParcela, valorVenda, dataVenda);
            if (operacao.equals("Incluir")) {
                VendidosDAO.gravar(vendido);
            } else if (operacao.equals("Excluir")) {
                VendidosDAO.excluir(vendido); 
            } else if (operacao.equals("Editar")) {
                VendidosDAO.alterar(vendido);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaVendidosController");
            view.forward(request, response);
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
            Logger.getLogger(ManterVendidosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVendidosController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterVendidosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVendidosController.class.getName()).log(Level.SEVERE, null, ex);
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
