package MODEL;

import DAO.CandidatoDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Gravar{  

public static int votosNulosRelatorio;
public static int votosCandidatosRelatorio;
public static int votosBrancosRelatorio;
public static String valorResultSet;
public static StringBuilder sb;
public static ArrayList<StringBuilder> linhasGlobal;
    


//    public void gravarTxt() {
//  
//    File arquivo = new File("c:\\users\\windows\\desktop\\nome_do_arquivo.txt");
// 
//    try {
// 
//        if (!arquivo.exists()) {
//        //cria um arquivo (vazio)
//        arquivo.createNewFile();
//        }
// 
//        //caso seja um diretório, é possível listar seus arquivos e diretórios
//        File[] arquivos = arquivo.listFiles();
// 
//                //escreve no arquivo
//        FileWriter fw = new FileWriter(arquivo, true);
// 
//        BufferedWriter bw = new BufferedWriter(fw);
// 
//        bw.write("============   Relatório de Votos  ============");
//        bw.write("\r\n===============================================");
//        bw.write("\r\n==== Soma de votos de todos candidatos: " + votosCandidatosRelatorio + " ===="); 
//        bw.write("\r\n==== Quantidade de votos nulos:         " + votosNulosRelatorio + " ====");
//        bw.write("\r\n==== Quantidade de votos em branco:     " + votosBrancosRelatorio + " ====\r\n");
//        bw.newLine();      
//        bw.close();
//        fw.close();
// 
//        //faz a leitura do arquivo
//        FileReader fr = new FileReader(arquivo);
// 
//        BufferedReader br = new BufferedReader(fr);
// 
//        //equanto houver mais linhas
//        while (br.ready()) {
//        //lê a proxima linha
//        String linha = br.readLine();
// 
//        //faz algo com a linha
//        System.out.println(linha);
//        }
// 
//        br.close();
//        fr.close();
// 
//        } catch (IOException ex) {
//        ex.printStackTrace();
//        }
// 
//        JOptionPane.showMessageDialog(null,"Resultados salvos em: "+ arquivo);
//    
//        }

//PEGANDO DADOS DIRETO DO RESULTSET 
//COM ESCOLHA DE DIRETÓRIO E NOME DO ARQUIVO PRÉ-DEFINIDO
//        public void salvaArquivo() throws IOException {  
//               
//            String colunaCandidatos = "Candidatos";
//            String colunaPartidos = "Partidos";
//            String colunaVotos = "Votos";
//            
//             CandidatoDAO candidatoDAO = new CandidatoDAO();
//             
//             
//             ResultSet rs = candidatoDAO.obterCandidatos();
//            
//            JFileChooser salvandoArquivo = new JFileChooser(); 
//            FileNameExtensionFilter filter = new FileNameExtensionFilter(
//        "txt", "jpg", "txt");
//            salvandoArquivo.setFileFilter(filter);
//            salvandoArquivo.setSelectedFile(new File("Relatório.txt"));
//           
//        int resultado = salvandoArquivo.showSaveDialog(null);  
//        if (resultado != JFileChooser.APPROVE_OPTION) {  
//            return;  
//        }  
//      
//        File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();  
//          
//        
//        try {
// 
//        if (salvarArquivoEscolhido.exists()) {
//        //cria um arquivo (vazio)
//           
//        if (JOptionPane.showConfirmDialog(null, "Deseja substituir o arquivo existente ?", "Atenção !!!",JOptionPane.YES_NO_OPTION)==1){        
//        return;
//        }
//        else
//            salvarArquivoEscolhido.delete();
//        }
//        
//        PrintWriter pw = new PrintWriter(new FileWriter(salvarArquivoEscolhido.getPath()));
// 
// try {
//     
//        pw.printf("     ============   Relatório de Votos  ============");
//        pw.printf("\r\n        ========================================");
//        pw.printf("\r\n\r\n\r\n\r\n     * Soma de votos de todos candidatos: %d" , votosCandidatosRelatorio , " ===="); 
//        pw.printf("\r\n     * Quantidade de votos nulos:         %d" , votosNulosRelatorio );
//        pw.printf("\r\n     * Quantidade de votos em branco:     %d" , votosBrancosRelatorio);
//        
//        pw.printf("\r\n\r\n\r\n\r\n\r\n     %-20s %-17s %-20s" , colunaCandidatos, colunaPartidos, colunaVotos);
//        pw.printf("\r\n-------------------------------------------------");
//            while (rs.next()) {
//                                  
//                    pw.printf("\r\n     %-20s",rs.getString("nome")); 
//                    pw.printf("%-20s",rs.getString("partido"));
//                    pw.printf("%-20s", rs.getString("votos"));
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao carregar tabela: " + e.getMessage());
//        } 
//        
//        
//        
//        
//        pw.close();
//        JOptionPane.showMessageDialog(null,"Resultados salvos em: "+ salvarArquivoEscolhido.getPath());
//    
//        } 
//        
//        catch (IOException ex) {
//        ex.printStackTrace();
//        }
//         }
//        
        
  
//PEGANDO DADOS DIRETO DA TABELA DE OUTRA CLASSE ATRAVÉS DE VARIÁVEIS GLOBAIS
//COM ESCOLHA DE DIRETÓRIO E NOME DO ARQUIVO PRÉ-DEFINIDO
        public void gravar(String texto) throws IOException {  
            String colunaCandidatos = String.format("%-20s", "Candidatos");
            String colunaPartidos = String.format("%-19s", "Partidos");
            String colunaVotos = String.format("Votos");
            
            
            JFileChooser salvandoArquivo = new JFileChooser(); 
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "txt", "jpg", "txt");
            salvandoArquivo.setFileFilter(filter);
            salvandoArquivo.setSelectedFile(new File("Relatório.txt"));
           
        int resultado = salvandoArquivo.showSaveDialog(null);  
        if (resultado != JFileChooser.APPROVE_OPTION) {  
            return;  
        }          
        File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();  
          
       // conteudo += "\r\n";
        
        try {
 
        if (salvarArquivoEscolhido.exists()) {
        //cria um arquivo (vazio)
           
        if (JOptionPane.showConfirmDialog(null, "Deseja substituir o arquivo existente ?", "Atenção !!!",JOptionPane.YES_NO_OPTION)==1){        
        return;
        }
        else
            salvarArquivoEscolhido.delete();
        }
       
        BufferedWriter bw = new BufferedWriter(new FileWriter(salvarArquivoEscolhido.getPath()));
 
        
        bw.write("     ============   Relatório de Votos  ===========");
        bw.write("\r\n        ========================================");
        bw.write("\r\n\r\n\r\n\r\n     * Soma de votos de todos candidatos: " + votosCandidatosRelatorio ); 
        bw.write("\r\n\r\n     * Quantidade de votos nulos:         " + votosNulosRelatorio );
        bw.write("\r\n\r\n     * Quantidade de votos em branco:     "  + votosBrancosRelatorio);
        bw.write("\r\n\r\n\r\n\r\n     --------------------------------------------");
        bw.write("\r\n     " + colunaCandidatos + colunaPartidos+ colunaVotos);
        bw.write("\r\n     --------------------------------------------");
        bw.newLine();
        
 try {
     
           for(StringBuilder b: linhasGlobal){     
           bw.write("     "+b.toString()+"\r\n"); 
           bw.newLine();           
           
           }    
        } catch (Exception e) {
            System.out.println("Erro ao carregar tabela: " + e.getMessage());
        } 
        
        
        
        
        bw.close();
        JOptionPane.showMessageDialog(null,"Resultados salvos em: "+ salvarArquivoEscolhido.getPath());
    
        } 
        
        catch (IOException ex) {
        ex.printStackTrace();
        }
         }
        
        
        
        
        
        }
        
        
   
