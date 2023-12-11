package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppMenu {

  static Scanner teclado;
  static Map<String,Frota> frotas;

  //#region utilidades
    
     /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

     /**
     * Pausa para leitura de mensagens em console
     * 
     * @param teclado Scanner de leitura
     */
    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    /**
     * Encapsula uma leitura de teclado, com mensagem personalizada. A mensagem sempre é completada com ":". Retorna uma string 
     * que pode ser posteriormente convertida.
     * @param mensagem A mensagem a ser exibida, sem pontuação final.
     * @return String lida do usuário.
     */
    public static String leitura(String mensagem){
        System.out.print(mensagem+": ");
        return teclado.nextLine();
    }

    /**
     * Método para montagem de menu. Lê as opções de um arquivo e as numera automaticamente a partir de 1.
     * @param nomeArquivo Nome do arquivo texto com as opções (uma por linha)
     * @return Opção do usuário (int)
     * @throws FileNotFoundException em caso de arquivo não encontrado.
     */
    public static int menu(String nomeArquivo) throws FileNotFoundException {
        limparTela();
        File arqMenu = new File(nomeArquivo);
        Scanner leitor = new Scanner(arqMenu, "UTF-8");
        System.out.println(leitor.nextLine());
        System.out.println("==========================");
        int contador = 1;
        while(leitor.hasNextLine()){
            System.out.println(contador + " - " + leitor.nextLine());
            contador++;
        }
        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());
        leitor.close();
        return opcao;
    }
    //#endregion


    // Método para criar uma nova frota
    public static void criarFrota() {
      teclado = new Scanner(System.in);

      System.out.println("Digite o tamanho da frota");

      int tamanhoFrota = Integer.parseInt(teclado.nextLine());

      Frota frota = new Frota(tamanhoFrota);
      String codigoFrota = gerarCodigoAleatorio();

      frotas.put(codigoFrota, frota);

      System.out.println("Frota criada com sucesso!\n Código da Frota: " + codigoFrota);
    }

    /**
     * Método para gerar código.
     * @return Um código aleatório
     */
    public static String gerarCodigoAleatorio() {
        // Gera dois números aleatórios entre 0 e 9
        int numero1 = gerarNumeroAleatorio(0, 9);
        int numero2 = gerarNumeroAleatorio(0, 9);

        // Gera três letras aleatórias
        String letrasAleatorias = gerarLetrasAleatorias(3);

        // Monta o código seguindo o padrão
        String codigoAleatorio = "#" + numero1 + numero2 + letrasAleatorias;

        return codigoAleatorio;
    }

    /**
     * Consome combustível
     * @return qual tipo de combustível será consumido
     * @throws FileNotFoundException
     */
    public static COMBUSTIVEL coletaCombustivel() throws FileNotFoundException{
        teclado = new Scanner(System.in);

        String nomeArq = "/Users/avenueeco-caio/Documents/poo-os-regulares/poo-tp-em-grupo-os-regulares/codigo/menuCombustiveis";
        limparTela();
        int opcao = menu(nomeArq);

        switch(opcao){
            case 1:
                return COMBUSTIVEL.ALCCOL;
            case 2:
                return COMBUSTIVEL.GASOLINA;
            case 3:
                return COMBUSTIVEL.DIESEL;
            default:
                return COMBUSTIVEL.GASOLINA;
        }

    }


    /**
     * Adiciona veículo na frota 
     * @throws FileNotFoundException
     */
    public static void adicionarVeiculoFrota() throws FileNotFoundException {
      teclado = new Scanner(System.in);

      System.out.println("Digite o código da frota:");

      String codigoFrota = teclado.nextLine();

      if(frotas.containsKey(codigoFrota)){
        Frota frota = frotas.get(codigoFrota);
        String nomeArq = "/Users/avenueeco-caio/Documents/poo-os-regulares/poo-tp-em-grupo-os-regulares/codigo/menuVeiculos";
        limparTela();
        int opcao = menu(nomeArq);
        Veiculo veiculo;

        System.out.println("Digite a placa do veículo: ");

        String placa = teclado.nextLine();

        COMBUSTIVEL combustivel = coletaCombustivel();
        
        switch(opcao){
                case 1:
                    veiculo = new Carro(placa, combustivel);
                    pausa();
                    break;
                case 2:
                    veiculo = new Caminhao(placa, combustivel);
                    break;
                case 3:
                    veiculo = new Furgao(placa, combustivel);
                    break;
                case 4:
                    veiculo = new Van(placa, combustivel);
                    break;
                default:
                    System.out.println("Opcão inválida");
                    break;
            }
        


      
    }else{
        System.out.println("Frota inexistente");
    }
  }

  /**
   * Gerador de número aleatório
   * @param min número base
   * @param max número limite
   * @return
   */
    private static int gerarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Gerador de String
     * @param quantidade tamanho da String
     * @return String com caractéres aleatórios
     */
    private static String gerarLetrasAleatorias(int quantidade) {
        Random random = new Random();
        StringBuilder letras = new StringBuilder();

        for (int i = 0; i < quantidade; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            letras.append(letra);
        }

        return letras.toString();
    }

    /**
     * Abre o arquivo do menu de frotas, podendo criar uma nova frota ou adicionar um veículo.
     * @throws FileNotFoundException
     */
    public static void gerenciamentoFrota() throws FileNotFoundException {
        teclado = new Scanner(System.in);
        String nomeArq = "/Users/avenueeco-caio/Documents/poo-os-regulares/poo-tp-em-grupo-os-regulares/codigo/menuFrota";
        int opcao = -1;
        while(opcao!=0){
          limparTela();
          opcao = menu(nomeArq);
          switch(opcao){
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    criarFrota();
                    pausa();
                    break;
                case 2:
                    adicionarVeiculoFrota();
                    break;
                default:
                    System.out.println("Opcão inválida");
                    break;
            }
        }
    }
  public static void main(String[] args) throws FileNotFoundException {
        frotas = new HashMap<>();
        teclado = new Scanner(System.in);
        String nomeArq = "/Users/avenueeco-caio/Documents/poo-os-regulares/poo-tp-em-grupo-os-regulares/codigo/menuPrincipal";
        int opcao = -1;
        while(opcao!=0){
            limparTela();
            opcao = menu(nomeArq);
            switch(opcao){
                case 0:
                    System.out.println("Saindo aqui, bjs...");
                    break;
                case 1:
                    gerenciamentoFrota();
                    pausa();
                    break;
                case 2:
                    System.out.println("Opcão 2");
                    break;
                default:
                    System.out.println("Opcão inválida");
                    break;
            }

          }
        }
}
