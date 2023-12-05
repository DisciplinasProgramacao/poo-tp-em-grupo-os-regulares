public class Manutencao{
    private double km;
    private EtipoManutencao tipoManutencao;

    public Manutencao(double km, String descricao){
        this.km = km;
        if(descricao.equals("preventiva")){
             this.tipoManutencao= EtipoManutencao.PERIODICA;
        }
        else{
            this.tipoManutencao= EtipoManutencao.PECAS;
        }
    }

    @Override
    public String toString(){
        return ("Manutenção do tipo "+tipoManutencao.getDescricao()+" realizada com: "+km+" km"+" com valor de R$"+tipoManutencao.getValor() );
    }

}