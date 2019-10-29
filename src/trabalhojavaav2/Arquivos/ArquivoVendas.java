package trabalhojavaav2.Arquivos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;
import trabalhojavaav2.Classes.Venda;

/**
 *
 * @author vitor
 */
public class ArquivoVendas {
    private String nomeArquivo;
    
    public ArquivoVendas(String nomeArquivo) {
        this.nomeArquivo=nomeArquivo;
    }
    
    public void salvarEmTxt(ArrayList <Venda> vendas) {
        Formatter saida = null;
        try {
            try {
                saida = new Formatter(nomeArquivo);
                for (int i = 0; i < vendas.size(); i++) {
                    Venda venda = vendas.get(i);
                    saida.format("%d\n%s\n%d\n%.2f\n%d\n", venda.obterCodigo(),
                                                           new SimpleDateFormat("dd/MM/yyyy").format(venda.obterData()),
                                                           venda.obterCodigoCliente(),
                                                           venda.obterPrecoTotal(),
                                                           venda.obterCodigoFormaPag());
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

    public ArrayList <Venda> abrirTxt() {
        Scanner entrada = null;
        ArrayList <Venda> vendas = new ArrayList <Venda>();
        try {
            try {
                entrada = new Scanner(new File(nomeArquivo));
                while (entrada.hasNextLine()) {
                    Venda venda = new Venda();
                    venda.atualizarCodigo(Integer.parseInt(entrada.nextLine()));
                    String dataSemFormat=entrada.nextLine();  
                    Date data=new SimpleDateFormat("dd/MM/yyyy").parse(dataSemFormat);  
                    venda.atualizarData(data);
                    venda.atualizarCodigoCliente(Integer.parseInt(entrada.nextLine()));
                    venda.atualizarPrecoTotal(Float.parseFloat(entrada.nextLine().replaceAll(",", ".")));
                    venda.atualizarCodigoFormaPag(Integer.parseInt(entrada.nextLine()));
                    vendas.add(venda);
                }
                return vendas;
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
