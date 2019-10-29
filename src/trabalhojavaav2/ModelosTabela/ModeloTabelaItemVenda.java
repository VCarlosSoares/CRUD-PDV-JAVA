package trabalhojavaav2.ModelosTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalhojavaav2.Classes.ItemVenda;

public class ModeloTabelaItemVenda extends AbstractTableModel{
    private static final int COLUNA_CODIGO_VENDA=0;
    private static final int COLUNA_CODIGO_PRODUTO=1;
    private static final int COLUNA_QUANTIDADE=2;
    private static final int COLUNA_PRECO_UNIT=3;
    private static final int COLUNA_PRECO_TOTAL=4;
    
    private String[] colunas = new String[] {"Cod. Venda", "Cod. Produto", "Quantidade", "Preco Unit.", "Preco Tot."};
    private ArrayList <ItemVenda> itens;
    
    public ModeloTabelaItemVenda(ArrayList <ItemVenda> itens) {
        this.itens=itens;
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return itens.size();
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
        ItemVenda itemVenda = itens.get(row);
        switch (column) {
            case COLUNA_CODIGO_VENDA:
                return itemVenda.obterCodigoVenda();
            case COLUNA_CODIGO_PRODUTO:
                return itemVenda.obterCodigoProduto();
            case COLUNA_QUANTIDADE:
                return itemVenda.obterQuantidade();
            case COLUNA_PRECO_UNIT:
                return itemVenda.obterPrecoUnit();
            case COLUNA_PRECO_TOTAL:
                return itemVenda.obterPrecoTotal();
        }
        return "";
    }
    
    @Override 
    public void setValueAt(Object aValue, int row, int column) {
        ItemVenda itemVenda = itens.get(row);
        switch (column) {
            case COLUNA_CODIGO_VENDA:
                itemVenda.atualizarCodigoVenda(Integer.parseInt(aValue.toString()));
            case COLUNA_CODIGO_PRODUTO:
                itemVenda.atualizarCodigoProduto(Integer.parseInt(aValue.toString()));
            case COLUNA_QUANTIDADE:
                itemVenda.atualizarQuantidade(Integer.parseInt(aValue.toString()));
            case COLUNA_PRECO_UNIT:
                itemVenda.atualizarPrecoUnit(Float.parseFloat(aValue.toString()));
            case COLUNA_PRECO_TOTAL:
                itemVenda.atualizarPrecoTotal(Float.parseFloat(aValue.toString()));
        }
    }
    
    public ItemVenda obterItemVenda(int indice) {
        return itens.get(indice);
    }
    
    public void incluirItemVenda(ItemVenda itemVenda) {
        itens.add(itemVenda);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void atualizarItemVenda(int indice, ItemVenda itemVenda) {
        itens.set(indice, itemVenda);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void excluirItemVenda(int indice) {
        itens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public ArrayList<ItemVenda> obterTodosItensVenda() {
        return itens;
    }
}
