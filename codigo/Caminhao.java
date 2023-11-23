public class Caminhao extends Veiculo{
    private static final int MANUTECAOPERIODICA = 20000;
    private static final int MANUTENCAOPECAS = 20000;
    private static final int CAPACIDADE_TANQUE = 250;
    
    public Caminhao (String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
    }
}
