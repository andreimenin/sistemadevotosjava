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
public class CandidatoDAO {
    Connection con = null;
    //A classe PreparedStatement é utilizada para
    //enviar comando sql ao banco de dados
    PreparedStatement pre = null;
    Conexao conexao = new Conexao();
      
    public void incluirCandidatos(String nome, int numero, String partido){ 
        con = conexao.obterConexaoComBD();
        try{
            String sql = "insert into candidatos "
                    + "(nome,numero,partido) values (?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setInt(2, numero);
            pre.setString(3, partido);
           
            
            pre.executeUpdate();
            System.out.println(pre);
            JOptionPane.showMessageDialog(null,"Incluído com sucesso !");
            
        }
        catch(SQLIntegrityConstraintViolationException ex )
        {
           JOptionPane.showMessageDialog(null, "Número já usado para algum candidato.\n Digite novamente");
            System.out.println("Número único, não pode ser repetido no banco de dados.");
        }
        
        catch(Exception e){
            System.out.println("Erro ao incluir: ");
            System.out.println(e.getMessage());
        }        
    }
    
    
    //Método da aula 7 (CONSULTA)
    public ResultSet obterCandidatos(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
       
        try{
            String sql = "select * from candidatos";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter candidatos: " + e.getMessage());
            
        }
        return rs;
        
    }

    public void alterarCandidatos(int codigo, String nome,int numero, String partido){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "update candidatos set nome = ?, numero = ?, partido = ? where codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setInt(2, numero);
            ps.setString(3, partido);            
                                
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
    
    public void excluirCandidatos(int codigo){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "delete from candidatos where codigo = ?";
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
    
  public ResultSet pesquisarCandidatoPorNumero(int numero){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from candidatos where numero like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();     
            
            
        }
        catch(Exception e){
            
            System.out.println(e.getMessage());
        }   
        
        return rs;
    }
  
  
  public ResultSet pesquisarCandidatoPorPartido(String partido){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from candidatos where partido like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, partido);
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();   
            
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
        
        return rs;
    }
  
        
    
   public void atualizarVotos(int codigo, int votos){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "update candidatos set votos = ? where codigo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                       
            ps.setInt(1, votos);                               
            ps.setInt(2, codigo);            
            
            ps.executeUpdate();
            
            
            System.out.println(ps);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Voto sucedido !");           
            
        }
        catch(Exception e){
            System.out.println("Erro ao alterar: " + e.getMessage());
        }        
    }
    
   //Obtém a soma de votos de todos os candidatos
    public ResultSet obterSomaVotos(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
       
        try{
            String sql = "select sum(votos) as sum_value from candidatos";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter soma de votos: " + e.getMessage());
            
        }
        return rs;
        
    }
   

    public ResultSet ordenarPorNome(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
       
        try{
            String sql = "select * from candidatos order by nome asc";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter candidatos: " + e.getMessage());
            
        }
        return rs;
        
    }
    
    public ResultSet ordenarPorVotos(){
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
       
        try{
            String sql = "select * from candidatos order by votos desc";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();            
        }
        catch(Exception e)
        {
            System.out.println("Erro ao obter candidatos: " + e.getMessage());
            
        }
        return rs;
        
    }
    
    
    public ResultSet pesquisarCandidatoPorPartidoORDENADO(String partido){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from candidatos where partido like ? order by nome asc";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, partido);
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();               
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
        
        return rs;
    }
    
    public ResultSet pesquisarCandidatoPorPartidoOrdenadoPorVotos(String partido){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from candidatos where partido like ? order by votos desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, partido);
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();               
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
        
        return rs;
    }
    
    
    
    public ResultSet pesquisarCandidatoPorNome(String nome){
        
        Conexao conexao = new Conexao();
        con = conexao.obterConexaoComBD();
        ResultSet rs = null;
        try{
            String sql = "select * from candidatos where nome like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome + '%');
            System.out.println("Comando sql: " + ps);
            rs = ps.executeQuery();   
            
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
        
        return rs;
    }
    
    
    
    public void zerarVotosCandidatos(int votos){ 
        try{
            Conexao conexao = new Conexao();
            con = conexao.obterConexaoComBD();
            String sql = "update candidatos set votos = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                       
            ps.setInt(1, votos);                               
                        
            
            ps.executeUpdate();
            
            
            System.out.println(ps);
            ps.executeUpdate();
           
            
        }
        catch(Exception e){
            System.out.println("Erro ao alterar: " + e.getMessage());
        }        
    }
    
    
    
    
    
}
