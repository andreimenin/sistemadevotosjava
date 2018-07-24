package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class NuloDAO {
   
    Connection con = null;
    //A classe PreparedStatement é utilizada para
    //enviar comando sql ao banco de dados
    PreparedStatement pre = null;
    Conexao conexao = new Conexao();
      
    public void incluirVotosNulos(int codigo,int votoNulo){ 
        con = conexao.obterConexaoComBD();
        try{
            String sql = "insert into nulos "
                    + "(codigo, votoNulo) values (?,?)";
            pre = con.prepareStatement(sql);
            pre.setInt(1, votoNulo); 
            pre.setInt(2, codigo); 
            
            pre.executeUpdate();
            System.out.println(pre);
            
        }catch(Exception e){
            System.out.println("Erro ao incluir: ");
            System.out.println(e.getMessage());
        }
    }
    
    //Método da aula 7 (CONSULTA)
    public ResultSet obterVotosNulos(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
       
        try{
            String sql = "select * from nulos";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter candidatos: " + e.getMessage());
            
        }
        return rs;
        
    }
    
    
    
    public void alterarQuantidadeVotoNulo(int votoNulo){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "update nulos set votoNulo = ? where codigo = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, votoNulo);            
            ps.executeUpdate();            
            
            System.out.println(ps);
            ps.executeUpdate();           
            
        }
        catch(Exception e){
            System.out.println("Erro ao alterar: " + e.getMessage());
        }        
    }   
    
}
