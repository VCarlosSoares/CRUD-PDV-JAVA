package trabalhojavaav2.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalhojavaav2.Classes.Cliente;
import trabalhojavaav2.SingletonConexao;

/**
 *
 * @author vitor
 */

public class ClienteBD {
    private int codigo;
    
    public ClienteBD() {
        obterUltimoCodigo();
    }
    
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
    
    
    private void prepararComandoAtualizacao(PreparedStatement stmt, Cliente cliente) throws SQLException{
        stmt.setString(1, cliente.obterNome());
        stmt.setString(2, cliente.obterCpf());
        stmt.setString(3, cliente.obterEstado());
        stmt.setString(4, cliente.obterCidade());
        stmt.setString(5, cliente.obterBairro());
        stmt.setString(6, cliente.obterRua());
        stmt.setString(7, cliente.obterComplemento());
        stmt.setString(8, cliente.obterTelefone());
        stmt.setString(9, cliente.obterEmail());
    }
    
    private Cliente retornarCliente(ResultSet rs) throws SQLException{
        Cliente cliente = new Cliente();
        cliente.atualizarCodigo(rs.getInt("CODIGO_CLIENTE"));
        cliente.atualizarNome(rs.getString("NOME"));
        cliente.atualizarCpf(rs.getString("CPF"));
        cliente.atualizarEstado(rs.getString("ESTADO"));
        cliente.atualizarCidade(rs.getString("CIDADE"));
        cliente.atualizarBairro(rs.getString("BAIRRO"));
        cliente.atualizarRua(rs.getString("RUA"));
        cliente.atualizarComplemento(rs.getString("COMPLEMENTO"));
        cliente.atualizarTelefone(rs.getString("TELEFONE"));
        cliente.atualizarEmail(rs.getString("EMAIL"));
        return cliente;
    }

    public Cliente inserirCliente(Cliente cliente) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "insert into cliente(NOME, CPF, ESTADO, CIDADE, BAIRRO, RUA, "
                       + "                       COMPLEMENTO, TELEFONE, EMAIL) "
                       + "               values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
               
               stmt = conexao.prepareStatement(sql);
               prepararComandoAtualizacao(stmt, cliente);
               
               stmt.execute();
               
               conexao.commit();
               
               cliente.atualizarCodigo(++codigo); //Codigo percentente ao ultimo cliente,
                                                  //necessário incrementar, 
                                                  //pois o banco de dados está setado auto_increment.
               
           } catch (SQLException e) {
               try {
                   conexao.rollback();
               } catch (SQLException ex) { }
           } finally {
               SingletonConexao.getInstance().fecharConexao(conexao, stmt);
           }
        }
        return cliente;
    }
    
    public void alterarCliente(Cliente cliente) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
           try {
               String sql = "update cliente set NOME=?, CPF=?, ESTADO=?, CIDADE=?, BAIRRO=?, RUA=?, "
                       + "                      COMPLEMENTO=?, TELEFONE=?, EMAIL=?"
                       + "   where CODIGO_CLIENTE="+cliente.obterCodigo()+";";
               
               stmt = conexao.prepareStatement(sql);
               prepararComandoAtualizacao(stmt, cliente);
               
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
    
    public void excluirCliente(Cliente cliente) {
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        if (conexao != null) {
            try {
                String sql = "delete from cliente where CODIGO_CLIENTE="+cliente.obterCodigo()+";";
                
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
    
    public ArrayList <Cliente> lerClientes() {
        ArrayList <Cliente> clientes = new ArrayList <Cliente>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select * from cliente;"; 
                        
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    clientes.add(retornarCliente(rs));
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
        return clientes;
    }
    
    public ArrayList <Cliente> buscarClientesPorEspecificacao(String coluna, String dado) {
        ArrayList <Cliente> clientes = new ArrayList <Cliente>();
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql;
                if (coluna.equals("CODIGO_CLIENTE")) {
                    sql = "select * from cliente where "+coluna+" = "+Integer.parseInt(dado)+";"; 
                } else {
                    sql = "select * from cliente where "+coluna+" like '%"+dado+"%';";
                }
                
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    clientes.add(retornarCliente(rs));
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
        if (clientes.size() > 0) {
            return clientes;
        } else {
            return null;
        }
    }
    
    /*
    private int buscarCodigoUltimoCliente() {
        ArrayList <Cliente> clientes = lerClientes();
        Cliente cliente = clientes.get(clientes.size()-1);
        return cliente.obterCodigo();
    }
    /*
    
    */
    /*public Cliente buscarCliente(int codigo) {
        Cliente cliente = null;
        Connection conexao = SingletonConexao.getInstance().obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (conexao != null) {
            try {
                String sql = "select * from cliente where CODIGO_CLIENTE="+codigo+";";
                stmt = conexao.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    cliente.atualizarCodigo(buscarCodigoUltimoCliente()+1);
                    cliente.atualizarNome(rs.getString("NOME"));
                    cliente.atualizarCpf(rs.getString("CPF"));
                    cliente.atualizarEstado(rs.getString("ESTADO"));
                    cliente.atualizarCidade(rs.getString("CIDADE"));
                    cliente.atualizarBairro(rs.getString("BAIRRO"));
                    cliente.atualizarRua(rs.getString("RUA"));
                    cliente.atualizarComplemento(rs.getString("COMPLEMENTO"));
                    cliente.atualizarTelefone(rs.getString("TELEFONE"));
                    cliente.atualizarEmail(rs.getString("EMAIL"));
                }
                
            } catch (SQLException e) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) { }
            } finally {
                SingletonConexao.getInstance().fecharConexao(conexao, stmt, rs);
            }
        }
        return cliente;
    }*/
}
