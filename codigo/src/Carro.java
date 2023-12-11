package src;
public class Carro extends Veiculo{
    
    private static final int CAPACIDADE_TANQUE = 50;
    private EMaxManutencoes tipo;

    public Carro(String placa, COMBUSTIVEL tipoCombustivel) {
        super(placa, CAPACIDADE_TANQUE, tipoCombustivel);
        this.tipo = EMaxManutencoes.CARRO;
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
