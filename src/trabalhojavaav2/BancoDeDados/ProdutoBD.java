package trabalhojavaav2.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalhojavaav2.Classes.Produto;
import trabalhojavaav2.SingletonConexao;

/**
 *
 * @author vitor
 */
public class ProdutoBD {
    
    private int codigo;
    
    public ProdutoBD() {
        obterUltimoCodigo();
    }
    
    private void obterUltimoCodigo() {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select CODIGO_PRODUTO from produto "
                        + "   where CODIGO_PRODUTO = (select max(CODIGO_PRODUTO) from produto);";

                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    codigo = rs.getInt("CODIGO_PRODUTO");
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
    
    
    private void prepararComandoAtualizacao(PreparedStatement stmt, Produto produto) throws SQLException{
        stmt.setString(1, produto.obterNome());
        stmt.setFloat(2, produto.obterPreco());
        stmt.setInt(3, produto.obterEstoque());
    }
    
    private Produto retornarProduto(ResultSet rs) throws SQLException{
        Produto produto = new Produto();
        produto.atualizarCodigo(rs.getInt("CODIGO_PRODUTO"));
        produto.atualizarNome(rs.getString("NOME"));
        produto.atualizarPreco(rs.getFloat("PRECO"));
        produto.atualizarEstoque(rs.getInt("ESTOQUE"));
        return produto;
    }
    
    public Produto inserirProduto(Produto produto) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "insert into produto(NOME, PRECO, ESTOQUE) "
                       + "               values(?, ?, ?);";
               
               stmt = conexao.prepareStatement(sql);
               prepararComandoAtualizacao(stmt, produto);
               
               stmt.execute();
               
               conexao.commit();
               
               produto.atualizarCodigo(++codigo);
               
           } catch (SQLException e) {
               try {
                   conexao.rollback();
               } catch (SQLException ex) { }
           } finally {
               SingletonConexao.getInstance().fecharConexao(conexao, stmt);
           }
        }
        return produto;
    }
    
    public void alterarProduto(Produto produto) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "update produto set NOME=?, PRECO=?, ESTOQUE=?"
                       + "   where CODIGO_PRODUTO="+produto.obterCodigo()+";";
               
               stmt = conexao.prepareStatement(sql);
               prepararComandoAtualizacao(stmt, produto);
               
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
    
    public void excluirProduto(Produto produto) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
            try {
                String sql = "delete from produto where CODIGO_PRODUTO="+produto.obterCodigo()+";";
                
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
    
    public ArrayList <Produto> lerProdutos() {
        ArrayList <Produto> produtos = new ArrayList <Produto>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select * from produto;"; 
                        
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    produtos.add(retornarProduto(rs));
                }
                
                conexao.commit();
                
                return produtos;
                
            } catch (SQLException e) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) { }
            } finally {
                SingletonConexao.getInstance().fecharConexao(conexao, stmt, rs);
            }
        }
        return null;
    }
    
    public ArrayList <Produto> buscarProdutosPorEspecificacao(String coluna, String dado) {
        ArrayList <Produto> produtos = new ArrayList <Produto>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql;
                if (coluna.equals("CODIGO_PRODUTO")) {
                    sql = "select * from produto where "+coluna+" = "+Integer.parseInt(dado)+";"; 
                } else {
                    sql = "select * from produto where "+coluna+" like '%"+dado+"%';";
                }
                
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    produtos.add(retornarProduto(rs));
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
        if (produtos.size() > 0) {
            return produtos;
        } else {
            return null;
        }
    }
    
}
