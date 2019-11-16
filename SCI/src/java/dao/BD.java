/*
    Trabalho SI 6º Período - Prof. Marco Antonio
    Autores:
    João Paulo Bonetti 
    Rafael Dalvas 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/db_sci", "root","");
        return conexao;
    }
}
