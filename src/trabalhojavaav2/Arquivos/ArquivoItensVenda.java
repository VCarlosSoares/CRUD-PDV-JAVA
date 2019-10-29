package trabalhojavaav2.Arquivos;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import trabalhojavaav2.Classes.ItemVenda;

/**
 *
 * @author vitor
 */
public class ArquivoItensVenda {
    private String nomeArquivo;
    
    public ArquivoItensVenda(String nomeArquivo) {
        this.nomeArquivo=nomeArquivo;
    }
    
    public void salvarEmTxt(ArrayList <ItemVenda> itens) {
        Formatter saida = null;
        try {
            try {
                saida = new Formatter(nomeArquivo);
                for (int i = 0; i < itens.size(); i++) {
                    ItemVenda itemVenda = itens.get(i);
                    saida.format("%d\n%d\n%d\n%.2f\n%.2f\n", itemVenda.obterCodigoVenda(),
                                                             itemVenda.obterCodigoProduto(),
                                                             itemVenda.obterQuantidade(),
                                                             itemVenda.obterPrecoUnit(),
                                                             itemVenda.obterPrecoTotal());
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

    public ArrayList <ItemVenda> abrirTxt() {
        Scanner entrada = null;
        ArrayList <ItemVenda> itens = new ArrayList <ItemVenda>();
        try {
            try {
                entrada = new Scanner(new File(nomeArquivo));
                while (entrada.hasNextLine()) {
                    ItemVenda itemVenda = new ItemVenda();
                    itemVenda.atualizarCodigoVenda(Integer.parseInt(entrada.nextLine()));
                    itemVenda.atualizarCodigoProduto(Integer.parseInt(entrada.nextLine()));
                    itemVenda.atualizarQuantidade(Integer.parseInt(entrada.nextLine()));
                    itemVenda.atualizarPrecoUnit(Float.parseFloat(entrada.nextLine().replaceAll(",", ".")));
                    itemVenda.atualizarPrecoTotal(Float.parseFloat(entrada.nextLine().replaceAll(",", ".")));
                    itens.add(itemVenda);
                }
                return itens;
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
