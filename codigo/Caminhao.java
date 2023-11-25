public class Caminhao extends Veiculo{
    private static final double MANUTECAOPERIODICA = 20000;
    private static final double MANUTENCAOPECAS = 20000;
    private static final int CAPACIDADE_TANQUE = 250;
    
    public Caminhao (String placa, COMBUSTIVEL tipoCombustivel) {
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
