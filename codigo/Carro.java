public class Carro extends Veiculo{
    
    private static final int CAPACIDADE_TANQUE = 50;
    private EtipoManutencao tipo;

    public Carro(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EtipoManutencao.CARRO;
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
