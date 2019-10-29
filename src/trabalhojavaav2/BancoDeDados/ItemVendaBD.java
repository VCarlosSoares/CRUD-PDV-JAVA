package trabalhojavaav2.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import trabalhojavaav2.Classes.ItemVenda;
import trabalhojavaav2.SingletonConexao;

/**
 *
 * @author vitor
 */
public class ItemVendaBD {
    
    public boolean inserirItemVenda(ItemVenda item) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        boolean inseriu = false;
        if (conexao != null) {
           try {
               String sql = "insert into item_venda(CODIGO_VENDA, CODIGO_PRODUTO, QUANTIDADE, PRECO_UNIT, PRECO_TOTAL) "
                       + "               values(?, ?, ?, ?, ?);";
               
               stmt = conexao.prepareStatement(sql);
               
               stmt.setInt(1, item.obterCodigoVenda());
               stmt.setInt(2, item.obterCodigoProduto());
               stmt.setInt(3, item.obterQuantidade());
               stmt.setFloat(4, item.obterPrecoUnit());
               stmt.setFloat(5, item.obterPrecoTotal());
               
               if (stmt.execute()) {
                    inseriu = true;
               }
               
           } catch (SQLException e) {
           } finally {
               SingletonConexao.getInstance().fecharConexao(conexao, stmt);
           }
        }
        return inseriu;
    }
}
