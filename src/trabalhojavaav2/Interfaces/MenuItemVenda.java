/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavaav2.Interfaces;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import trabalhojavaav2.Arquivos.ArquivoItensVenda;
import trabalhojavaav2.Arquivos.ArquivoProdutos;
import trabalhojavaav2.Classes.ItemVenda;
import trabalhojavaav2.Classes.Produto;
import trabalhojavaav2.Classes.Venda;
import trabalhojavaav2.ModelosTabela.ModeloTabelaItemVenda;
import trabalhojavaav2.OperacaoCadastro;

/**
 *
 * @author vitor
 */
public class MenuItemVenda extends javax.swing.JDialog {

    private Venda venda;
    private ArquivoItensVenda arquivo;
    private OperacaoCadastro operacaoCadastro;
    private ModeloTabelaItemVenda modeloItemVenda;
    
    private ArquivoProdutos arquivoProd;
    private ArrayList <Produto> produtos;
    
    public MenuItemVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public MenuItemVenda(java.awt.Frame parent, boolean modal, OperacaoCadastro operacaoCadastro, Venda venda) {
        super(parent, true);
        initComponents();
        this.venda=venda;
        this.operacaoCadastro=operacaoCadastro;
        arquivo = new ArquivoItensVenda("ItensVenda.txt");
        modeloItemVenda = new ModeloTabelaItemVenda(new ArrayList<ItemVenda>());
        tabItemVenda.setModel(modeloItemVenda);
        abrirTxt();
        
        textCodigoVenda.setText(String.valueOf(venda.obterCodigo()));
        textData.setText(new SimpleDateFormat("dd/MM/yyyy").format(venda.obterData()));
        textCodigoCliente.setText(String.valueOf(venda.obterCodigoCliente()));
        textCodigoFormaPagamento.setText(String.valueOf(venda.obterCodigoFormaPag()));
        
        textCodigoVenda.setEnabled(false);
        textData.setEnabled(false);
        textCodigoCliente.setEnabled(false);
        textCodigoFormaPagamento.setEnabled(false);
        if (operacaoCadastro == OperacaoCadastro.ocConsultar) {
            buInserirItem.setEnabled(false);
            buAlterarItem.setEnabled(false);
            buExcluirItem.setEnabled(false);
            labelTotal.setText(String.valueOf(venda.obterPrecoTotal()));
        }
    }
    
    private void abrirTxt() {
        try {
            ArrayList <ItemVenda> itens = new ArrayList<ItemVenda>();
            itens = arquivo.abrirTxt();
            for (int i = 0; i < itens.size(); i++) {
                ItemVenda itemVenda = itens.get(i);
                if (itemVenda.obterCodigoVenda() == venda.obterCodigo()) {
                    modeloItemVenda.incluirItemVenda(itemVenda);
                }
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void abrirTotal() {
        ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();
        itens = arquivo.abrirTxt();
        float total = 0;
        for (int i = 0; i < itens.size(); i++) {
            ItemVenda itemVenda = itens.get(i);
            total += itemVenda.obterPrecoTotal();
        }
        labelTotal.setText(String.valueOf(total));
        venda.atualizarPrecoTotal(total);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabItemVenda = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        buInserirItem = new javax.swing.JButton();
        buAlterarItem = new javax.swing.JButton();
        buExcluirItem = new javax.swing.JButton();
        buSelecionarItem = new javax.swing.JButton();
        buConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textCodigoCliente = new javax.swing.JTextField();
        textCodigoFormaPagamento = new javax.swing.JTextField();
        textCodigoVenda = new javax.swing.JTextField();
        textData = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro Itens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        tabItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabItemVenda);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buInserirItem.setText("Inserir");
        buInserirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buInserirItemActionPerformed(evt);
            }
        });

