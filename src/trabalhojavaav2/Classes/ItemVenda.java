package trabalhojavaav2.Classes;

/**
 *
 * @author vitor
 */
public class ItemVenda {
    private int codigoVenda;
    private int codigoProduto;
    private int quantidade;
    private float precoUnit;
    private float precoTotal;

    public int obterCodigoVenda() {
        return codigoVenda;
    }

    public void atualizarCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
    
    public int obterCodigoProduto() {
        return codigoProduto;
    }

    public void atualizarCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int obterQuantidade() {
        return quantidade;
    }

    public void atualizarQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float obterPrecoUnit() {
        return precoUnit;
    }

    public void atualizarPrecoUnit(float precoUnit) {
        this.precoUnit = precoUnit;
    }

    public float obterPrecoTotal() {
        return precoTotal;
    }

    public void atualizarPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
}
