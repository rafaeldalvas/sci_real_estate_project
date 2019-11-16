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
import model.ImovelAluga;

public class ImovelAlugaDAO extends DAO {

    public static List<ImovelAluga> obterImovelAlugueis() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ImovelAluga> imoveis = new ArrayList<ImovelAluga>();
        ImovelAluga imovel = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from imovelaluga");
            while (rs.next()) {
                imovel = instanciarImovelAluga(rs);
                imoveis.add(imovel);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return imoveis;
    }
    
    public static ImovelAluga obterImovelAluguel(int idimovel) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ImovelAluga imovelAluga = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from imovelAluga where idimovel = '" + idimovel + "'" );
            rs.first();
            imovelAluga = instanciarImovelAluga(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return imovelAluga;
    }

    public static ImovelAluga instanciarImovelAluga(ResultSet rs) throws SQLException {
        ImovelAluga imovelAluga = new ImovelAluga(
                rs.getInt("idImovel"),
                rs.getString("cidade"),
                rs.getString("cep"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getFloat("area"),
                rs.getInt("nQuartos"),
                rs.getInt("nBanheiros"),
                rs.getFloat("valorAnunciado"));
        return imovelAluga;
    }

    public static void gravar(ImovelAluga aluga) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into imovelaluga (idimovel, cidade, cep, logradouro, numero, area,"
                    + " nQuartos, nBanheiros, valorAnunciado) values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, aluga.getIdImovel());
            comando.setString(2, aluga.getCidade());
            comando.setString(3, aluga.getCep());
            comando.setString(4, aluga.getLogradouro());
            comando.setString(5, aluga.getNumero());
            comando.setFloat(6, (float) aluga.getArea());
            comando.setInt(7, aluga.getnQuartos());
            comando.setInt(8, aluga.getnBanheiros());
            comando.setFloat(9, aluga.getValorAnunciado());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(ImovelAluga aluga) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from imovelaluga where idimovel = " + aluga.getIdImovel();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(ImovelAluga aluga) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String stringSQL = "update imovelaluga set "
                    + "idimovel = '" + aluga.getIdImovel() + "', "
                    + "cidade = '" + aluga.getCidade() + "', "
                    + "cep = '" + aluga.getCep() + "', "
                    + "logradouro = '" + aluga.getLogradouro() + "', "
                    + "cidade = '" + aluga.getCidade() + "', "
                    + "numero = '" + aluga.getNumero() + "', "
                    + "nQuartos = '" + aluga.getnQuartos() + "', "
                    + "nBanheiros = '" + aluga.getnBanheiros() + "', "
                    + "valorAnunciado = '" + aluga.getValorAnunciado() + "' "
                    + "where idimovel = " + aluga.getIdImovel();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
