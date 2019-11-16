/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdministradorDAO;
import dao.CorretorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Corretor;

/**
 *
 * @author rafael.dalvas
 */
public class ManterCorretorController extends HttpServlet {

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
            throws ServletException, ClassNotFoundException, IOException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int matricula = Integer.parseInt(request.getParameter("matricula"));
                Corretor corretor = CorretorDAO.obterCorretor(matricula);
                request.setAttribute("corretor", corretor);
            }
            request.setAttribute("administradores", AdministradorDAO.obterAdministradores());
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarCorretor.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacao = request.getParameter("operacao");
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String nome = request.getParameter("txtNome");
        String sexo = request.getParameter("txtSexo");
        String telefone = request.getParameter("txtTelefone");
        String email = request.getParameter("txtEmail");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        int cpf = Integer.parseInt(request.getParameter("txtCpf"));
        int admResponsavel = Integer.parseInt(request.getParameter("optAdmResponsavel"));
        try {
            Administrador administrador = null;
            if (admResponsavel != 0) {
                administrador = AdministradorDAO.obterAdministrador(admResponsavel);
            }
            Corretor corretor = new Corretor(matricula, nome, sexo, telefone, email, cidade, estado, cep, logradouro,
                    numero, cpf, administrador);
            if (operacao.equals("Incluir")) {
                CorretorDAO.gravar(corretor);
            } else if (operacao.equals("Excluir")) {
                CorretorDAO.excluir(corretor);
            } else if (operacao.equals("Editar")) {
                CorretorDAO.alterar(corretor);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorretorController");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterCorretorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterCorretorController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterCorretorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterCorretorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
