public class Caminhao extends Veiculo {

    private static final int CAPACIDADE_TANQUE = 250;
    private EtipoManutencao tipo;

    public Caminhao(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EtipoManutencao.CAMINHAO;
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
