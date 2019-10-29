package trabalhojavaav2.Classes;

/**
 *
 * @author vitor
 */
public class FormaPagamento {
    private int codigo;
    private String nome;

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
    
    
}
