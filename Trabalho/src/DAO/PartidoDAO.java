package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class PartidoDAO {
    Connection con = null;
    //A classe PreparedStatement é utilizada para
    //enviar comando sql ao banco de dados
    PreparedStatement pre = null;
    Conexao conexao = new Conexao();
    
    public void incluirUsuarios(String nome, int numero){ 
        con = conexao.obterConexaoComBD();
        try{
            String sql = "insert into partidos "
                    + "(nome,numero) values (?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setInt(2, numero);          
            
            pre.executeUpdate();
            System.out.println(pre);
            JOptionPane.showMessageDialog(null,"Incluído com sucesso !");
            
        }
        catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null, "Número já usado para algum partido.\n Digite novamente");
            System.out.println("Número único, não pode ser repetido no banco de dados.");
        }
        
        catch(Exception e){
            System.out.println("Erro ao incluir: ");
            System.out.println(e.getMessage());
        }
    }
    
    
    //Método da aula 7 (CONSULTA)
    public ResultSet obterPartidos(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        try{
            String sql = "select * from partidos";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter partidos: " + e.getMessage());
            
        }
        return rs;
    }

    public void alterarPartidos(int codigo, String nome,int numero){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "update partidos set nome = ?, numero = ? where codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setInt(2, numero);                      
                                
            ps.setInt(3, codigo);            
            
            ps.executeUpdate();
            
            
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso !");           
            
        }               
        catch(Exception e){
            System.out.println("Erro ao alterar: " + e.getMessage());
        }
        
    }
    
    public void excluirPartidos(int codigo){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "delete from partidos where codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                               
            ps.setInt(1, codigo);            
            
            ps.executeUpdate();
            
            
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso !");           
            
        }
        catch(Exception e){
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        
    }  
    public ResultSet pesquisarPartidoPorNome(String nome){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from partidos where nome like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome + '%');// % significa qualquer coisa depois do nome
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();     
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        return rs;
    }
    
    
    public ResultSet pesquisarPartidoPorNumero(int numero){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from partidos where numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero + '%');// % significa qualquer coisa depois do nome
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();     
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        return rs;
    }
    
  
	
    
}
