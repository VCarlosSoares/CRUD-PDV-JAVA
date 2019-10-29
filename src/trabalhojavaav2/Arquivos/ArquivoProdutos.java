package trabalhojavaav2.Arquivos;

/**
 *
 * @author vitor
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import trabalhojavaav2.Classes.Produto;

public class ArquivoProdutos {
    private String nomeArquivo;
    
    public ArquivoProdutos(String nomeArquivo) {
        this.nomeArquivo=nomeArquivo;
    }
    
    public void salvarEmTxt(ArrayList <Produto> produtos) {
        Formatter saida = null;
        try {
            try {
                saida = new Formatter(nomeArquivo);
                for (int i = 0; i < produtos.size(); i++) {
                    Produto produto = produtos.get(i);
                    saida.format("%d\n%s\n%.2f\n%d\n", produto.obterCodigo(),
                                                       produto.obterNome(),
                                                       produto.obterPreco(),
                                                       produto.obterEstoque());
                }
            } finally {
                if (saida != null) {
                    saida.close();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList <Produto> abrirTxt() {
        Scanner entrada = null;

        /*DecimalFormat format=DecimalFormat.getInstance();
        DecimalFormatSymbols symbols=format.getDecimalFormatSymbols();
        char sep=symbols.getDecimalSeparator();*/

        ArrayList <Produto> produtos = new ArrayList <Produto>();
        try {
            try {
                entrada = new Scanner(new File(nomeArquivo));
                while (entrada.hasNextLine()) {
                    Produto produto = new Produto();
                    produto.atualizarCodigo(Integer.parseInt(entrada.nextLine()));
                    produto.atualizarNome(entrada.nextLine());
                    produto.atualizarPreco(Float.parseFloat(entrada.nextLine().replaceAll(",", ".")));
                    produto.atualizarEstoque(Integer.parseInt(entrada.nextLine()));
                    produtos.add(produto);
                }
                return produtos;
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}