        buAlterarItem.setText("Alterar");
        buAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAlterarItemActionPerformed(evt);
            }
        });

        buExcluirItem.setText("Excluir");
        buExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buExcluirItemActionPerformed(evt);
            }
        });

        buSelecionarItem.setText("Consultar");
        buSelecionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buSelecionarItemActionPerformed(evt);
            }
        });

        buConfirmar.setText("Confirmar");
        buConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setText("Código Venda:");

        jLabel3.setText("Data:");

        jLabel4.setText("Código Cliente:");

        jLabel5.setText("Total:");

        labelTotal.setText("0");
        labelTotal.setOpaque(true);

        jLabel7.setText("Codigo Forma Pag.:");

        textCodigoCliente.setOpaque(false);

        textCodigoFormaPagamento.setOpaque(false);

        textCodigoVenda.setOpaque(false);

        textData.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCodigoFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buSelecionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(buExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buAlterarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buInserirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(buInserirItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buAlterarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buExcluirItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buSelecionarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelTotal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(textCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textCodigoFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buConfirmarActionPerformed
        dispose();
    }//GEN-LAST:event_buConfirmarActionPerformed

    private void buInserirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buInserirItemActionPerformed
        ItemVenda itemVenda = new ItemVenda();
        if (MenuCadItemVenda.executar(null, OperacaoCadastro.ocIncluir, venda, itemVenda)) {
            modeloItemVenda.incluirItemVenda(itemVenda);
            arquivo.salvarEmTxt(modeloItemVenda.obterTodosItensVenda());
            abrirTotal();
        }
    }//GEN-LAST:event_buInserirItemActionPerformed

    private void buAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAlterarItemActionPerformed
        int indice = tabItemVenda.getSelectedRow();
        if (indice >= 0) {
            ItemVenda itemVenda = modeloItemVenda.obterItemVenda(indice);
            if (MenuCadItemVenda.executar(null, OperacaoCadastro.ocAlterar, venda, itemVenda)) {
                modeloItemVenda.atualizarItemVenda(indice, itemVenda);
                arquivo.salvarEmTxt(modeloItemVenda.obterTodosItensVenda());
                abrirTotal();
            }
        }
    }//GEN-LAST:event_buAlterarItemActionPerformed

    private void buExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buExcluirItemActionPerformed
        int indice = tabItemVenda.getSelectedRow();
        if (indice >= 0) {
            arquivoProd = new ArquivoProdutos("Produtos.txt");
            produtos = new ArrayList<Produto>();
            produtos=arquivoProd.abrirTxt();
            ItemVenda itemVenda = modeloItemVenda.obterItemVenda(indice);
            for (int i = 0; i < produtos.size(); i++) {
                if (itemVenda.obterCodigoProduto() == produtos.get(i).obterCodigo()) {
                    produtos.get(i).atualizarEstoque(produtos.get(i).obterEstoque() + itemVenda.obterQuantidade());
                    arquivoProd.salvarEmTxt(produtos);
                    break;
                }
            }
            
            modeloItemVenda.excluirItemVenda(indice);
            arquivo.salvarEmTxt(modeloItemVenda.obterTodosItensVenda());
            abrirTotal();
        }
    }//GEN-LAST:event_buExcluirItemActionPerformed

    private void buSelecionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buSelecionarItemActionPerformed
        int indice = tabItemVenda.getSelectedRow();
        if (indice >= 0) {
            
            ItemVenda itemVenda = modeloItemVenda.obterItemVenda(indice);
            MenuCadItemVenda.executar(null, OperacaoCadastro.ocConsultar, venda, itemVenda);
            abrirTotal();
        }
    }//GEN-LAST:event_buSelecionarItemActionPerformed

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
            java.util.logging.Logger.getLogger(MenuItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuItemVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuItemVenda dialog = new MenuItemVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buAlterarItem;
    private javax.swing.JButton buConfirmar;
    private javax.swing.JButton buExcluirItem;
    private javax.swing.JButton buInserirItem;
    private javax.swing.JButton buSelecionarItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tabItemVenda;
    private javax.swing.JTextField textCodigoCliente;
    private javax.swing.JTextField textCodigoFormaPagamento;
    private javax.swing.JTextField textCodigoVenda;
    private javax.swing.JTextField textData;
    // End of variables declaration//GEN-END:variables
}
