package trabalhojavaav2.ModelosTabela;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import trabalhojavaav2.Classes.Venda;

public class ModeloTabelaVenda extends AbstractTableModel{
    private static final int COLUNA_CODIGO=0;
    private static final int COLUNA_DATA=1;
    private static final int COLUNA_CODIGO_CLIENTE=2;
    private static final int COLUNA_PRECO_TOTAL=3;
    private static final int COLUNA_CODIGO_FORMA_PAG=4;
    
    private String[] colunas = new String[] {"Codigo", "Data", "Codigo Cliente", "Preco Total", "Codigo Forma Pag."};
    private ArrayList <Venda> vendas;
    
    public ModeloTabelaVenda(ArrayList <Venda> vendas) {
        this.vendas=vendas;
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return vendas.size();
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
        Venda venda = vendas.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                return venda.obterCodigo();
            case COLUNA_DATA:
                return venda.obterData();
            case COLUNA_CODIGO_CLIENTE:
                return venda.obterCodigoCliente();
            case COLUNA_PRECO_TOTAL:
                return venda.obterPrecoTotal();
            case COLUNA_CODIGO_FORMA_PAG:
                return venda.obterCodigoFormaPag();
        }
        return "";
    }
    
    @Override 
    public void setValueAt(Object aValue, int row, int column) {
        Venda venda = vendas.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                venda.atualizarCodigo(Integer.parseInt(aValue.toString()));
            case COLUNA_DATA:
                try {
                    String dataSemFormat=aValue.toString();  
                    Date data=new SimpleDateFormat("dd/MM/yyyy").parse(dataSemFormat);  
                    venda.atualizarData(data);
                } catch(ParseException e) {}
            case COLUNA_CODIGO_CLIENTE:
                venda.atualizarCodigoCliente(Integer.parseInt(aValue.toString()));
            case COLUNA_PRECO_TOTAL:
                venda.atualizarPrecoTotal(Float.parseFloat(aValue.toString()));
            case COLUNA_CODIGO_FORMA_PAG:
                venda.atualizarCodigoFormaPag(Integer.parseInt(aValue.toString()));
        }
    }
    
    public Venda obterVenda(int indice) {
        return vendas.get(indice);
    }
    
    public void incluirVenda(Venda venda) {
        vendas.add(venda);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void atualizarVenda(int indice, Venda venda) {
        vendas.set(indice, venda);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void excluirVenda(int indice) {
        vendas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public ArrayList<Venda> obterTodasVendas() {
        return vendas;
    }
}
