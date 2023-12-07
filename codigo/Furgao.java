public class Furgao extends Veiculo {
    private static final int CAPACIDADE_TANQUE = 80;
    private EMaxManutencoes tipo;

    public Furgao(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EMaxManutencoes.FURGAO;
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
