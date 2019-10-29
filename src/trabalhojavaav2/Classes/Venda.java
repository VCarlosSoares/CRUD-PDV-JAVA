package trabalhojavaav2.Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vitor
 */
public class Venda {
    private int codigo;
    private Date data;
    private int codigoCliente;
    private float precoTotal;
    private int codigoFormaPag;

    public int obterCodigo() {
        return codigo;
    }

    public void atualizarCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Date obterData() {
        return data;
    }

    public void atualizarData(Date data) {
        this.data = data;
    }

    public int obterCodigoCliente() {
        return codigoCliente;
    }

    public void atualizarCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public float obterPrecoTotal() {
        return precoTotal;
    }

    public void atualizarPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int obterCodigoFormaPag() {
        return codigoFormaPag;
    }

    public void atualizarCodigoFormaPag(int codigoFormaPag) {
        this.codigoFormaPag = codigoFormaPag;
    }
    
}
