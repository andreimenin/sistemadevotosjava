package DAO;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei
 */
public class Conexao {
    
    Connection con = null;
    
        public Conexao(){
            carregarDriver();
        }
  
        public void carregarDriver(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Carregado");
            }
            catch(Exception e){
                System.out.println("Erro ao carregar o driver:");
                System.out.println(e.getMessage());
            }
        }
        
        public Connection obterConexaoComBD(){
            
            try{
                if ((con == null) || (con.isClosed()))
                {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/" + "bdeletiva", "root", "");
                    System.out.println("Conexão obtida com sucesso!");
                }
            }
                
                catch(Exception e)
                        {
                        System.out.println("Erro ao conectar com o  banco de dados:");
                        System.out.println(e.getMessage());
                        }
            
            return con;
            }     
        
        
}
