public class Manutencao{
    public Manutencao(){

    }
    public double manutencaoPeriodica(double km,int manut){
        if(verificarPeriodica(km, manut)){
            return 0d;
        }
        else{
            return km;
        }        
    }

    public boolean verificarPeriodica(double km, int manut){
        if(km>=manut){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean verificarPecas(double km, int manut){
        if(km>=manut){
            return true;
        }
        else{
            return false;
        }
    }

    public double manutencaoPecas(double km, int manut){
        if(verificarPecas(km, manut)){
            return 0d;
        }
        else{
            return km;
        }     
    }
}