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
import model.ImovelVenda;

public class ImovelVendaDAO extends DAO {

    public static List<ImovelVenda> obterImovelVendas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ImovelVenda> imoveis = new ArrayList<ImovelVenda>();
        ImovelVenda imovel = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM imovelvenda");
            while (rs.next()) {
                imovel = instanciarImovelVenda(rs);
                imoveis.add(imovel);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return imoveis;
    }

    public static ImovelVenda obterImovelVenda(int idImovel) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ImovelVenda imovel = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM imovelvenda where idimovel = '" + idImovel + "'");
            rs.first();
            imovel = instanciarImovelVenda(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return imovel;
    }

    public static ImovelVenda instanciarImovelVenda(ResultSet rs) throws SQLException {
        ImovelVenda imovelVenda = new ImovelVenda(
                rs.getInt("idImovel"),
                rs.getString("cidade"),
                rs.getString("cep"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getFloat("area"),
                rs.getInt("nQuartos"),
                rs.getInt("nBanheiros"),
                rs.getFloat("precoAnunciado"));
        return imovelVenda;
    }

    public static void gravar(ImovelVenda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into imovelvenda (idimovel, cidade, cep, logradouro, numero, area,"
                    + " nQuartos, nBanheiros, precoAnunciado) values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, venda.getIdImovel());
            comando.setString(2, venda.getCidade());
            comando.setString(3, venda.getCep());
            comando.setString(4, venda.getLogradouro());
            comando.setString(5, venda.getNumero());
            comando.setFloat(6, (float) venda.getArea());
            comando.setInt(7, venda.getnQuartos());
            comando.setInt(8, venda.getnBanheiros());
            comando.setFloat(9, venda.getPrecoAnunciado());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(ImovelVenda venda) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from imovelvenda where idimovel = " + venda.getIdImovel();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(ImovelVenda vendido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String stringSQL = "update imovelvenda set "
                    + "idimovel = '" + vendido.getIdImovel() + "', "
                    + "cidade = '" + vendido.getCidade() + "', "
                    + "cep = '" + vendido.getCep() + "', "
                    + "logradouro = '" + vendido.getLogradouro() + "', "
                    + "cidade = '" + vendido.getCidade() + "', "
                    + "numero = '" + vendido.getNumero() + "', "
                    + "nQuartos = '" + vendido.getnQuartos() + "', "
                    + "nBanheiros = '" + vendido.getnBanheiros() + "', "
                    + "precoAnunciado = '" + vendido.getPrecoAnunciado() + "' "
                    + "where idimovel = " + vendido.getIdImovel();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}