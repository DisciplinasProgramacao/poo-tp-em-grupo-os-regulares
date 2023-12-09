import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {

	// #region atributos
	private final static int MAXROTAS;
	private String placa;
	private Rota rotas[];
	private int quantRotas;
	private int mesAtual;
	protected Tanque tanque;
	private double totalReabastecido;
	private double kmTotal;
	private double kmMes;
	protected double kmPeriodica;
	protected List<Manutencao> listaManutencao;
	protected double kmProxManutencaoPreventiva;
	protected double kmProxManutencaoPecas;
	// #endregion

	// #region Construtores/inicializadores
	static {
		MAXROTAS = 30;
	}

	public Veiculo() {
		this.mesAtual = 0;
		this.quantRotas = 0;
	}

	/*
	 * Construtor da classe Veículo
	 * 
	 * @param placa identificador do veículo
	 * @param tanqueMax a capacidade máxima do tanque em litros
	 * @tipoCombustivel especifica qual o combustível utilizado pelo veículo
	 */

	public Veiculo(String placa, int tanqueMax, COMBUSTIVEL tipoCombustivel) {
		this.placa = placa;
		this.tanque = new Tanque(tanqueMax, tipoCombustivel);
		rotas = new Rota[MAXROTAS];
		this.mesAtual = 0;
		this.quantRotas = 0;
		this.kmTotal = 0;
		this.kmMes = 0;
		this.kmPeriodica = 0;
		this.listaManutencao = new ArrayList<>();
	}
	// #endregion

	// #region Métodos

	/**
	 * Método que verifica se a rota que deseja adicionar está no mesmo mês da última adicionada
	 * 
	 * @param rota a ser verificada
	 * @return TRUE se a rota está em um novo mês, FALSE se continua no mesmo mês
	 */
	private boolean verificarMes(Rota rota) {
		boolean trocouDeMes = false;

		int rotaRecebidaD = rota.getData().getMes();

		if (this.mesAtual < rotaRecebidaD) {
			this.mesAtual = rotaRecebidaD;
			trocouDeMes = true;
		} 
	
		return trocouDeMes;
	}

	/**
	 * Analisa autonomia do tanque de gasolina para concluir a rota.
	 * 
	 * @param rota rota a ser verificada 
	 * @return TRUE se o mês possui menos de 30 rotas e se possui autonomia; FALSE se não atende aos critérios.
	 */
	private boolean verificaRota(Rota rota) {
		boolean aprovada = true;
		double kmNecessarios = rota.getQuilometragem();
		
		if (verificarMes(rota)) {
			resetMes();
		}

		if (this.quantRotas < MAXROTAS) {
			if (kmNecessarios > tanque.autonomiaAtual()) {
				if (tanque.possuiAutonomia(kmNecessarios)) {
					this.abastecer(tanque.litrosFaltando(kmNecessarios));
				} else {
					aprovada = false;
				}

			}
		} else {
			aprovada = false;
		}

		return aprovada;
	}

	/**
	 * Método para adicionar uma rota ao veículo
	 * 
	 * @param Rota rota a ser adicionada
	 * @return TRUE se a rota foi adicionada, FALSE caso contrário
	 */
	public boolean addRota(Rota rota) {
		boolean adicionada = false;

		if (verificaRota(rota)) {
			this.rotas[quantRotas] = rota;
			this.quantRotas++;
			this.percorrerRota(rota);
			adicionada = true;
		}
		this.verificaManutencoes();
		return adicionada;
	}

	/*
	 * Método que verifica se é necessário realizar uma manutenção no veículo.
	 * Analisa se a quilometragem da próxima manutenção preventiva/de peças a ser feita é
	 * menor do que a da rota que será atribuída.
	 */
	private void verificaManutencoes() {
		if (this.kmProxManutencaoPreventiva <= this.kmTotal) {
			listaManutencao.add(new Manutencao(this.kmTotal, "preventiva"));
			this.kmProxManutencaoPreventiva = this.gerarNovaManutencaoPreventiva();
		}

		if (this.kmProxManutencaoPecas <= this.kmTotal) {
			listaManutencao.add(new Manutencao(this.kmTotal, "pecas"));
			this.kmProxManutencaoPecas = this.gerarNovaManutencaoPecas();
		}
	}

	public abstract double gerarNovaManutencaoPreventiva();

	public abstract double gerarNovaManutencaoPecas();

	/**
	 * Método que atualiza a variável "totalReabastecido" de acordo com a quantidade de litros abastecidos ao tanque
	 * @param litros recebe a quantidade a ser abastecida
	 */
	public void abastecer(double litros) {
		this.totalReabastecido += tanque.abastecer(litros);
	}

	/**
	 * Método que atualiza a variável "kmNoMes" 
	 * @param km quntidade de quilometros a ser adicionada
	 * 	 */
	public void kmNoMes(double km) {
		this.kmMes += km;
	}

	/**
	 * Método que calcula a quilometragem total, adicionando a quilometragem do mês fornecida como parâmetro.
	 * @param km quilometragem a ser adicionada
	 */
	public void kmTotal(double km) {
		this.kmTotal += km;
		kmNoMes(km);
	}

	/*
	 * Método resposável por inicializar o vetor de rotas e zerar as variáveis kmMes e quantRotas
	 * toda vez que há uma troca mês
	 */
	private void resetMes() {
		this.kmMes = 0;
		this.rotas = new Rota[MAXROTAS];
		this.quantRotas = 0;

	}

	/**
	 * Método que simula a ação de percorrer uma rota em um veículo, consumindo
	 * combustível do tanque com base na quilometragem da rota e no consumo do
	 * veículo (CONSUMO).
	 * 
	 * @param rota rota a ser percorrida por um veículo
	 */
	private void percorrerRota(Rota rota) {
		double kmDaRota = rota.getQuilometragem();
		kmTotal(kmDaRota);
		tanque.atualizarTanque(kmDaRota);
	}

	/*
	 * Método responsável por gerar um relatório de rotas para um veículo com base
	 * na placa fornecida.
	 * 
	 * @param placa identificador do veículo
	 * 
	 * @return Se o veículo possuir rotas, retorna o relatório de suas rotas feitas
	 */
	public String relatorioRotas(String placa) { // Adicionar exceção se um veículo não possui rotas
		StringBuilder relatorio = new StringBuilder();

		if (quantRotas > 0) {
			for (Rota rota : rotas) {
				if (rota != null) {
					relatorio.append(rota.relatorio(placa));
				}
			}
		} else {

			relatorio.append("Veículo não possui rotas.\n");
		}

		return relatorio.toString();
	}

	/*
	 * Método responsável por gerar relatórios das manutenções realizadas de cada
	 * veículo,
	 * tendo como identificador sua placa.
	 * 
	 * @return String com as informações de relatório dos veículos indicados pela
	 * placa
	 */
	public String relatorioManutencao() {
		StringBuilder aux = new StringBuilder();
		String base = "O veiculo de placa";
		listaManutencao.stream()
				.forEach(m -> aux.append(base + this.placa + " " + m.relatorioManutencao()));
		return aux.toString();
	}

	/*
	 * Método responsável por calcular o gasto total de cada de cada veículo.
	 *
	 * @return cálculo que envolve o valor total gasto com manutenções somado ao valor
	 * gasto com combustível.
	 */
	public double gastoTotal() {
		double soma = 0;
		soma = listaManutencao.stream()
				.mapToDouble(m -> m.getValor())
				.sum();

		return (tanque.calcularPreco(kmTotal) + soma);
	}

	/*
	 * Método que realiza o cáluclo da quilometragem média realizada por um veículo
	 * 
	 * @return o valor médio de quilômetros
	 */

	public double mediakm() {
		double soma = 0;
		for (Rota rota : rotas) {
			if (rota != null) {
				soma += rota.getQuilometragem();
			}
		}
		return (soma / quantRotas);
	}

	/**
	 * Método que definie o valor inicial das manutenções a serem feitas com base
	 * nos valores máximos do enumerador EMaxManutencoes
	 * 
	 * @param tipo tipo de manutenção para ter o valor inicial associado à variável
	 */
	public void setManutencoesIniciais(EMaxManutencoes tipo) {
		kmProxManutencaoPreventiva = tipo.maxKm;
		kmProxManutencaoPecas = tipo.maxPecas;
	}

	@Override
	public String toString() {
		DecimalFormat formato = new DecimalFormat("0.00");

		return "\n" +

				"Veiculo Placa: " + placa + "\n" +
				"Total Reabastecido: " + formato.format(totalReabastecido) + "\n" +
				"KM Total: " + formato.format(kmTotal) + "\n" +
				"KM No Mês Atual: " + formato.format(kmMes) + "\n" +
				" ------------------ " + "\n";
	}
	// #endregion

	// #region Getters Setters
	public double getKmTotal() {
		return kmTotal;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getQuantRotas() {
		return quantRotas;
	}

	public void setQuantRotas(int quantRotas) {
		this.quantRotas = quantRotas;
	}

	// #endregion
}
