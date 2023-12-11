package src;
public class Van extends Veiculo{

    private static final int CAPACIDADE_TANQUE = 60;
    private EMaxManutencoes tipo;

    public Van(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EMaxManutencoes.VAN;
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
