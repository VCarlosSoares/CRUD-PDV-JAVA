package trabalhojavaav2.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalhojavaav2.Classes.FormaPagamento;
import trabalhojavaav2.SingletonConexao;

/**
 *
 * @author vitor
 */
public class FormaPagamentoBD {
    
    private int codigo;
    
    public FormaPagamentoBD() {
        obterUltimoCodigo();
    }
    
    private void obterUltimoCodigo() {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select CODIGO_FORMA_PAG from forma_pagamento "
                        + "   where CODIGO_FORMA_PAG = (select max(CODIGO_FORMA_PAG) from forma_pagamento);";

                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    codigo = rs.getInt("CODIGO_FORMA_PAG");
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
    
    
    private void prepararComandoAtualizacao(PreparedStatement stmt, FormaPagamento formaPag) throws SQLException{
        stmt.setString(1, formaPag.obterNome());
    }
    
    private FormaPagamento retornarFormaPagamento(ResultSet rs) throws SQLException{
        FormaPagamento formaPag = new FormaPagamento();
        formaPag.atualizarCodigo(rs.getInt("CODIGO_FORMA_PAG"));
        formaPag.atualizarNome(rs.getString("NOME"));
        return formaPag;
    }
    
    public FormaPagamento inserirFormaPagamento(FormaPagamento formaPag) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "insert into forma_pagamento(NOME) "
                       + "               values(?);";
               
               stmt = conexao.prepareStatement(sql);
               
               prepararComandoAtualizacao(stmt, formaPag);
               
               stmt.execute();
               
               conexao.commit();
               
               formaPag.atualizarCodigo(++codigo);
               
           } catch (SQLException e) {
               try {
                   conexao.rollback();
               } catch (SQLException ex) { }
           } finally {
               SingletonConexao.getInstance().fecharConexao(conexao, stmt);
           }
        }
        return formaPag;
    }
    
    public void alterarFormaPagamento(FormaPagamento formaPag) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "update forma_pagamento set NOME=?"
                       + "   where CODIGO_FORMA_PAG="+formaPag.obterCodigo()+";";
               
               stmt = conexao.prepareStatement(sql);
               
               prepararComandoAtualizacao(stmt, formaPag);
               
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
    
    public void excluirFormaPag(FormaPagamento formaPag) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
            try {
                String sql = "delete from forma_pagamento where CODIGO_FORMA_PAG="+formaPag.obterCodigo()+";";
                
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
    
    public ArrayList <FormaPagamento> lerFormasPagamento() {
        ArrayList <FormaPagamento> formasPag = new ArrayList <FormaPagamento>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select * from forma_pagamento;"; 
                        
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    formasPag.add(retornarFormaPagamento(rs));
                }
                
                conexao.commit();
                
                return formasPag;
                
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
    
}
