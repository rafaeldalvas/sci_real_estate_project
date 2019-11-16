/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti 
    Rafael Dalvas 
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement; 

public class DAO {
    
    public static void fecharConexao(Connection conexao, Statement comando) throws SQLException{
        if(comando != null){
            comando.close();
        }
        if(comando != null){
            comando.close();
        }
    }
}
