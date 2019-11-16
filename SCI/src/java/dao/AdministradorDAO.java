/*
 Trabalho SI 6º Período - Prof. Marco Antonio
 Autores:
 João Paulo Bonetti
 Rafael Dalvas
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Administrador;

public class AdministradorDAO extends DAO {

    public static List<Administrador> obterAdministradores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Administrador> administradores = new ArrayList<Administrador>();
        Administrador administrador = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from administrador");
            while (rs.next()) {
                administrador = instanciarAdministrador(rs);
                administradores.add(administrador);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return administradores;
    }

    public static void excluir(Administrador administrador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from administrador where matricula = " + administrador.getMatricula();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Administrador obterAdministrador(int matricula) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Administrador administrador = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from administrador where matricula = '" + matricula + "'");
            rs.first();
            administrador = instanciarAdministrador(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return administrador;
    }

    public static Administrador instanciarAdministrador(ResultSet rs) throws SQLException {
        Administrador administrador = new Administrador(
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
                rs.getString("nivelCargo"));
        return administrador;
    }

    public static void gravar(Administrador administrador) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into administrador (matricula, nome, sexo, telefone, email, cidade, "
                    + "estado, cep, logradouro, numero, cpf, nivelCargo) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, administrador.getMatricula());
            comando.setString(2, administrador.getNome());
            comando.setString(3, administrador.getSexo());
            comando.setString(4, administrador.getTelefone());
            comando.setString(5, administrador.getEmail());
            comando.setString(6, administrador.getCidade());
            comando.setString(7, administrador.getEstado());
            comando.setString(8, administrador.getCep());
            comando.setString(9, administrador.getLogradouro());
            comando.setString(10, administrador.getNumero());
            comando.setInt(11, (int) administrador.getCpf());
            comando.setString(12, administrador.getNivelCargo());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Administrador administrador) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String stringSQL = "update administrador set "
                    + "matricula = '" + administrador.getMatricula() + "', "
                    + "nome = '" + administrador.getNome() + "', "
                    + "sexo = '" + administrador.getSexo() + "', "
                    + "telefone = '" + administrador.getTelefone() + "', "
                    + "email = '" + administrador.getEmail() + "', "
                    + "cidade = '" + administrador.getCidade() + "', "
                    + "estado = '" + administrador.getEstado() + "', "
                    + "cep = '" + administrador.getCep() + "', "
                    + "logradouro = '" + administrador.getLogradouro() + "', "
                    + "numero = '" + administrador.getNumero() + "', "
                    + "cpf = '" + administrador.getCpf() + "', "
                    + "nivelCargo = '" + administrador.getNivelCargo() + "' "
                    + "where matricula = " + administrador.getMatricula();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
