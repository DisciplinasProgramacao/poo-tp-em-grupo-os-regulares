enum EtipoManutencao{
   VAN(10_000,12_000),
   CAMINHAO(10_000,10_000),
   FURGAO(10000,12000),
   CARRO(10000,10000);
    
    double maxPeriodica, maxPecas;

    EtipoManutencao(double maxKmPeriodica, double maxKmPecas){
        this.maxPeriodica=maxKmPeriodica;
        this.maxPecas=maxKmPecas;

    }

    public double getMaxPeriodica() {
        return maxPeriodica;
    }

    public double getMaxPecas() {
        return maxPecas;
    }


}