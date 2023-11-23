public class Carro extends Veiculo{
    private static final int MANUTECAOPERIODICA = 10000;
    private static final int MANUTENCAOPECAS = 10000;
    private static final int CAPACIDADE_TANQUE = 50;
   
    public Carro (String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
    }
}
