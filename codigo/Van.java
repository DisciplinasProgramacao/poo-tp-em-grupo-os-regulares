public class Van extends Veiculo{
    private static final double MANUTECAOPERIODICA = 10000;
    private static final double MANUTENCAOPECAS = 12000;
    private static final int TANQUE = 60;

    public Van(String placa, COMBUSTIVEL tipoCombustivel){
       super(placa,TANQUE,tipoCombustivel);
       
    }
    
    public double verificarKmManutencaoPeriodica(){
        kmPeriodica = manutencao.manutencaoencaoPecas(MANUTECAOPERIODICA,  kmPeriodica);
        return  kmPecas;
    }
     public double verificarKmManutencaoPecas(){
        kmPecas = manutencao.manutencaoencaoPecas(MANUTENCAOPECAS, kmPecas);
        return  kmPecas;
    }
}
