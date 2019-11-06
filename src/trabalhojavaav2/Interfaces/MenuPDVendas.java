/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavaav2.Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import trabalhojavaav2.BancoDeDados.ClienteBD;
import trabalhojavaav2.BancoDeDados.FormaPagamentoBD;
import trabalhojavaav2.BancoDeDados.ItemVendaBD;
import trabalhojavaav2.Classes.Cliente;
import trabalhojavaav2.Classes.FormaPagamento;
import trabalhojavaav2.Classes.ItemVenda;
import trabalhojavaav2.Classes.Produto;
import trabalhojavaav2.ModelosTabela.ModeloTabelaItemVenda;
import trabalhojavaav2.OperacaoCadastro;

/**
 *
 * @author vitor
 */
public class MenuPDVendas extends javax.swing.JFrame {

    private Cliente cliente;
    private Cliente clienteDefault;
    private Produto produto;
    private FormaPagamento formaPagamento;
    
    private ModeloTabelaItemVenda modeloItemVenda;
    private DefaultComboBoxModel modeloCBFormaPag;
    private DefaultComboBoxModel modeloConsulta;
    
    private ItemVendaBD itemVendaBD;
    private ClienteBD clienteBD;
    private FormaPagamentoBD formaPagamentoBD;
    
    public MenuPDVendas() {
        initComponents();
        
        atualizacaoConstanteDataHora();
        
        cliente = new Cliente();
        produto = new Produto();
        formaPagamento = new FormaPagamento();
        modeloItemVenda = new ModeloTabelaItemVenda(new ArrayList <ItemVenda>());
        modeloCBFormaPag = new DefaultComboBoxModel();
        modeloConsulta = new DefaultComboBoxModel();
        itemVendaBD = new ItemVendaBD();
        clienteBD = new ClienteBD();
        formaPagamentoBD = new FormaPagamentoBD();
        
        ArrayList <Cliente> clientes = clienteBD.buscarClientesPorEspecificacao("CODIGO_CLIENTE", "1");
        cliente = clienteDefault = clientes.get(0);
        
        tabItemVenda.setModel(modeloItemVenda);
        cbFormasPagamento.setModel(modeloCBFormaPag);
        cbBuscar.setModel(modeloConsulta);
        
        preencherModeloFormasPag();
        preencherModeloConsulta();
        
        btConfirmar.setEnabled(false);
        defaultBotoes();
    }
    
    private void atualizacaoConstanteDataHora() {
        Date data=new Date();
        SimpleDateFormat formatador= new SimpleDateFormat("dd/MM/yyyy");
        lbDataAtual.setText(formatador.format(data));
    
        Timer timer= new Timer(1000,new hora());
        timer.start();  
    }
    
