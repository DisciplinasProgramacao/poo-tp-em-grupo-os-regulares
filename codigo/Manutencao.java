public class Manutencao{

    public Manutencao(){

    }
    public double manutencaoencaoPeriodica(double kmAtual,double kmManutencao){
        if(verificar(kmAtual, kmManutencao)){
            return 0d;
        }
        else{
            return kmAtual;
        }        
    }

    public double manutencaoencaoPecas(double kmAtual, double kmManutencao){
        if(verificar(kmAtual, kmManutencao)){
            return 0d;
        }
        else{
            return kmAtual;
        }     
    }
    
    public boolean verificar(double kmAtual, double kmManutencao){
        if(kmAtual>=kmManutencao){
            return true;
        }
        else{
            return false;
        }
    }

}