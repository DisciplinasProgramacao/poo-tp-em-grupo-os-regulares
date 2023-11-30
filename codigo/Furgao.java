public class Furgao extends Veiculo {
    private static final int CAPACIDADE_TANQUE = 80;
    private EtipoManutencao tipo;

    public Furgao(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EtipoManutencao.FURGAO;
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
