public class Carro extends Veiculo{
    private static final double MANUTECAOPERIODICA = 10000;
    private static final double MANUTENCAOPECAS = 10000;
    private static final int CAPACIDADE_TANQUE = 50;
   
    public Carro (String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
    }
    public double verificarKmManutencaoPeriodica(){
        kmPeriodica = manutencao.manutencaoencaoPecas(MANUTECAOPERIODICA,  kmPeriodica);
        return  kmPecas;
        
    }
    public double verificarKmManutencaoPecas(){
        kmPecas = manutencao.manutencaoencaoPecas(MANUTENCAOPECAS,  kmPecas);
        return  kmPecas;
    }
}
