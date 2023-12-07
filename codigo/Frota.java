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
		StringBuilder aux = new StringBuilder();

		for (Veiculo v : veiculos) {
			aux.append(v.toString());
		}
		return aux.toString();
	}

	/**
	 * Adiciona veículo na frota
	 *
	 * @param add veículo a ser adicionado
	 */
	public void adicionarVeiculo(Veiculo add) { // Colocar uma exceção de erro ao adicionar
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
	public Veiculo localizarVeiculo(String placa) { // Colocar uma exceção se o veículo não for encontrado
		Veiculo atual;

		atual = veiculos.stream()
				.filter(v -> v.getPlaca().equals(placa))
				.findFirst().get();

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

		// for (Veiculo v : veiculos) {
		// kmTotalVeiculos += v.getKmTotal();
		// }

		kmTotalVeiculos = veiculos.stream()
				.mapToDouble(Veiculo::getKmTotal)
				.sum();
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

		Veiculo aux = veiculos.stream()
		.max((v1,v2) ->v1.getKmTotal()>v2.getKmTotal()?1:-1)
		.orElse(null);

		if(aux!=null){
			retorno= aux.getPlaca();
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

		Veiculo aux = veiculos.stream()
		.max ((v1,v2) -> v1.mediakm() > v2.mediakm()? 1:-1)
		.orElse(null);


		if (aux!=null){
			retorno = aux.getPlaca();
		}
		return retorno;
	}	

	public String relatorioRotas() {

		StringBuilder aux = new StringBuilder();
		for (Veiculo veiculo : veiculos) {
			aux.append(veiculo.relatorioRotas(veiculo.getPlaca()));
		}
		return aux.toString();
	}

	public String quilometragemTotalVeiculo(String placa) {  //Exception de não existe veículo com a placa

		Veiculo v = localizarVeiculo(placa);
		StringBuilder aux = new StringBuilder();

		if (v != null) {
			aux.append("A quilometragem total do veículo com a placa ").append(placa).append(" é de: ");
			aux.append(v.getKmTotal()).append(" km");
		} else {
			aux.append("Esta placa não corresponde a um veículo da frota");
		}

		return aux.toString();
	}

	/*
	 * Método que utiliza um stream para acessar o método "relatorioManutencao" de todos os veículo da frota.
	 * 
	 * @return String com as informações de relatórios dos veículos
	 */
	public String relatorioManutencao() {

		return veiculos.stream()
		.map(Veiculo::relatorioManutencao)
		.reduce((a,b)-> a.concat("\n"+b))
		.orElse(null);
	}

	public String gastosTotais() {
		StringBuilder aux = new StringBuilder();
		double valor = 0;
		for (Veiculo veiculo : veiculos) {
			aux.append("Valor total gasto pelo veículo de placa " + veiculo.getPlaca());
			valor = veiculo.gastoTotal();
			aux.append(" - R$ " + valor).append("\n");
		}
		return aux.toString();
	}

	// #endregion

}
