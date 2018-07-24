/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VIEW;

import DAO.UsuarioDAO;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class UsuarioVIEW extends javax.swing.JFrame {

    /**
     * Creates new form UsuarioVIEW
     */
    public UsuarioVIEW() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cbNivel = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtRegistro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Usuários");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Usuário: ");

        txtNomeUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Senha: ");

        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nível:");

        cbNivel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuário", "Administrador" }));
        cbNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNivelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Registros encontrados:");

        txtRegistro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRegistro.setText("txtRegistro");

        tbUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/symbol_add.png"))); // NOI18N
        jButton1.setText("Incluir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/symbol_refresh.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/symbol_restricted.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/arrow_left.png"))); // NOI18N
        jButton4.setText("Sair");
        jButton4.setPreferredSize(new java.awt.Dimension(85, 30));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRegistro))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(242, 242, 242))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(437, 437, 437))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(362, 362, 362)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(352, 352, 352))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        String senha = txtSenha.getText();
        
        if(senha.length()>=8){
        String nome = txtNomeUsuario.getText();
                
        String nivel = cbNivel.getSelectedItem().toString(); 
        
        UsuarioDAO dAO = new UsuarioDAO();
         dAO.incluirUsuarios(nome, senha, nivel);   
       JOptionPane.showMessageDialog(null, "Usuário incluido com sucesso !");
       ResultSet rs = dAO.obterUsuarios();
        carregarTabelaUsuarios(rs);
        }
        
        
        else{
        JOptionPane.showMessageDialog(null, "Senha precisa ter mais que 8 caracteres !");        
        
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        UsuarioDAO dDAO = new UsuarioDAO();
        ResultSet rs = dDAO.obterUsuarios();
        carregarTabelaUsuarios(rs);
    }//GEN-LAST:event_formWindowOpened

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
      //obtendo os dados da alteração
        UsuarioDAO dDAO = new UsuarioDAO();
        int linhaSelecionada = tbUsuarios.getSelectedRow();
        
        
        if(linhaSelecionada >= 0){        

        int codigo = Integer.parseInt(tbUsuarios.getModel().getValueAt(linhaSelecionada, 0).toString());

        String nome = txtNomeUsuario.getText();
        String senha = txtSenha.getText();
        String nivel = cbNivel.getSelectedItem().toString();       
        
        dDAO.alterarUsuarios(codigo, nome, senha, nivel);

        ResultSet rs = dDAO.obterUsuarios();
        carregarTabelaUsuarios(rs);
        }
        
        else
            JOptionPane.showMessageDialog(null, "Clique em alguma linha da tabela para poder alterar !");
    }//GEN-LAST:event_jButton2MousePressed

    private void tbUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMousePressed
 //numero da linha que está sendo selecionada na tabela
        int linhaSelecionada = tbUsuarios.getSelectedRow();

        //0 é a primeira coluna da tabela (código, que não será mudado)
        String nome = tbUsuarios.getModel().getValueAt(linhaSelecionada, 1).toString();

        String senha = tbUsuarios.getModel().getValueAt(linhaSelecionada, 2).toString();
        
        String nivel = tbUsuarios.getModel().getValueAt(linhaSelecionada, 3).toString();
        
        txtNomeUsuario.setText(nome);
        txtSenha.setText(senha);
        cbNivel.setSelectedItem(nivel);
    }//GEN-LAST:event_tbUsuariosMousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
       UsuarioDAO dDAO = new UsuarioDAO();
        int linhaSelecionada = tbUsuarios.getSelectedRow();
        
        if(linhaSelecionada >=0)
        {
            int codigo = Integer.parseInt(tbUsuarios.getModel().getValueAt(linhaSelecionada, 0).toString());
            
            dDAO.excluirUsuarios(codigo);
            
            ResultSet rs = dDAO.obterUsuarios();
            carregarTabelaUsuarios(rs);
            
        }
        else
            JOptionPane.showMessageDialog(null, "Clique em alguma linha da tabela para poder EXCLUIR !");
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        dispose();
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNivelActionPerformed

    
    public void carregarTabelaUsuarios(ResultSet rs) {
        String colunas[] = new String[]{"Codigo", "Nome", "Senha", "Nível"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunas){  
            public boolean isCellEditable(int rowIndex, int mColIndex) {  //evita editar conteúdo das células
                return false;  
            }  
        };//null são as linhas ainda não preenchidas
        tbUsuarios.setModel(modeloTabela);
        int contador = 0;
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);  
        
        tbUsuarios.getColumnModel().getColumn(0).setCellRenderer(centralizado);  
        tbUsuarios.getColumnModel().getColumn(1).setCellRenderer(centralizado);  
        tbUsuarios.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tbUsuarios.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                
        
        try {
            while (rs.next()) {
                String linha[] = new String[]{
                    rs.getString("codigo"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getString("nivel")
                      
                };
                modeloTabela.addRow(linha);
                contador = contador+1;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar tabela: " + e.getMessage());
        }

        txtRegistro.setText("" + contador);       
        
    }                     
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbNivel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JLabel txtRegistro;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
