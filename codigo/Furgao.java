public class Furgao extends Veiculo {
    private static final int MANUTECAOPERIODICA = 10000;
    private static final int MANUTENCAOPECAS = 12000;
    private static final int CAPACIDADE_TANQUE = 80;
    
    public Furgao (String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
    }
}
