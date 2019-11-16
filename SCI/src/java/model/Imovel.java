/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

public abstract class Imovel {
    
    private int idImovel;
    private String cidade;
    private String cep;
    private String logradouro;
    private String numero;
    private float area;
    private int nQuartos;
    private int nBanheiros;

    public Imovel(int idImovel, String cidade, String cep, String logradouro, String numero, float area, int nQuartos, int nBanheiros) {
        this.idImovel = idImovel;
        this.cidade = cidade;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.area = area;
        this.nQuartos = nQuartos;
        this.nBanheiros = nBanheiros;
    }
    
    

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getnQuartos() {
        return nQuartos;
    }

    public void setnQuartos(int nQuartos) {
        this.nQuartos = nQuartos;
    }

    public int getnBanheiros() {
        return nBanheiros;
    }

    public void setnBanheiros(int nBanheiros) {
        this.nBanheiros = nBanheiros;
    }  
}
