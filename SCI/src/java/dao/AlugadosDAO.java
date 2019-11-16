/*
 Trabalho SI 6º Período - Prof. Marco Antonio
 Autores:
 João Paulo Bonetti
 Rafael Dalvas
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Aluguel;
import model.ImovelAluga;

public class AlugadosDAO extends DAO {

    public static List<Aluguel> obterAlugados() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Aluguel> alugueis = new ArrayList<Aluguel>();
        Aluguel aluguel = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from alugueis");
            while (rs.next()) {
                aluguel = instanciarAlugado(rs);
                alugueis.add(aluguel);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return alugueis;
    }

    public static Aluguel instanciarAlugado(ResultSet rs) throws SQLException {
        Aluguel alugados = new Aluguel(
                rs.getInt("idAluguel"),
                null,//QUANDO FOR UMA CHAVE ESTRANGEIRA, COLOCAR NULL POR ENQUANTO - TRATAREMOS DEPOIS
                null, //QUANDO FOR UMA CHAVE ESTRANGEIRA, COLOCAR NULL POR ENQUANTO - TRATAREMOS DEPOIS
                rs.getString("nomeAlugatario"),
                rs.getString("cpfAlugatario"),
                rs.getFloat("valorDeAluguel"),
                rs.getFloat("valorCalcao"));
        alugados.setIdImovelAluguel(rs.getInt("imovelAlugado"));
        alugados.setMatriculaCorretorResponsavel(rs.getInt("responsavelAluguel"));
        return alugados;
    }

    public static Aluguel obterAlugado(int idAluguel) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Aluguel aluguel = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from alugueis where idaluguel = '" + idAluguel + "'");
            rs.first();
            aluguel = instanciarAlugado(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return aluguel;
    }

    public static void gravar(Aluguel aluguel) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into alugueis (idaluguel, imovelAlugado, responsavelAluguel,"
                    + " nomeAlugatario, cpfAlugatario, valorDeAluguel, valorCalcao)"
                    + " values (?,?,?,?,?,?,?)");
            comando.setInt(1, aluguel.getIdAluguel());
            if (aluguel.getImovelAlugado() == null) {
                comando.setNull(2, Types.INTEGER);
            } else {
                comando.setInt(2, aluguel.getImovelAlugado().getIdImovel());
            }
            if (aluguel.getResponsavelAluguel() == null) {
                comando.setNull(3, Types.INTEGER);
            } else {
                comando.setInt(3, aluguel.getResponsavelAluguel().getMatricula());
            }
            comando.setString(4, aluguel.getNomeAlugatario());
            comando.setString(5, aluguel.getCpfAlugatario());
            comando.setFloat(6, aluguel.getValorDeAluguel());
            comando.setFloat(7, aluguel.getValorCalcao());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Aluguel aluguel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from alugueis where idaluguel = " + aluguel.getIdAluguel();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Aluguel aluguel) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String stringSQL = "update alugueis set "
                    + "idaluguel = '" + aluguel.getIdAluguel() + "', "
                    + "imovelAlugado = '";
            if (aluguel.getImovelAlugado() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + aluguel.getImovelAlugado().getIdImovel();
            }
            stringSQL = stringSQL + "', responsavelAluguel = '";
            if (aluguel.getResponsavelAluguel() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + aluguel.getResponsavelAluguel().getMatricula();
            }
            stringSQL = stringSQL + "', nomeAlugatario = '" + aluguel.getNomeAlugatario() + "', "
                    + "cpfAlugatario = '" + aluguel.getCpfAlugatario() + "', "
                    + "valorDeAluguel = '" + aluguel.getValorDeAluguel() + "', "
                    + "valorCalcao = '" + aluguel.getValorCalcao() + "' "
                    + "where idaluguel = " + aluguel.getIdAluguel();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
