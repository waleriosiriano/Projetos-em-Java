import java.io.*;
import java.util.*;

public class AgendaEletronica {

    private static final String NOME_ARQUIVO = "eventos.txt"; // Define o nome do arquivo onde os eventos serão armazenados

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler entrada do usuário

        while (true) { // Loop infinito para exibir o menu e aguardar a entrada do usuário
            System.out.println("Opções:");
            System.out.println("1. Inserir novo evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opçao: ");
            int opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

            switch (opcao) { // Executa uma ação com base na opção escolhida
                case 1:
                    inserirEvento(); // Chama o método para inserir um novo evento
                    break;
                case 2:
                    listarEventos(); // Chama o método para listar todos os eventos
                    break;
                case 3:
                    System.out.println("Saindo do programa..."); // Exibe uma mensagem de saída
                    scanner.close(); // Fecha o Scanner
                    System.exit(0); // Termina o programa
                default:
                    System.out.println("Opção inválida! Por favor, escolha novamente."); // Exibe uma mensagem de erro
                                                                                         // se a opção for inválida
            }
        }
    }

    private static void inserirEvento() {
        Scanner scanner = new Scanner(System.in); // Cria um novo Scanner para ler os detalhes do evento
        try (FileWriter fw = new FileWriter(NOME_ARQUIVO, true); // Cria um FileWriter para escrever no arquivo de
                                                                 // eventos
                BufferedWriter bw = new BufferedWriter(fw); // Cria um BufferedWriter para escrever no arquivo de
                                                            // eventos
                PrintWriter pw = new PrintWriter(bw)) { // Cria um PrintWriter para escrever no arquivo de eventos

            System.out.print("Digite o nome do evento: ");
            String nome = scanner.nextLine(); // Lê o nome do evento fornecido pelo usuário
            System.out.print("Digite a data de início do evento (dd/mm/aaaa): ");
            String dataInicio = scanner.nextLine(); // Lê a data de início do evento fornecida pelo usuário
            System.out.print("Digite a duração do evento (em minutos): ");
            int duracao = scanner.nextInt(); // Lê a duração do evento fornecida pelo usuário

            pw.println(nome + ";" + dataInicio + ";" + duracao); // Escreve os detalhes do evento no arquivo de eventos
            System.out.println("Evento inserido com sucesso!"); // Exibe uma mensagem de sucesso

        } catch (IOException e) { // Captura exceções de IO
            System.err.println("Erro ao escrever no arquivo."); // Exibe uma mensagem de erro
            e.printStackTrace(); // Imprime a rastreabilidade do erro
        }
    }

    private static void listarEventos() {
        try (Scanner scanner = new Scanner(new File(NOME_ARQUIVO))) { // Cria um Scanner para ler o arquivo de eventos
            while (scanner.hasNextLine()) { // Loop enquanto houver linhas no arquivo
                String linha = scanner.nextLine(); // Lê a próxima linha do arquivo
                String[] partes = linha.split(";"); // Divide a linha em partes usando ';' como delimitador

                String titulo = partes[0]; // Obtém o título do evento
                String dataInicio = partes[1]; // Obtém a data de início do evento
                int duracao = Integer.parseInt(partes[2]); // Obtém a duração do evento como um inteiro

                System.out.println("Título: " + titulo); // Exibe o título do evento
                System.out.println("Data de início: " + dataInicio); // Exibe a data de início do evento
                System.out.println("Duração: " + duracao + " minutos\n"); // Exibe a duração do evento
            }
        } catch (FileNotFoundException e) { // Captura exceções de arquivo não encontrado
            System.err.println("Arquivo de eventos não encontrado."); // Exibe uma mensagem de erro
        }
    }
}
