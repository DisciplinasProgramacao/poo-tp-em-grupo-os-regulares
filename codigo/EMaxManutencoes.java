enum EMaxManutencoes{
   VAN(10_000,12_000),
   CAMINHAO(10_000,10_000),
   FURGAO(10000,12000),
   CARRO(10000,10000);
    
    double maxKm, maxPecas;

    EMaxManutencoes(double max, double maxKmPecas){
        this.maxKm=max;
        this.maxPecas=maxKmPecas;
    }

    public double getMaxKm() {
        return maxKm;
    }

    public double getMaxPecas() {
        return maxPecas;
    }


}