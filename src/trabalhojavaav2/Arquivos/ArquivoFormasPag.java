package trabalhojavaav2.Arquivos;

/**
 *
 * @author vitor
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import trabalhojavaav2.Classes.FormaPagamento;

public class ArquivoFormasPag {
    private String nomeArquivo;
    
    public ArquivoFormasPag(String nomeArquivo) {
        this.nomeArquivo=nomeArquivo;
    }
    
    public void salvarEmTxt(ArrayList <FormaPagamento> formasPag) {
        Formatter saida = null;
        try {
            try {
                saida = new Formatter(nomeArquivo);
                for (int i = 0; i < formasPag.size(); i++) {
                    FormaPagamento formaPag = formasPag.get(i);
                    saida.format("%d\n%s\n", formaPag.obterCodigo(),
                                             formaPag.obterNome());
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

    public ArrayList <FormaPagamento> abrirTxt() {
        Scanner entrada = null;
        ArrayList <FormaPagamento> formasPag = new ArrayList <FormaPagamento>();
        try {
            try {
                entrada = new Scanner(new File(nomeArquivo));
                while (entrada.hasNextLine()) {
                    FormaPagamento formaPag = new FormaPagamento();
                    formaPag.atualizarCodigo(Integer.parseInt(entrada.nextLine()));
                    formaPag.atualizarNome(entrada.nextLine());
                    formasPag.add(formaPag);
                }
                return formasPag;
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
