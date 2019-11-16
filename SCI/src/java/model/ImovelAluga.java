/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

import dao.ImovelAlugaDAO;
import java.sql.SQLException;
import java.util.List;

public class ImovelAluga extends Imovel{
     private float valorAnunciado;

    public ImovelAluga(int idImovel, String cidade, String cep, String logradouro, String numero, float area, int nQuartos, int nBanheiros, float valorAnunciado) {
        super(idImovel, cidade, cep, logradouro, numero, area, nQuartos, nBanheiros);
        this.valorAnunciado = valorAnunciado;
    }

    public float getValorAnunciado() {
        return valorAnunciado;
    }

    public void setValorAnunciado(float valorAnunciado) {
        this.valorAnunciado = valorAnunciado;
    }
    
    public static ImovelAluga obterAlugado(int idImovel) throws ClassNotFoundException, SQLException{
        return ImovelAlugaDAO.obterImovelAluguel(idImovel);
    }

    public static List<ImovelAluga> obterAlugados() throws ClassNotFoundException, SQLException {
        return ImovelAlugaDAO.obterImovelAlugueis();
    }
     
     
}
