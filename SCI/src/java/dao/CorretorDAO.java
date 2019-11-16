/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Corretor;

/**
 *
 * @author rafael.dalvas
 */
public class CorretorDAO extends DAO {

    public static List<Corretor> obterCorretores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Corretor> corretores = new ArrayList<Corretor>();
        Corretor corretor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from corretor");
            while (rs.next()) {
                corretor = instanciarCorretor(rs);
                corretores.add(corretor);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return corretores;
    }

    public static Corretor obterCorretor(int matricula) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Corretor corretor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from corretor where matricula = '" + matricula + "'");
            rs.first();
            corretor = instanciarCorretor(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return corretor;
    }

    public static Corretor instanciarCorretor(ResultSet rs) throws SQLException {
        Corretor corretor = new Corretor(
                rs.getInt("matricula"),
                rs.getString("nome"),
                rs.getString("sexo"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("cep"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getInt("cpf"),
                null);
        corretor.setMatriculaAdmResponsavel(rs.getInt("admResponsavel"));
        return corretor;
    }

    public static void gravar(Corretor corretor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into corretor (matricula, nome, sexo, telefone, email, cidade,"
                    + " estado, cep, logradouro, numero, cpf, admResponsavel)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, corretor.getMatricula());
            comando.setString(2, corretor.getNome());
            comando.setString(3, corretor.getSexo());
            comando.setString(4, corretor.getTelefone());
            comando.setString(5, corretor.getEmail());
            comando.setString(6, corretor.getCidade());
            comando.setString(7, corretor.getEstado());
            comando.setString(8, corretor.getCep());
            comando.setString(9, corretor.getLogradouro());
            comando.setString(10, corretor.getNumero());
            comando.setInt(11, (int) corretor.getCpf());
            if (corretor.getAdmResponsavel() == null) {
                comando.setNull(12, Types.INTEGER);
            } else {
                comando.setInt(12, corretor.getAdmResponsavel().getMatricula());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Corretor corretor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from corretor where matricula = " + corretor.getMatricula();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void alterar(Corretor corretor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String stringSQL = "update corretor set "
                    + "matricula = '" + corretor.getMatricula() + "', "
                    + "nome = '" + corretor.getNome() + "', "
                    + "sexo = '" + corretor.getSexo() + "', "
                    + "telefone = '" + corretor.getTelefone() + "', "
                    + "email = '" + corretor.getEmail() + "', "
                    + "cidade = '" + corretor.getCidade() + "', "
                    + "estado = '" + corretor.getEstado() + "', "
                    + "cep = '" + corretor.getCep() + "', "
                    + "logradouro = '" + corretor.getLogradouro() + "', "
                    + "numero = '" + corretor.getNumero() + "', "
                    + "cpf = '" + corretor.getCpf() + "', "
                    + "admResponsavel = ";
                    if (corretor.getAdmResponsavel() == null){
                        stringSQL = stringSQL + null;
                    } else {
                        stringSQL = stringSQL + corretor.getAdmResponsavel().getMatricula();
                    }
                    stringSQL = stringSQL + " where matricula = " + corretor.getMatricula();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
