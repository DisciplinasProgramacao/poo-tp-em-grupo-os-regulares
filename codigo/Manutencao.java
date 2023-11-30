public class Manutencao{
    private double km;
    private String descricao;

    public Manutencao(double km, String descricao){
        this.km = km;
        this.descricao=descricao;
    }

    //Criar toString 
    @Override
    public String toString(){
        return ("Manutenção do tipo "+descricao+" realizada com: "+km+" km");
    }

}