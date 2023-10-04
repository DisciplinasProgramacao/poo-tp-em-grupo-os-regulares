
public class Rota {
	//#region atributos
	private double quilometragem;
	private Data data;
	//#endregion


	//#region construtor
	/*
     * Construtor da classe Rota
     * @param Quilometragem da Rota tipo Double e a data tipo Data
     */
	public Rota(double km, Data data) {
		this.quilometragem = km;
		this.data = data;
	}
	//#endregion

	//region metodos

	/*
     * Método que retorna uma string representando um relatório de rota percorrida.
     * @return String com a descrição do relatorio da rota
     */
	public String relatorio() {
		String aux;
		aux = "A rota percorrida do dia " + data + " tem " +quilometragem +" km";
		return aux;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	//endregion
}
