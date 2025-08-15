package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String url = "";
    private static final String user = "";
    private static final String password = "";


    private Conexao() {

    }

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return null;
    }
}
