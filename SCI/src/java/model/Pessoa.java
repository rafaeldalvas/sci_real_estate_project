/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

public abstract class Pessoa {
    int matricula;
    private String nome;
    private String sexo;
    private String telefone;
    private String email;
    private String cidade;
    private String estado;
    private String cep;
    private String logradouro;
    private String numero;
    private int cpf;

    public Pessoa(int matricula, String nome, String sexo, String telefone, String email, String cidade, String estado, String cep, String logradouro, String numero, int cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cpf = cpf;
    }
    
    public int getMatricula() {
        return matricula;
    }
    
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}