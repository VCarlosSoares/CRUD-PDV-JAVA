package trabalhojavaav2.Interfaces;

import trabalhojavaav2.OperacaoCadastro;
import trabalhojavaav2.Classes.ItemVenda;
import trabalhojavaav2.Classes.Venda;
import trabalhojavaav2.Classes.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import trabalhojavaav2.Arquivos.ArquivoProdutos;
/**
 *
 * @author vitor
 */
public class MenuCadItemVenda extends javax.swing.JDialog {

    private OperacaoCadastro operacaoCadastro;
    private ItemVenda itemVenda;
    private Venda venda;
    private boolean confirmado;
    private ArquivoProdutos arquivo;
    private ArrayList <Produto> produtos;
    
    public MenuCadItemVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public MenuCadItemVenda(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, Venda venda, ItemVenda itemVenda) {
        super (parent, true);
        this.operacaoCadastro=operacaoCadastro;
        this.venda = venda;
        this.itemVenda=itemVenda;
        confirmado=false;
        
        arquivo = new ArquivoProdutos("Produtos.txt");
        produtos = new ArrayList<Produto>();
        produtos = arquivo.abrirTxt();
        
        initComponents();
        
        textCodigoVendaItemVenda.setText(String.valueOf(venda.obterCodigo()));
        if (operacaoCadastro == operacaoCadastro.ocAlterar || operacaoCadastro == operacaoCadastro.ocConsultar) {
            textCodigoProdItemVenda.setText(String.valueOf(itemVenda.obterCodigoProduto()));
            textQuantidade.setText(String.valueOf(itemVenda.obterQuantidade()));
            int indice = buscarProduto(itemVenda.obterCodigoProduto());
            textPrecoUnitItemVenda.setText(String.valueOf(produtos.get(indice).obterPreco()));
            textPrecoTotalItemVenda.setText(String.valueOf(produtos.get(indice).obterPreco() * itemVenda.obterQuantidade()));
        }
        buCancelarItemVenda.setEnabled(operacaoCadastro != operacaoCadastro.ocConsultar);
        textCodigoProdItemVenda.setEnabled(operacaoCadastro != operacaoCadastro.ocConsultar);
        textQuantidade.setEnabled(operacaoCadastro != operacaoCadastro.ocConsultar);
        textCodigoVendaItemVenda.setEnabled(false);
        textPrecoUnitItemVenda.setEnabled(false);
        textPrecoTotalItemVenda.setEnabled(false);
    }
    
    public boolean operacaoConfirmada() {
        return confirmado;
    }
    
    public static boolean executar(java.awt.Frame parent, OperacaoCadastro operacaoCadastro, Venda venda, ItemVenda itemVenda) {
        MenuCadItemVenda menuCadItens = new MenuCadItemVenda(parent, operacaoCadastro, venda, itemVenda);
        menuCadItens.setLocationRelativeTo(null);
        menuCadItens.setVisible(true);
        return menuCadItens.operacaoConfirmada();
    }
    
    public int buscarProduto(int codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (codigo == produtos.get(i).obterCodigo()) {
                return i;
            }
        }
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textCodigoProdItemVenda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        textQuantidade = new javax.swing.JTextField();
        buOkItemVenda = new javax.swing.JButton();
        buCancelarItemVenda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textCodigoVendaItemVenda = new javax.swing.JTextField();
        textPrecoUnitItemVenda = new javax.swing.JTextField();
        textPrecoTotalItemVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro Item Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel1.setText("Código Produto:");

        jLabel3.setText("Quantidade:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buOkItemVenda.setText("Ok");
        buOkItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buOkItemVendaActionPerformed(evt);
            }
        });

        buCancelarItemVenda.setText("Cancelar");
        buCancelarItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buCancelarItemVendaActionPerformed(evt);
            }
        });

        jLabel2.setText("Código Venda:");

        jLabel5.setText("Preço Unit.:");

        jLabel6.setText("Preço Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textPrecoUnitItemVenda)
                    .addComponent(textCodigoVendaItemVenda, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCodigoProdItemVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(textQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPrecoTotalItemVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buOkItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buCancelarItemVenda))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textCodigoProdItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textPrecoUnitItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textPrecoTotalItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(textCodigoVendaItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buOkItemVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buCancelarItemVenda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buCancelarItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCancelarItemVendaActionPerformed
        dispose();
    }//GEN-LAST:event_buCancelarItemVendaActionPerformed

    private void buOkItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buOkItemVendaActionPerformed
        try {
            if (operacaoCadastro != OperacaoCadastro.ocConsultar) {
                int indice = buscarProduto(Integer.parseInt(textCodigoProdItemVenda.getText()));
                if (operacaoCadastro == OperacaoCadastro.ocIncluir) {
                    if (Integer.parseInt(textQuantidade.getText()) <= produtos.get(indice).obterEstoque()) {
                        itemVenda.atualizarCodigoVenda(Integer.parseInt(textCodigoVendaItemVenda.getText()));
                        itemVenda.atualizarCodigoProduto(Integer.parseInt(textCodigoProdItemVenda.getText()));
                        itemVenda.atualizarQuantidade(Integer.parseInt(textQuantidade.getText()));
                        itemVenda.atualizarPrecoUnit(produtos.get(indice).obterPreco());
                        itemVenda.atualizarPrecoTotal(produtos.get(indice).obterPreco() * 
                                                      Integer.parseInt(textQuantidade.getText()));

                        produtos.get(indice).atualizarEstoque(produtos.get(indice).obterEstoque() - 
                                                              Integer.parseInt(textQuantidade.getText()));

                        arquivo.salvarEmTxt(produtos);

                        confirmado = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Quantidade maior que estoque!");
                    }
                } else {
                    int backupQuantidade = itemVenda.obterQuantidade();
                    if (Integer.parseInt(textQuantidade.getText()) <= (produtos.get(indice).obterEstoque() + 
                                                                                            backupQuantidade)) {
                        itemVenda.atualizarCodigoVenda(Integer.parseInt(textCodigoVendaItemVenda.getText()));
                        itemVenda.atualizarCodigoProduto(Integer.parseInt(textCodigoProdItemVenda.getText()));
                        itemVenda.atualizarQuantidade(Integer.parseInt(textQuantidade.getText()));
                        itemVenda.atualizarPrecoUnit(produtos.get(indice).obterPreco());
                        itemVenda.atualizarPrecoTotal(produtos.get(indice).obterPreco() * 
                                                      Integer.parseInt(textQuantidade.getText()));

                        produtos.get(indice).atualizarEstoque(produtos.get(indice).obterEstoque() +
                                                              backupQuantidade -
                                                              Integer.parseInt(textQuantidade.getText()));

                        arquivo.salvarEmTxt(produtos);

                        confirmado = true;
                        }
                    }
                }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Entrada Invalida!\n"+e);
        }
        dispose();
    }//GEN-LAST:event_buOkItemVendaActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCadItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCadItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCadItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCadItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuCadItemVenda dialog = new MenuCadItemVenda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buCancelarItemVenda;
    private javax.swing.JButton buOkItemVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textCodigoProdItemVenda;
    private javax.swing.JTextField textCodigoVendaItemVenda;
    private javax.swing.JTextField textPrecoTotalItemVenda;
    private javax.swing.JTextField textPrecoUnitItemVenda;
    private javax.swing.JTextField textQuantidade;
    // End of variables declaration//GEN-END:variables
}
