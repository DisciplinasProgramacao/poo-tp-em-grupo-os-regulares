public class Van extends Veiculo{

    private static final int CAPACIDADE_TANQUE = 60;
    private EtipoManutencao tipo;

    public Van(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EtipoManutencao.VAN;
    }

    @Override
    public double gerarNovaManutencaoPreventiva(){
        return this.getKmTotal()+this.tipo.getMaxPeriodica();
    };
     @Override
    public double gerarNovaManutencaoPecas(){
        return this.getKmTotal()+this.tipo.getMaxPecas();
    };
}
