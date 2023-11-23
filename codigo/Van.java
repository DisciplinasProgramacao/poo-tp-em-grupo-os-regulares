public class Van extends Veiculo{
    private static final int MANUTECAOPERIODICA = 10000;
    private static final int MANUTENCAOPECAS = 12000;
    private static final int TANQUE = 60;

    public Van(String placa, COMBUSTIVEL tipoCombustivel){
       super(placa,TANQUE,tipoCombustivel);
       tanque = new Tanque(60, tipoCombustivel);
    }
    
    public void verificarKmManutencaoPeriodica(){
        kmManutencao = manutencao.manutencaoPeriodica(kmManutencao, MANUTECAOPERIODICA);
    }
}
