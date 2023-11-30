import java.util.ArrayList;
import java.util.List;

public class Frota {
	// #region atributos
	private int tamanhoFrota;
	private List<Veiculo> veiculos;
	private int qtdVeiculos;

	// #endregion

	// #region construtor

	/*
	 * Construtor da classe Frota
	 * 
	 * @param a quantidade da frota tipo Int
	 */
	public Frota(int tamanhoFrota) {
		this.tamanhoFrota = tamanhoFrota;
		// veiculos = new ArrayList<Veiculo>();
		veiculos = new ArrayList<Veiculo>();
		this.qtdVeiculos = 0;
	}
	// #endregion

	// #region métodos
	/**
	 * Metódo que retorna uma String com um relatório da frota de veículos.
	 * Este método utiliza um StringBuilder chamado aux2 para concatenar informações
	 * sobre cada veículo em um array (veiculos).
	 * Finalmente, ele retorna a string concatenada.
	 * 
	 * @return String com a descrição do relatorio da frota
	 */

	public String relatorioFrota() {
		StringBuilder aux2 = new StringBuilder();

		for(Veiculo v: veiculos){
			aux2.append(v.toString());
		}
		return aux2.toString();
	}

	/**
	 * Adiciona veículo na frota
	 * 
	 * @param add veículo a ser adicionado
	 */
	public void adicionarVeiculo(Veiculo add) {
		Veiculo atual = add;
		if (qtdVeiculos < this.tamanhoFrota) {
			veiculos.add(qtdVeiculos, atual);
			qtdVeiculos++;
		} else
			System.out.println("Erro ao adicionar na frota");

	}

	/**
	 * Método tem como objetivo procurar um veículo com uma placa específica dentro
	 * de um array de veículos (veiculos)
	 * 
	 * @param tipo String dígitos da placa
	 * @return Veículo localizado ou nullo se não foi
	 */
	public Veiculo localizarVeiculo(String placa) {
		// Veiculo atual=new Veiculo();
		Veiculo atual=null;

		for(Veiculo v: veiculos){
			if(v.getPlaca().equals(placa)){
				atual = v;
			}
		}

		return atual;

	}

	/**
	 * Método que calcula a quilometragem total de um array de veículos (veiculos).
	 * A quilometragem total é obtida somando os quilômetros totais individuais de
	 * cada veículo no array.
	 * 
	 * @return Double com a quilometragem total da frota
	 */
	public double quilometragemTotal() {
		double kmTotalVeiculos = 0;
	
		for(Veiculo v: veiculos){
			kmTotalVeiculos += v.getKmTotal();
		}
		return kmTotalVeiculos;
	}

	/**
	 * Método para percorrer um array de veículos (veiculos) para encontrar o
	 * veículo com a maior quilometragem total.
	 * 
	 * @return Veiculo com a maior quilometragem
	 */
	public String maiorKmTotal() {
		String retorno = "";

		Veiculo maiorV = veiculos.get(0);
		double maiorKm = maiorV.getKmTotal();

		for (int i = 1; i < qtdVeiculos; i++) {
			Veiculo atual = veiculos.get(i);
			double atualKm = atual.getKmTotal();

			if (maiorKm < atualKm) {
				maiorKm = atualKm;
				retorno = atual.getPlaca();

			}
		}
		return retorno;

	}

	/**
	 * Método para percorrer um array de veículos (veiculos) para encontrar o
	 * veículo com a maior média de quilometragem por rota entre todos os veículos..
	 * 
	 * @return Veiculo com a maior média de km
	 */
	public String maiorKmMedia() {
		String retorno = "";

		Veiculo maior = veiculos.get(0);
		double kmMediaMaior = maior.getKmTotal() / maior.getQuantRotas();

		Veiculo atual = veiculos.get(1);

		double kmMedAtual = atual.getKmTotal() / atual.getQuantRotas();

		for (int i = 2; i < qtdVeiculos; i++) {
			if (kmMedAtual > kmMediaMaior) {
				kmMediaMaior = kmMedAtual;
				maior = atual;
			}
			atual = veiculos.get(i);
			kmMedAtual = atual.getKmTotal() / atual.getQuantRotas();

		}

		retorno = maior.getPlaca();

		return retorno;
	}

	// public String relatorioRotas(){
	// 	StringBuilder aux = new StringBuilder();

	// 	for (Veiculo veiculo : veiculos) {

	// 		System.out.println("ENTROU NO FOR DE FROTA");
	// 		aux.append(veiculo.relatorioRotas());
	// 	}

	// 	return aux.toString();
	// }
	
	public void relatorioRotas(){
		for (Veiculo veiculo : veiculos) {
			veiculo.relatorioRotas(veiculo.getPlaca());
		}
	}

	public String quilometragemTotalVeiculo(String placa){

		Veiculo v = localizarVeiculo(placa);
		StringBuilder aux = new StringBuilder();

		if(v!=null){
			aux.append("A quilometragem total do veículo com a placa ").append(placa).append(" é de: ");
			aux.append(v.getKmTotal()).append(" km");
		}
		else{
			aux.append("Esta placa não corresponde a um veículo da frota");
		}

		 return aux.toString();
	}

	// #endregion

}
