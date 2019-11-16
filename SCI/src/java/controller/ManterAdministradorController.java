/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdministradorDAO;
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

/**
 *
 * @author joao.bonetti
 */
public class ManterAdministradorController extends HttpServlet {

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
            throws ServletException, ClassNotFoundException, SQLException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int matricula = Integer.parseInt(request.getParameter("matricula"));
                Administrador administrador = AdministradorDAO.obterAdministrador(matricula);
                request.setAttribute("administrador", administrador);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarAdministrador.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        }
    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ClassNotFoundException, SQLException, IOException {
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
        String nivelCargo = request.getParameter("txtNivelCargo");

        Administrador administrador = new Administrador(matricula, nome, sexo, telefone, email, cidade, estado, cep, logradouro, numero, cpf, nivelCargo);
        if (operacao.equals("Incluir")) {
            AdministradorDAO.gravar(administrador);
        } else if (operacao.equals("Excluir")) {
            AdministradorDAO.excluir(administrador);
        } else if (operacao.equals("Editar")) {
            AdministradorDAO.alterar(administrador);
        }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
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
