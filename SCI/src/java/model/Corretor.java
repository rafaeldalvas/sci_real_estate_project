/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

import dao.CorretorDAO;
import java.sql.SQLException;
import java.util.List;

public class Corretor extends Pessoa {

    private Administrador admResponsavel;
    private int matriculaAdmResponsavel;
    
    public Corretor(int matricula, String nome, String sexo, String telefone, String email, String cidade, String estado, String cep, String logradouro, String numero,
                int cpf,Administrador admResponsavel) {
        super(matricula, nome, sexo, telefone, email, cidade, estado, cep, logradouro, numero, cpf);
        this.admResponsavel = admResponsavel;
    }


    public Administrador getAdmResponsavel() throws ClassNotFoundException, SQLException {
        if ((this.matriculaAdmResponsavel != 0) && (this.admResponsavel == null)) {
            this.admResponsavel = Administrador.obterAdministrador(this.matriculaAdmResponsavel);
        }
        return admResponsavel;
    }

    public void setAdmResponsavel(Administrador admResponsavel) {
        this.admResponsavel = admResponsavel;
    }
    
    public int getMatriculaAdmResponsavel() {
        return matriculaAdmResponsavel;
    }

    public void setMatriculaAdmResponsavel(int matriculaAdmResponsavel) {
        this.matriculaAdmResponsavel = matriculaAdmResponsavel;
    }

    public static Corretor obterCorretor(int matricula) throws ClassNotFoundException, SQLException{
        return CorretorDAO.obterCorretor(matricula);
    }

    public static List<Corretor> obterCorretores() throws ClassNotFoundException, SQLException {
        return CorretorDAO.obterCorretores();
    }
    
}
