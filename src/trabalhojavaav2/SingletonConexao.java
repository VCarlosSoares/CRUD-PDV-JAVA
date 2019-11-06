package trabalhojavaav2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class SingletonConexao {
    
    private static SingletonConexao INSTANCE = null;
    
    public static SingletonConexao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonConexao();
            
        } 
        return INSTANCE;
    }
    
    public Connection obterConexao()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_mercadinho", 
                                                             "root", "123456");
            
            conexao.setAutoCommit(false);
            return conexao;
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro de conexao: "+e);
        }
        return null;
    }
    
    public void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao: "+e);
        } 
    }
    
    public void fecharConexao(Connection conexao, PreparedStatement stmt) {
        fecharConexao(conexao);
        
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao: "+e);
        }
    }
    
    public void fecharConexao(Connection conexao, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(conexao, stmt);
        
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao: "+e);
        }
    }
    
    /*
    private void inicializar() {
               try {
            Class.forName("com.mysql.jdbc.Driver");
        
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_mercadinho", 
                                                "root", "123456");
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro de conexao: "+e);
        }

    } 
    
    public PreparedStatement obterSTMT(String sql) {
        try {
            return conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SingletonConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
}

