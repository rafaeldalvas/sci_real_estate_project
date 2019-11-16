/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

import dao.ImovelVendaDAO;
import java.sql.SQLException;
import java.util.List;

public class ImovelVenda extends Imovel {
    private float precoAnunciado;

    public ImovelVenda(int idImovel, String cidade, String cep, String logradouro, String numero, float area, int nQuartos, int nBanheiros, float precoAnunciado) {
        super(idImovel, cidade, cep, logradouro, numero, area, nQuartos, nBanheiros);
        this.precoAnunciado = precoAnunciado;
    }

      public float getPrecoAnunciado() {
        return precoAnunciado;
    }

    
    public void setPrecoAnunciado(float precoAnunciado) {
        this.precoAnunciado = precoAnunciado;
    }
    
    public static ImovelVenda obterVendido(int idImovel) throws ClassNotFoundException, SQLException{
        return ImovelVendaDAO.obterImovelVenda(idImovel);
    }

    public static List<ImovelVenda> obterVendidos() throws ClassNotFoundException, SQLException {
        return ImovelVendaDAO.obterImovelVendas();
    }
    
}

