package trabalhojavaav2.ModelosTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalhojavaav2.Classes.FormaPagamento;

/**
 *
 * @author vitor
 */
public class ModeloTabelaFormaPag extends AbstractTableModel{
    private static final int COLUNA_CODIGO=0;
    private static final int COLUNA_NOME=1;
    
    private String[] colunas = new String[] {"Codigo", "Nome"};
    private ArrayList <FormaPagamento> formasPag;
    
    public ModeloTabelaFormaPag(ArrayList <FormaPagamento> formasPag) {
        this.formasPag=formasPag;
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return formasPag.size();
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
        FormaPagamento formaPag = formasPag.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                return formaPag.obterCodigo();
            case COLUNA_NOME:
                return formaPag.obterNome();
        }
        return "";
    }
    
    @Override 
    public void setValueAt(Object aValue, int row, int column) {
        FormaPagamento formaPag = formasPag.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                formaPag.atualizarCodigo(Integer.parseInt(aValue.toString()));
            case COLUNA_NOME:
                formaPag.atualizarNome(aValue.toString());
        }
    }
    
    public FormaPagamento obterFormaPagamento(int indice) {
        return formasPag.get(indice);
    }
    
    public void incluirFormaPagamento(FormaPagamento formaPag) {
        formasPag.add(formaPag);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void atualizarFormaPagamento(int indice, FormaPagamento formaPag) {
        formasPag.set(indice, formaPag);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void excluirFormaPagamento(int indice) {
        formasPag.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public ArrayList<FormaPagamento> obterTodasFormasPagamento() {
        return formasPag;
    }
}
