package trabalhojavaav2.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import trabalhojavaav2.Classes.Venda;
import trabalhojavaav2.SingletonConexao;

/**
 *
 * @author vitor
 */
public class VendaBD {
    
    public boolean inserirVenda(Venda venda) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        boolean inseriu = false;
        if (conexao != null) {
           try {
               String sql = "insert into venda(DATA, CODIGO_CLIENTE, PRECO_TOTAL, CODIGO_FORMA_PAG) "
                       + "               values(NOW(), ?, ?, ?);";
               
               stmt = conexao.prepareStatement(sql);
               
               stmt.setInt(2, venda.obterCodigoCliente());
               stmt.setFloat(3, venda.obterPrecoTotal());
               stmt.setInt(4, venda.obterCodigoFormaPag());
               
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
