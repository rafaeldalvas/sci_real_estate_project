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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendidosDAO extends DAO {
    private static Object venda;

    public static List<Venda> obterVendidos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Venda> vendas = new ArrayList<Venda>();
        Venda venda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from vendas");
            while (rs.next()) {
                venda = instanciarVendido(rs);
                vendas.add(venda);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return vendas;
    }
    
    public static Venda obterVendido(int idVenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Venda venda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from vendas where idVenda = '" + idVenda + "'" );
            rs.first();
            venda = instanciarVendido(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return venda;
    }

    public static Venda instanciarVendido(ResultSet rs) throws SQLException {
        Venda vendidos = new Venda(
                rs.getInt("idVenda"),
                null, //perguntar como fazer para o Marco
                null, //perguntar como fazer para o Marco
                rs.getString("nomeComprador"),
                rs.getString("cpfComprador"),
                rs.getFloat("valorEntrada"),
                rs.getInt("numParcelas"),
                rs.getFloat("valorParcela"),
                rs.getFloat("valorVenda"),
                rs.getString("dataVenda"));
        vendidos.setIdImovelVendido(rs.getInt("imovelVendido"));
        vendidos.setMatriculaCorretorResponsavel(rs.getInt("reponsavelVenda"));
        return vendidos;
    }

    public static void gravar(Venda vendido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into vendas (idVenda,imovelVendido,reponsavelVenda,nomeComprador,cpfComprador,"
                        + "valorEntrada,numParcelas,valorParcela,valorVenda,dataVenda) values (?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, vendido.getIdVenda());
            if (vendido.getImovelVendido() == null) {
                comando.setNull(2, Types.INTEGER);
            } else {
                comando.setInt(2, vendido.getImovelVendido().getIdImovel());
            }
            if (vendido.getResponsavelVenda() == null) {
                comando.setNull(3, Types.INTEGER);
            } else {
                comando.setInt(3, vendido.getResponsavelVenda().getMatricula());
            }
            comando.setString(4, vendido.getNomeComprador());
            comando.setString(5, vendido.getCpfComprador());
            comando.setFloat(6, vendido.getValorEntrada());
            comando.setInt(7, vendido.getNumPercelas());
            comando.setFloat(8, vendido.getValorParcela());
            comando.setFloat(9, vendido.getValorVenda());
            comando.setString(10, vendido.getDataVenda());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Venda vendido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from vendas where idVenda = " + vendido.getIdVenda();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Venda vendido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String stringSQL = "update vendas set "
                    + "idVenda = '" + vendido.getIdVenda() + "', "
                    + "imovelVendido = ";
                    if (vendido.getImovelVendido() == null) {
                        stringSQL = stringSQL + null;
                    } else {
                        stringSQL = stringSQL + vendido.getImovelVendido().getIdImovel();
                    }
                    stringSQL = stringSQL + ", reponsavelVenda = ";
                    if (vendido.getResponsavelVenda() == null) {
                        stringSQL = stringSQL + null;
                    } else {
                        stringSQL = stringSQL + vendido.getResponsavelVenda().getMatricula();
                    }
                    stringSQL = stringSQL + ", nomeComprador = '" + vendido.getNomeComprador() + "', "
                    + "cpfComprador = '" + vendido.getCpfComprador() + "', "
                    + "valorEntrada = '" + vendido.getValorEntrada() + "', "
                    + "numParcelas = '" + vendido.getNumPercelas() + "', "
                    + "valorVenda = '" + vendido.getValorVenda() + "', "
                    + "valorParcela = '" + vendido.getValorParcela() + "', "
                    + "dataVenda = '" + vendido.getDataVenda() + "' "
                    + "where idVenda = " + vendido.getIdVenda();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
