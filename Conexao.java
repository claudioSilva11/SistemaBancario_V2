/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jc_bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carla
 */
public class Conexao {
    
	
    private final String url = "jdbc:postgresql://localhost:5432/Sistema_Bancario";
    private final String user = "postgres"; 
    private final String password = "jesusteama";
    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
   
    public void cadastroCliente(/*Conta cliente/* */){
            try (Connection conexao = connect();
                    Statement stmt=conexao.createStatement()){
                                    try {
                                    stmt.executeQuery("insert into usuario (tipoconta, nome, sobrenome, senha, cheque, cpf) values (?, ?, ?, ?, ?,?)");
                                    } catch
                                            (SQLException e ) {
                                                                    throw new Error("Problema insert", e);
                                            //TODO: handle exception
                                    }
                            } catch (SQLException e) {
                                            throw new Error("Problema na conexão", e);
                                            }
                            }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
