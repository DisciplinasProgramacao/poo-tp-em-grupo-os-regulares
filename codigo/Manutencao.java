public class Manutencao{
    private double km;
    private ETipoManutencao tipoManutencao;

    public Manutencao(double km, String descricao){
        this.km = km;
        if(descricao.equals("preventiva")){
             this.tipoManutencao= ETipoManutencao.PERIODICA;
        }
        else{
            this.tipoManutencao= ETipoManutencao.PECAS;
        }
    }

   //@Override
    public String relatorioManutencao(){
        StringBuilder aux = new StringBuilder();
        aux.append("Manutenção do tipo "+tipoManutencao.getDescricao()+" realizada com: "+km+" km"+" com valor de R$"+tipoManutencao.getValor() );
        return aux.toString();
    }

    @Override
    public String toString(){
        return ("Manutenção do tipo "+tipoManutencao.getDescricao()+" realizada com: "+km+" km"+" com valor de R$"+tipoManutencao.getValor() );
    }

    public double getValor(){
        return tipoManutencao.getValor();
    }

}