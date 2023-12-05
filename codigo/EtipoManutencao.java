enum EtipoManutencao {
    PERIODICA("periodica",150d),
    PECAS("pecas",200d);

     String descricao ;
     double valor;

    EtipoManutencao(String d, double v){
        this.descricao = d;
        this.valor =  v; 
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    
}