    class hora implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Calendar now= Calendar.getInstance();
            lbHoraAtual.setText(String.format("%1$tH:%1$tM:%1$tS",now));
        }
    }
    
    /*
    private void atualizarModelo() {
        try {
            limparModelo();
            ArrayList <ItemVenda> itens = new ArrayList<ItemVenda>() ;
            itens = clienteBD.lerClientes();
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                modeloCliente.incluirCliente(cliente);
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void atualizarModelo(ArrayList <Cliente> clientes) {
        try {
            limparModelo();
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                modeloCliente.incluirCliente(cliente);
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
    */
    
    private void preencherModeloFormasPag() {
        modeloCBFormaPag.removeAllElements();
        FormaPagamentoBD formaPagamentoBD = new FormaPagamentoBD();
        ArrayList <FormaPagamento> formasPagamento = new ArrayList <FormaPagamento>();
        formasPagamento = formaPagamentoBD.lerFormasPagamento();
        for (int i = 0; i < formasPagamento.size(); i++) {
            modeloCBFormaPag.addElement(formasPagamento.get(i).obterNome());
        }
    }
    
    private void preencherModeloConsulta() {
        modeloConsulta.addElement("Codigo Produto");
        modeloConsulta.addElement("Nome Produto");
    }
    
    private ArrayList <ItemVenda> consultarItensVenda() {
        ArrayList <ItemVenda> itens = new ArrayList <ItemVenda>();
        String dado = textBuscar.getText().toUpperCase();
        if (!dado.equals("")) {
            itens = itemVendaBD.buscarItensVendaPorEspecificacao(dado);
            if (itens != null) {
                return itens;
            } else {
                JOptionPane.showMessageDialog(this, "Item nao encontrado!");
            }
        } else {
            atualizarModelo();
        }
        return null;
    }
    
    private void limparModelo() {
        for (int i = modeloItemVenda.getRowCount()-1; i >= 0; i--) {
            modeloItemVenda.excluirItemVenda(i);
        }
    }
    
    private void defaultBotoes() {
        btInserirItem.setEnabled(false);
        btFinalizarCompra.setEnabled(false);
        btCancelarCompra.setEnabled(false);
        btIniciarVenda.setEnabled(true);
        btSelecionarCliente.setEnabled(true);
        cbFormasPagamento.setEnabled(true);
    }
            
    private void iniciarBotoesVenda() {
        btInserirItem.setEnabled(true);
        btFinalizarCompra.setEnabled(true);
        btCancelarCompra.setEnabled(true);
        btIniciarVenda.setEnabled(false);
        btSelecionarCliente.setEnabled(false);
        cbFormasPagamento.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabItemVenda = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        cbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        textBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        btFinalizarCompra = new javax.swing.JButton();
        btSelecionarCliente = new javax.swing.JButton();
        cbFormasPagamento = new javax.swing.JComboBox<>();
        btEncerrar = new javax.swing.JButton();
        btCancelarCompra = new javax.swing.JButton();
        btInserirItem = new javax.swing.JButton();
        btIniciarVenda = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbOperador = new javax.swing.JLabel();
        lbDataAtual = new javax.swing.JLabel();
        lbHoraAtual = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        btClientes = new javax.swing.JButton();
        btProdutos = new javax.swing.JButton();
        btFormasPagamento = new javax.swing.JButton();
        btHistoricoVendas = new javax.swing.JButton();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbTotalVenda = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textPrecoUnit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textQuantidade = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vendas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jScrollPane1.setViewportView(tabItemVenda);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Buscar Por:");

        cbBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Quantidade Vendas:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("0");

        btBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        textBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Buscar:");

        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btBuscar))
                .addGap(23, 23, 23))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(cbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Bem Vindo!");

        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btFinalizarCompra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btFinalizarCompra.setText("Finalizar Compra");
        btFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarCompraActionPerformed(evt);
            }
        });

        btSelecionarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSelecionarCliente.setText("Selecionar Cliente");
        btSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarClienteActionPerformed(evt);
            }
        });

        cbFormasPagamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btEncerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEncerrar.setText("Encerrar");
        btEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEncerrarActionPerformed(evt);
            }
        });

        btCancelarCompra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancelarCompra.setText("Cancelar Compra");
        btCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarCompraActionPerformed(evt);
            }
        });

        btInserirItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btInserirItem.setText("Inserir Item");
        btInserirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirItemActionPerformed(evt);
            }
        });

        btIniciarVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btIniciarVenda.setText("Iniciar Venda");
        btIniciarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarVendaActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(btFinalizarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btSelecionarCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(cbFormasPagamento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btEncerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btCancelarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btInserirItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btIniciarVenda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEncerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btInserirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSelecionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFormasPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btFinalizarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCancelarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(btIniciarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btIniciarVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btInserirItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFinalizarCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelarCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSelecionarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFormasPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEncerrar)
                .addContainerGap())
        );

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Operador");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Data Atual");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hora Atual");

        lbOperador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbOperador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOperador.setText("Caixa 1");
        lbOperador.setToolTipText("");
        lbOperador.setPreferredSize(new java.awt.Dimension(66, 22));

        lbDataAtual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbDataAtual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDataAtual.setPreferredSize(new java.awt.Dimension(66, 22));

        lbHoraAtual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHoraAtual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHoraAtual.setPreferredSize(new java.awt.Dimension(66, 22));

        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(lbOperador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(lbDataAtual, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(lbHoraAtual, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDataAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHoraAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(lbDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(lbHoraAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btClientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btClientes.setText("Clientes");
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });

        btProdutos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btProdutos.setText("Produtos");
        btProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutosActionPerformed(evt);
            }
        });

        btFormasPagamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btFormasPagamento.setText("Formas Pagamento");
        btFormasPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFormasPagamentoActionPerformed(evt);
            }
        });

        btHistoricoVendas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btHistoricoVendas.setText("Histórico Vendas");

        jLayeredPane5.setLayer(btClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btProdutos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btFormasPagamento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btHistoricoVendas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(btClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btFormasPagamento))
                    .addComponent(btHistoricoVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFormasPagamento)
                    .addComponent(btClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btProdutos)
                    .addComponent(btHistoricoVendas))
                .addGap(22, 22, 22))
        );

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL VENDA CAIXA");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setText("R$");

        lbTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbTotalVenda.setPreferredSize(new java.awt.Dimension(134, 60));

        jLayeredPane6.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(lbTotalVenda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Produto:");
        jLabel9.setToolTipText("");

        textProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textProduto.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Preço Unit.:");

        textPrecoUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textPrecoUnit.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Quantidade:");

        textQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jLayeredPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLayeredPane6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(2, 2, 2)
                        .addComponent(textPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btConfirmar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane4)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(textProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(textPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btConfirmar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        MenuClientes menuClientes = new MenuClientes(null, true);
        menuClientes.setLocationRelativeTo(this);
        menuClientes.setVisible(true);
    }//GEN-LAST:event_btClientesActionPerformed

    private void btProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutosActionPerformed
        MenuProdutos menuProdutos = new MenuProdutos(null, true);
        menuProdutos.setLocationRelativeTo(this);
        menuProdutos.setVisible(true);
    }//GEN-LAST:event_btProdutosActionPerformed

    private void btFormasPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFormasPagamentoActionPerformed
        MenuFormasPag menuFormasPag = new MenuFormasPag(null, true);
        menuFormasPag.setLocationRelativeTo(this);
        menuFormasPag.setVisible(true);
        preencherModeloFormasPag();
    }//GEN-LAST:event_btFormasPagamentoActionPerformed

    private void btEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEncerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btEncerrarActionPerformed

    private void btInserirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirItemActionPerformed
        if (MenuProdutos.executar(null, OperacaoCadastro.ocSelecionar, produto)) {
            textProduto.setText(produto.obterNome());
            textPrecoUnit.setText(String.valueOf(produto.obterPreco()));
            textQuantidade.setText("1");
            btConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_btInserirItemActionPerformed

    private void btFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarCompraActionPerformed
        ArrayList <ItemVenda> itens = new ArrayList <ItemVenda>();
        itens = modeloItemVenda.obterTodosItensVenda();
        if (itens.size() > 0) {
            int opcao = JOptionPane.showConfirmDialog(this, "Confirmar finalização de compra:", "Confirmação", 
                                                      JOptionPane.YES_NO_OPTION);
            if (opcao == 0) {
                for (int i = 0; i < itens.size(); i++) {
                ItemVenda item = itens.get(i);
                itemVendaBD.inserirItemVenda(item);
                } 
                limparModelo();
                cliente = clienteDefault;
                defaultBotoes();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Necessário a inserção de produtos!");
        }
    }//GEN-LAST:event_btFinalizarCompraActionPerformed

    private void btCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarCompraActionPerformed
        limparModelo();
        cliente = clienteDefault;
        defaultBotoes();
    }//GEN-LAST:event_btCancelarCompraActionPerformed

    private void btSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarClienteActionPerformed
        MenuClientes.executar(null, OperacaoCadastro.ocSelecionar, cliente);
    }//GEN-LAST:event_btSelecionarClienteActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (Integer.parseInt(textQuantidade.getText()) <= produto.obterEstoque()) {
            ItemVenda item = new ItemVenda();
            item.atualizarCodigoVenda(1);
            item.atualizarCodigoProduto(produto.obterCodigo());
            item.atualizarNomeProduto(produto.obterNome());
            item.atualizarQuantidade(Integer.parseInt(textQuantidade.getText()));
            item.atualizarPrecoUnit(produto.obterPreco());
            item.atualizarPrecoTotal(Integer.parseInt(textQuantidade.getText()) * produto.obterPreco());
            
            modeloItemVenda.incluirItemVenda(item);
            
            textProduto.setText("");
            textPrecoUnit.setText("");
            textQuantidade.setText("");
            btConfirmar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Quantidade disponivel em estoque: "+produto.obterEstoque());
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarVendaActionPerformed
        iniciarBotoesVenda();
        
        String nomeFormaPag = cbFormasPagamento.getItemAt(cbFormasPagamento.getSelectedIndex());
        formaPagamento = formaPagamentoBD.buscarItensVendaPorEspecificacao("NOME", nomeFormaPag);
    }//GEN-LAST:event_btIniciarVendaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPDVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPDVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPDVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPDVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPDVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelarCompra;
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btEncerrar;
    private javax.swing.JButton btFinalizarCompra;
    private javax.swing.JButton btFormasPagamento;
    private javax.swing.JButton btHistoricoVendas;
    private javax.swing.JButton btIniciarVenda;
    private javax.swing.JButton btInserirItem;
    private javax.swing.JButton btProdutos;
    private javax.swing.JButton btSelecionarCliente;
    private javax.swing.JComboBox<String> cbBuscar;
    private javax.swing.JComboBox<String> cbFormasPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDataAtual;
    private javax.swing.JLabel lbHoraAtual;
    private javax.swing.JLabel lbOperador;
    private javax.swing.JLabel lbTotalVenda;
    private javax.swing.JTable tabItemVenda;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textPrecoUnit;
    private javax.swing.JTextField textProduto;
    private javax.swing.JTextField textQuantidade;
    // End of variables declaration//GEN-END:variables
}
