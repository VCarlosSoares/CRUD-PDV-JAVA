package trabalhojavaav2.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import trabalhojavaav2.Classes.ItemVenda;
import trabalhojavaav2.SingletonConexao;

/**
 *
 * @author vitor
 */
public class ItemVendaBD {
    
    /*
    private void obterUltimoCodigo() {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select CODIGO_CLIENTE from cliente "
                        + "   where CODIGO_CLIENTE = (select max(CODIGO_CLIENTE) from cliente);";

                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    codigo = rs.getInt("CODIGO_CLIENTE");
                }
            
                conexao.commit();
            
            } catch (SQLException e) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) { }
            } finally {
                SingletonConexao.getInstance().fecharConexao(conexao, stmt, rs);
            }
        }
    }
    */
    
    private void prepararComandoAtualizacao(PreparedStatement stmt, ItemVenda item) throws SQLException{
        stmt.setInt   (1, item.obterCodigoVenda());
        stmt.setInt   (2, item.obterCodigoProduto());
        stmt.setString(3, item.obterNomeProduto());
        stmt.setInt   (4, item.obterQuantidade());
        stmt.setFloat (5, item.obterPrecoUnit());
        stmt.setFloat (6, item.obterPrecoTotal());
    }
    
    private ItemVenda retornarItemVenda(ResultSet rs) throws SQLException{
        ItemVenda item = new ItemVenda();
        item.atualizarCodigoVenda(rs.getInt("CODIGO_VENDA"));
        item.atualizarCodigoProduto(rs.getInt("CODIGO_PRODUTO"));
        item.atualizarNomeProduto(rs.getString("NOME_PRODUTO"));
        item.atualizarQuantidade(rs.getInt("QUANTIDADE"));
        item.atualizarPrecoUnit(rs.getFloat("PRECO_UNIT"));
        item.atualizarPrecoTotal(rs.getFloat("PRECO_TOTAL"));
        
        return item;
    }

    public void inserirItemVenda(ItemVenda item) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "insert into item_venda(CODIGO_VENDA, CODIGO_PRODUTO, NOME_PRODUTO, "
                       + "                          QUANTIDADE, PRECO_UNIT, PRECO_TOTAL)"
                       + "                   values(?, ?, ?, ?, ?, ?);";
               
               stmt = conexao.prepareStatement(sql);
               prepararComandoAtualizacao(stmt, item);
               
               stmt.execute();
               
               conexao.commit();
               
           } catch (SQLException e) {
               try {
                   conexao.rollback();
               } catch (SQLException ex) { }
           } finally {
               SingletonConexao.getInstance().fecharConexao(conexao, stmt);
           }
        }
    }
    
    public void excluirItemVenda(ItemVenda item) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
            try {
                String sql = "delete from item_venda where CODIGO_VENDA="+item.obterCodigoVenda()+";";
                
                stmt = conexao.prepareStatement(sql);
                
                stmt.execute();
                
                conexao.commit();
                
            } catch (SQLException e) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) {
                }
            } finally {
                SingletonConexao.getInstance().fecharConexao(conexao, stmt);
            }
        }
    }
    
    public ArrayList <ItemVenda> lerItensVenda(ItemVenda item) {
        ArrayList <ItemVenda> itens = new ArrayList <ItemVenda>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select * from item_venda where CODIGO_VENDA="+item.obterCodigoVenda()+";"; 
                        
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    itens.add(retornarItemVenda(rs));
                }
                
                conexao.commit();
                
            } catch (SQLException e) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) { }
            } finally {
                SingletonConexao.getInstance().fecharConexao(conexao, stmt, rs);
            }
        }
        return itens;
    }
    
    public ArrayList <ItemVenda> buscarItensVendaPorEspecificacao(String coluna, String dado) {
        ArrayList <ItemVenda> itens = new ArrayList <ItemVenda>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql;
                if (coluna.equals("CODIGO_CLIENTE")) {
                    sql = "select * from item_venda where "+coluna+" = "+Integer.parseInt(dado)+";";
                } else {
                    sql = "select * from item_venda where "+coluna+" like '%"+dado+"%';";
                }
                
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    itens.add(retornarItemVenda(rs));
                }
                
                conexao.commit();
                
            } catch (SQLException e) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) { }
            } finally {
                SingletonConexao.getInstance().fecharConexao(conexao, stmt, rs);
            }
        }
        if (itens.size() > 0) {
            return itens;
        } else {
            return null;
        }
    }
}
