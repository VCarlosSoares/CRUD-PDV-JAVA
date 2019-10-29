package trabalhojavaav2.Classes;

/**
 *
 * @author vitor
 */
public class Produto {
    private int codigo;
    private String nome;
    private float preco;
    private int estoque;

    public int obterCodigo() {
        return codigo;
    }

    public void atualizarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String obterNome() {
        return nome;
    }

    public void atualizarNome(String nome) {
        this.nome = nome;
    }

    public float obterPreco() {
        return preco;
    }

    public void atualizarPreco(float preco) {
        this.preco = preco;
    }

    public int obterEstoque() {
        return estoque;
    }

    public void atualizarEstoque(int estoque) {
        this.estoque = estoque;
    }
    
}
