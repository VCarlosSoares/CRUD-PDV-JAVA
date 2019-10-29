package trabalhojavaav2.Arquivos;

/**
 *
 * @author vitor
 */

/*
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import trabalhojavaav2.Classes.Cliente;

public class ArquivoClientes {
    private String nomeArquivo;
    
    public ArquivoClientes(String nomeArquivo) {
        this.nomeArquivo=nomeArquivo;
    }
    
    public void salvarEmTxt(ArrayList <Cliente> clientes) {
        Formatter saida = null;
        try {
            try {
                saida = new Formatter(nomeArquivo);
                for (int i = 0; i < clientes.size(); i++) {
                    Cliente cliente = clientes.get(i);
                    saida.format("%d\n%s\n%s\n%s\n%s\n%s\n", cliente.obterCodigo(),
                                                             cliente.obterNome(),
                                                             cliente.obterCpf(),
                                                             cliente.obterEndereco(),
                                                             cliente.obterTelefone(),
                                                             cliente.obterEmail());
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

    public ArrayList <Cliente> abrirTxt() {
        Scanner entrada = null;
        ArrayList <Cliente> clientes = new ArrayList <Cliente>();
        try {
            try {
                entrada = new Scanner(new File(nomeArquivo));
                while (entrada.hasNextLine()) {
                    Cliente cliente = new Cliente();
                    cliente.atualizarCodigo(Integer.parseInt(entrada.nextLine()));
                    cliente.atualizarNome(entrada.nextLine());
                    cliente.atualizarCpf(entrada.nextLine());
                    cliente.atualizarEndereco(entrada.nextLine());
                    cliente.atualizarTelefone(entrada.nextLine());
                    cliente.atualizarEmail(entrada.nextLine());
                    clientes.add(cliente);
                }
                return clientes;
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
*/
