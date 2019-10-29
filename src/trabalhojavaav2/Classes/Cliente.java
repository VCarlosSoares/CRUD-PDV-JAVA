package trabalhojavaav2.Classes;

/**
 *
 * @author vitor
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String cpf;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;
    private String telefone;
    private String email;

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

    public String obterCpf() {
        return cpf;
    }

    public void atualizarCpf(String cpf) {
        this.cpf = cpf;
    }

    public String obterEstado() {
        return estado;
    }

    public void atualizarEstado(String estado) {
        this.estado = estado;
    }

    public String obterCidade() {
        return cidade;
    }

    public void atualizarCidade(String cidade) {
        this.cidade = cidade;
    }

    public String obterBairro() {
        return bairro;
    }

    public void atualizarBairro(String bairro) {
        this.bairro = bairro;
    }

    public String obterRua() {
        return rua;
    }

    public void atualizarRua(String rua) {
        this.rua = rua;
    }

    public String obterComplemento() {
        return complemento;
    }

    public void atualizarComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String obterTelefone() {
        return telefone;
    }

    public void atualizarTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String obterEmail() {
        return email;
    }

    public void atualizarEmail(String email) {
        this.email = email;
    }

    
    
}
