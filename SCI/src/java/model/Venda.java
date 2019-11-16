/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

import java.sql.SQLException;

public class Venda {
    private int idVenda;
    private ImovelVenda imovelVendido;
    private Corretor responsavelVenda;
    private String nomeComprador;
    private String cpfComprador;
    private float valorEntrada;
    private int numPercelas;
    private float valorParcela;
    private float valorVenda;
    private String dataVenda;
    private int idImovelVendido;
    private int matriculaCorretorResponsavel;    

    public Venda(int idVenda, ImovelVenda imovelVendido, Corretor responsavelVenda, String nomeComprador, String cpfComprador, float valorEntrada, int numPercelas, float valorParcela, float valorVenda, String dataVenda) {
        this.idVenda = idVenda;
        this.imovelVendido = imovelVendido;
        this.responsavelVenda = responsavelVenda;
        this.nomeComprador = nomeComprador;
        this.cpfComprador = cpfComprador;
        this.valorEntrada = valorEntrada;
        this.numPercelas = numPercelas;
        this.valorParcela = valorParcela;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public ImovelVenda getImovelVendido() throws ClassNotFoundException, SQLException {
        if ((this.idImovelVendido != 0) && (this.imovelVendido == null)) {
            this.imovelVendido = ImovelVenda.obterVendido(this.idImovelVendido);
        }
        return imovelVendido;
    }

    public void setImovelVendido(ImovelVenda imovelVendido) {
        this.imovelVendido = imovelVendido;
    }

    public Corretor getResponsavelVenda() throws ClassNotFoundException, SQLException {
        if ((this.matriculaCorretorResponsavel != 0) && (this.responsavelVenda == null)) {
            this.responsavelVenda = Corretor.obterCorretor(this.matriculaCorretorResponsavel);
        }
        return responsavelVenda;
    }

    public void setResponsavelVenda(Corretor responsavelVenda) {
        this.responsavelVenda = responsavelVenda;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getNumPercelas() {
        return numPercelas;
    }

    public void setNumPercelas(int numPercelas) {
        this.numPercelas = numPercelas;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdImovelVendido() {
        return idImovelVendido;
    }

    public void setIdImovelVendido(int idImovelVendido) {
        this.idImovelVendido = idImovelVendido;
    }

    public int getMatriculaCorretorResponsavel() {
        return matriculaCorretorResponsavel;
    }

    public void setMatriculaCorretorResponsavel(int matriculaCorretorResponsavel) {
        this.matriculaCorretorResponsavel = matriculaCorretorResponsavel;
    }           
}
