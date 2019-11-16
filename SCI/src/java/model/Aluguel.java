/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

import java.sql.SQLException;

public class Aluguel {

    private int idAluguel;
    private ImovelAluga imovelAlugado;
    private Corretor responsavelAluguel;
    private String nomeAlugatario;
    private String cpfAlugatario;
    private float valorDeAluguel;
    private float valorCalcao;
    private int idImovelAluguel;
    private int matriculaCorretorResponsavel;

    public Aluguel(int idAluguel, ImovelAluga imovelAlugado, Corretor responsavelAluguel, String nomeAlugatario, String cpfAlugatario, float valorDeAluguel, float valorCalcao) {
        this.idAluguel = idAluguel;
        this.imovelAlugado = imovelAlugado;
        this.responsavelAluguel = responsavelAluguel;
        this.nomeAlugatario = nomeAlugatario;
        this.cpfAlugatario = cpfAlugatario;
        this.valorDeAluguel = valorDeAluguel;
        this.valorCalcao = valorCalcao;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public ImovelAluga getImovelAlugado() throws ClassNotFoundException, SQLException {
        if ((this.idImovelAluguel != 0) && (this.imovelAlugado == null)) {
            this.imovelAlugado = ImovelAluga.obterAlugado(this.idImovelAluguel);
        }
        return imovelAlugado;
    }

    public void setImovelAlugado(ImovelAluga imovelAlugado) {
        this.imovelAlugado = imovelAlugado;
    }

    public Corretor getResponsavelAluguel() throws ClassNotFoundException, SQLException {
        if ((this.matriculaCorretorResponsavel != 0) && (this.responsavelAluguel == null)) {
            this.responsavelAluguel = Corretor.obterCorretor(this.matriculaCorretorResponsavel);
        }
        return responsavelAluguel;
    }

    public void setResponsavelAluguel(Corretor responsavelAluguel) {
        this.responsavelAluguel = responsavelAluguel;
    }

    public String getNomeAlugatario() {
        return nomeAlugatario;
    }

    public void setNomeAlugatario(String nomeAlugatario) {
        this.nomeAlugatario = nomeAlugatario;
    }

    public String getCpfAlugatario() {
        return cpfAlugatario;
    }

    public void setCpfAlugatario(String cpfAlugatario) {
        this.cpfAlugatario = cpfAlugatario;
    }

    public float getValorDeAluguel() {
        return valorDeAluguel;
    }

    public void setValorDeAluguel(float valorDeAluguel) {
        this.valorDeAluguel = valorDeAluguel;
    }

    public float getValorCalcao() {
        return valorCalcao;
    }

    public void setValorCalcao(float valorCalcao) {
        this.valorCalcao = valorCalcao;
    }

    public int getIdImovelAluguel() {
        return idImovelAluguel;
    }

    public void setIdImovelAluguel(int idImovelAluguel) {
        this.idImovelAluguel = idImovelAluguel;
    }

    public int getMatriculaCorretorResponsavel() {
        return matriculaCorretorResponsavel;
    }

    public void setMatriculaCorretorResponsavel(int matriculaCorretorResponsavel) {
        this.matriculaCorretorResponsavel = matriculaCorretorResponsavel;
    }

}
