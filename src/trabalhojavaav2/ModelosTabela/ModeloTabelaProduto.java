package trabalhojavaav2.ModelosTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalhojavaav2.Classes.Produto;

public class ModeloTabelaProduto extends AbstractTableModel{
    private static final int COLUNA_CODIGO=0;
    private static final int COLUNA_NOME=1;
    private static final int COLUNA_PRECO=2;
    private static final int COLUNA_ESTOQUE=3;
    
    private String[] colunas = new String[] {"Codigo", "Nome", "Preco", "Estoque"};
    private ArrayList <Produto> produtos;
    
    public ModeloTabelaProduto(ArrayList <Produto> produtos) {
        this.produtos=produtos;
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return produtos.size();
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
        Produto produto = produtos.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                return produto.obterCodigo();
            case COLUNA_NOME:
                return produto.obterNome();
            case COLUNA_PRECO:
                return produto.obterPreco();
            case COLUNA_ESTOQUE:
                return produto.obterEstoque();
        }
        return "";
    }
    
    @Override 
    public void setValueAt(Object aValue, int row, int column) {
        Produto produto = produtos.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                produto.atualizarCodigo(Integer.parseInt(aValue.toString()));
            case COLUNA_NOME:
                produto.atualizarNome(aValue.toString());
            case COLUNA_PRECO:
                produto.atualizarPreco(Float.parseFloat(aValue.toString()));
            case COLUNA_ESTOQUE:
                produto.atualizarEstoque(Integer.parseInt(aValue.toString()));
        }
    }
    
    public Produto obterProduto(int indice) {
        return produtos.get(indice);
    }
    
    public void incluirProduto(Produto produto) {
        produtos.add(produto);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void atualizarProduto(int indice, Produto produto) {
        produtos.set(indice, produto);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void excluirProduto(int indice) {
        produtos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public ArrayList<Produto> obterTodosProdutos() {
        return produtos;
    }
}
