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
 * @author Cláudio
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
    public void todosUsuarios(){      // ver todos os usuário no banco de dados
        try (Connection conexao = connect();
                Statement stmt=conexao.createStatement()){
                                try {
                                stmt.executeQuery("(SELECT * FROM usuarios) ");
                                } catch
                                        (SQLException e ) {
                                                                throw new Error("Problema insert", e);
                                        
                                }
                        } catch (SQLException e) {
                                        throw new Error("Problema na conexão", e);
                                        }
                        }
   
    public void cadastroCliente(){      // Insere o novo usuário no banco de dados
            try (Connection conexao = connect();
                    Statement stmt=conexao.createStatement()){
                                    try {
                                    stmt.executeQuery("INSERT INTO usuarios(tipo_conta, nome, sobrenome, senha, cheque, cpf, tipo_usuario) VALUES (?, ?, ?, ?, ?,?, ?)");
                                    } catch
                                            (SQLException e ) {
                                                                    throw new Error("Problema insert", e);
                                            
                                    }
                            } catch (SQLException e) {
                                            throw new Error("Problema na conexão", e);
                                            }
                            }

    public void login(){          // Faz login caso o usuário seja cadastrado
        try (Connection conexao = connect();
                Statement stmt=conexao.createStatement()){
                                try {
                                stmt.executeQuery("(SELECT * FROM usuarios WHERE login=? and senha=?)");
                                
                                } catch
                                        (SQLException e ) {
                                                                throw new Error("Problema no select", e);
                                        
                                }
                        } catch (SQLException e) {
                                        throw new Error("Problema na conexão", e);
                                        }
                        }


    public void extrato(){   // Retorna o extrato do procedimento
            try (Connection conexao = connect();
                    Statement stmt=conexao.createStatement()){
                                    try {
                                    stmt.executeQuery("(SELECT * FROM extrato)");
                                    } catch
                                            (SQLException e ) {
                                                                    throw new Error("Problema no select", e);
                                            
                                    }
                            } catch (SQLException e) {
                                            throw new Error("Problema na conexão", e);
                                            }
                            }
        public void consultarContasCorrente(){ // Essa função me retornara os nomes dos usuários que possuem conta... 
                try (Connection conexao = connect();  // corrente e o seu saldo
                Statement stmt=conexao.createStatement()){
                                try {
                                stmt.executeQuery("(SELECT usuarios.nome, conta_corrente.saldo from usuarios, conta_corrente where usuarios.id=conta_corrente.id;)");
                                } catch
                                        (SQLException e ) {
                                                                throw new Error("Problema no select", e);
                                        
                                }
                        } catch (SQLException e) {
                                        throw new Error("Problema na conexão", e);
                                        }
                        }

public void consultarContasPoupanca(){  // Essa função me retornara os nomes dos usuários que possuem conta... 
        try (Connection conexao = connect();  // poupança e o seu saldo
                Statement stmt=conexao.createStatement()){
                                try {
                                stmt.executeQuery("(SELECT usuarios.nome, conta_poupanca.saldo from usuarios, conta_poupanca where usuarios.id=conta_poupanca.id;)");
                                } catch
                                        (SQLException e ) {
                                                                throw new Error("Problema no select", e);
                                        
                                }
                        } catch (SQLException e) {
                                        throw new Error("Problema na conexão", e);
                                        }
                        }
                        
    public static void main(String[] args) {
        Conexao bd= new Conexao();
        bd.cadastroCliente();
        
    }
    
}

