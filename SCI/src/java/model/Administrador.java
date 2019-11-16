/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti
    Rafael Dalvas
 */
package model;

import dao.AdministradorDAO;
import java.sql.SQLException;
import java.util.List;

public class Administrador extends Pessoa {

    private String nivelCargo;

    public Administrador(int matricula, String nome, String sexo, String telefone, String email, String cidade, String estado, String cep, String logradouro, String numero, int cpf, String nivelCargo) {
        super(matricula, nome, sexo, telefone, email, cidade, estado, cep, logradouro, numero, cpf);
        this.nivelCargo = nivelCargo;
    }
    


    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }
    
    public static Administrador obterAdministrador(int matricula) throws ClassNotFoundException, SQLException{
        return AdministradorDAO.obterAdministrador(matricula);
    }
    
    public static List<Administrador> obterAdministradores() throws ClassNotFoundException, SQLException {
        return AdministradorDAO.obterAdministradores();
    }
    
}
