/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AlugadosDAO;
import dao.CorretorDAO;
import dao.ImovelAlugaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluguel;
import model.Corretor;
import model.ImovelAluga;

/**
 *
 * @author joao.bonetti
 */
@WebServlet(name = "ManterAlugadosController", urlPatterns = {"/ManterAlugadosController"})
public class ManterAlugadosController extends HttpServlet {

    
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
                int idAluguel = Integer.parseInt(request.getParameter("idAluguel"));
                Aluguel aluguel = AlugadosDAO.obterAlugado(idAluguel);
                request.setAttribute("aluguel", aluguel);
            }
            request.setAttribute("alugados", ImovelAlugaDAO.obterImovelAlugueis());
            request.setAttribute("corretores", CorretorDAO.obterCorretores());
            RequestDispatcher view = request.getRequestDispatcher("/alugarImovel.jsp");
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
        int idAluguel = Integer.parseInt(request.getParameter("txtIdAluguel"));
        int idImovelAlugado = Integer.parseInt(request.getParameter("optImovelAlugado"));
        int idResponsavelAluguel = Integer.parseInt(request.getParameter("optResponsavelAluguel"));
        String nomeAlugatario = request.getParameter("txtNomeAlugatario");
        String cpfAlugatario = request.getParameter("txtCpfAlugatario");
        float valorDeAluguel = Float.parseFloat(request.getParameter("txtValorAluguel"));
        float valorCalcao = Float.parseFloat(request.getParameter("txtValorCalcao"));
        ImovelAluga imovelAlugado = null;
        if (idImovelAlugado != 0) {
            imovelAlugado = ImovelAlugaDAO.obterImovelAluguel(idImovelAlugado);
        }
        try {
            Corretor responsavelAluguel = null;
            if (idResponsavelAluguel != 0) {
                responsavelAluguel = CorretorDAO.obterCorretor(idResponsavelAluguel);
            }       
            Aluguel aluguel = new Aluguel(idAluguel, imovelAlugado, responsavelAluguel, nomeAlugatario, cpfAlugatario, valorDeAluguel, valorCalcao);
            if (operacao.equals("Incluir")) {
                AlugadosDAO.gravar(aluguel); 
            } else if (operacao.equals("Excluir")) {
                AlugadosDAO.excluir(aluguel); 
            } else if (operacao.equals("Editar")){
                AlugadosDAO.alterar(aluguel);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlugadosController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
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
            Logger.getLogger(ManterAlugadosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAlugadosController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAlugadosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAlugadosController.class.getName()).log(Level.SEVERE, null, ex);
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
