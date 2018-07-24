package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class UsuarioDAO {
    Connection con = null;
    //A classe PreparedStatement é utilizada para
    //enviar comando sql ao banco de dados
    PreparedStatement pre = null;
    Conexao conexao = new Conexao();
    
    public void incluirUsuarios(String nome, String senha, String nivel){ 
        con = conexao.obterConexaoComBD();
        try{
            String sql = "insert into usuarios "
                    + "(nome,senha,nivel) values (?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, senha);
            pre.setString(3, nivel);
           
            
            pre.executeUpdate();
            System.out.println(pre);
            JOptionPane.showMessageDialog(null,"Incluído com sucesso !");
            
        }catch(Exception e){
            System.out.println("Erro ao incluir: ");
            System.out.println(e.getMessage());
        }
    }
    
    
    //Método da aula 7 (CONSULTA)
    public ResultSet obterUsuarios(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        try{
            String sql = "select * from usuarios";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter usuários: " + e.getMessage());
            
        }
        return rs;
    }

    public void alterarUsuarios(int codigo, String nome,String senha, String nivel){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "update usuarios set nome = ?, senha = ?, nivel = ? where codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setString(2, senha);
            ps.setString(3, nivel);            
                                
            ps.setInt(4, codigo);            
            
            ps.executeUpdate();
            
            
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso !");           
            
        }
        catch(Exception e){
            System.out.println("Erro ao alterar: " + e.getMessage());
        }
        
    }
    
    public void excluirUsuarios(int codigo){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "delete from usuarios where codigo = ?";
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
    public ResultSet pesquisarUsuarioPorNome(String nome){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from usuarios where nome like ?";
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
    
    
//    public ResultSet pesquisarUsuarioPorNivel(String nivel){
//        
//        Conexao conexao = new Conexao();
//        con = conexao.obterConexaoComBD();
//        ResultSet rs = null;
//        try{
//            String sql = "select * from usuarios where nivel like ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, nivel + '%');// % significa qualquer coisa depois do nível
//            System.out.println("Comando sql: " + ps);
//            rs = ps.executeQuery();     
//            
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        
//        return rs;
//    }
//    
  
    
}
