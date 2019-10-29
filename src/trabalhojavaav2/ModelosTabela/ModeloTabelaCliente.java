package trabalhojavaav2.ModelosTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalhojavaav2.Classes.Cliente;

public class ModeloTabelaCliente extends AbstractTableModel{
    private static final int COLUNA_CODIGO=0;
    private static final int COLUNA_NOME=1;
    private static final int COLUNA_CPF=2;
    private static final int COLUNA_ESTADO=3;
    private static final int COLUNA_CIDADE=4;
    private static final int COLUNA_BAIRRO=5;
    private static final int COLUNA_RUA=6;
    private static final int COLUNA_COMPLEMENTO=7;
    private static final int COLUNA_TELEFONE=8;
    private static final int COLUNA_EMAIL=9;
    
    private String[] colunas = new String[] {"Codigo", "Nome", "CPF", "Estado", "Cidade", "Bairro", "Rua", 
                                             "Complemento", "Telefone", "Email"};
    private ArrayList <Cliente> clientes;
    
    public ModeloTabelaCliente(ArrayList <Cliente> clientes) {
        this.clientes=clientes;
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Cliente cliente = clientes.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                return cliente.obterCodigo();
            case COLUNA_NOME:
                return cliente.obterNome();
            case COLUNA_CPF:
                return cliente.obterCpf();
            case COLUNA_ESTADO:
                return cliente.obterEstado();
            case COLUNA_CIDADE:
                return cliente.obterCidade();
            case COLUNA_BAIRRO:
                return cliente.obterBairro();
            case COLUNA_RUA:
                return cliente.obterRua();
            case COLUNA_COMPLEMENTO:
                return cliente.obterComplemento();
            case COLUNA_TELEFONE:
                return cliente.obterTelefone();
            case COLUNA_EMAIL:
                return cliente.obterEmail();
        }
        return "";
    }
    /*
    private int codigo;
    private String nome;
    private String cpf;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;
    private String telefone;
    private String email;
    */
    
    @Override 
    public void setValueAt(Object aValue, int row, int column) {
        Cliente cliente = clientes.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                cliente.atualizarCodigo(Integer.parseInt(aValue.toString()));
            case COLUNA_NOME:
                cliente.atualizarNome(aValue.toString());
            case COLUNA_CPF:
                cliente.atualizarCpf(aValue.toString());
            case COLUNA_ESTADO:
                cliente.atualizarEstado(aValue.toString());
            case COLUNA_CIDADE:
                cliente.atualizarCidade(aValue.toString());
            case COLUNA_BAIRRO:
                cliente.atualizarBairro(aValue.toString());
            case COLUNA_RUA:
                cliente.atualizarRua(aValue.toString());
            case COLUNA_COMPLEMENTO:
                cliente.atualizarComplemento(aValue.toString());
            case COLUNA_TELEFONE:
                cliente.atualizarTelefone(aValue.toString());
            case COLUNA_EMAIL:
                cliente.atualizarEmail(aValue.toString());
        }
    }
    
    public Cliente obterCliente(int indice) {
        return clientes.get(indice);
    }
    
    public void incluirCliente(Cliente cliente) {
        clientes.add(cliente);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void atualizarCliente(int indice, Cliente cliente) {
        clientes.set(indice, cliente);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void excluirCliente(int indice) {
        clientes.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    /*
    public ArrayList<Cliente> obterTodosClientes() {
        return clientes;
    }
    */
}
