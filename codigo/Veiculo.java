
import java.text.DecimalFormat;

public class Veiculo {
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
	protected double kmPecas;
	protected Manutencao manutencao;

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
	 * @param a dígitos da placa tipo String e a capacidade máxima do tanque tipo
	 * Double
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
		this.manutencao = new Manutencao();
	}
	// #endregion

	// #region Métodos

	/**
	 * Método que verifica se a rota que deseja adicionar está no mesmo mês da
	 * ultima adicionada
	 * 
	 * @param Rota
	 * @return TRUE se esta no mesmo mês da ultima adicionada, FALSE caso contrário
	 */
	private boolean verificarMes(Rota rota) {
		boolean trocouDeMes = false;

		Data rotaRecebidaD = rota.getData();
		int recebidaM = rotaRecebidaD.getMes();

		if (this.mesAtual < recebidaM) {
			this.mesAtual = recebidaM;

			trocouDeMes = true;
		} else
			trocouDeMes = false;

		return trocouDeMes;
	}

	/**
	 * Analisa autonomia do tanque de gasolina para concluir a rota.
	 * 
	 * @param rota Recebe e verifica a possibilidade de adicionar a rota.
	 * @return TRUE se foi aprovada, FALSE se não atende aos critérios.
	 */
	private boolean verificaRota(Rota rota) {
		boolean aprovada = true;

		double kmNecessarios = rota.getQuilometragem();

		boolean trocouDeMes = verificarMes(rota);


		if (trocouDeMes == true) {
			resetMes();
		}

		if (this.quantRotas < MAXROTAS) {
			if (kmNecessarios > tanque.autonomiaAtual()) {
				if (tanque.possuiAutonomia(kmNecessarios) == false) {
					aprovada = false;
				} else {
					this.abastecer(tanque.litrosFaltando(kmNecessarios));
				}

			}

		} else
			aprovada = false;

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

		if (verificaRota(rota) == true) {
			this.rotas[quantRotas] = rota;
			this.quantRotas++;
			this.kmPeriodica += rota.getQuilometragem();
			this.kmPecas += rota.getQuilometragem();
			this.percorrerRota(rota);
			adicionada = true;
		} else {
			adicionada = false;
		}

		return adicionada;
	}

	/**
	 * 
	 * @param litros recebe a quantidade a ser abastecida
	 *               soma o valor com o total já abastecido.
	 */
	public void abastecer(double litros) {
		this.totalReabastecido += tanque.abastecer(litros);

	}

	/**
	 * Método que soma a quilometragem total percorrida para mês atual.
	 * 
	 */

	public void kmNoMes(double km) {

		this.kmMes += km;

	}

	/**
	 * Método que calcula a quilometragem total, adicionando a quilometragem do mês
	 * fornecida como parâmetro.
	 * 
	 * @param tipo Double quilometragem do mês.
	 * @return tipo Double com a km do veículo percorrida no total.
	 */
	public void kmTotal(double km) {
		this.kmTotal += km;

		kmNoMes(km);

	}

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
	 * @param tipo Rota.
	 */
	private void percorrerRota(Rota rota) {
		double kmDaRota = rota.getQuilometragem();
		kmTotal(kmDaRota);
		tanque.atualizarTanque(kmDaRota);
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

	public String relatorioRotas(String placa) {
		StringBuilder relatorio = new StringBuilder();

		if (quantRotas > 0) {
			for (Rota rota : rotas) {
				if(rota != null){
					//System.out.println(rota.relatorio(placa));
				    relatorio.append(rota.relatorio(placa));
				}
			}
		} else {
			//System.out.println("Veículo não possui rotas.\n");
			relatorio.append("Veículo não possui rotas.\n");
		}

		return relatorio.toString();
	}

	// #endregion

}
