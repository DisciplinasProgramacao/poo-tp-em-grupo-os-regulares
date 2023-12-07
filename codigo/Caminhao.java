public class Caminhao extends Veiculo {

    private static final int CAPACIDADE_TANQUE = 250;
    private EMaxManutencoes tipo;

    public Caminhao(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EMaxManutencoes.CAMINHAO;
        this.setManutencoesIniciais(this.tipo);

    }

    @Override
    public double gerarNovaManutencaoPreventiva(){
        return this.getKmTotal()+this.tipo.getMaxKm();
    };


     @Override
    public double gerarNovaManutencaoPecas(){
        return this.getKmTotal()+this.tipo.getMaxPecas();
    };
}
