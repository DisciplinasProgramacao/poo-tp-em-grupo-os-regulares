public class Tanque {
	//#region atributos
	private double capacidadeMaxima;
	private double capacidadeAtual;
	private final static double CONSUMO;
	//#endregion

	

	/*
     * Construtor da classe Tanque
     * @param a capacidade Maxima e capacidade atual de um tanque. Ambos tipo double
     */
	public Tanque(double capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
		this.capacidadeAtual=0;
	}
	static{
		
		CONSUMO = 8.2;
	}
	//#endregion

	//#region métodos

	/**
	 * 
	 * @param litros recebe volume de litros
	 * @return o valor abastecido
	 */
	public double abastecer (double litros) 
	{

		double volumeFuturo=capacidadeAtual+litros;

		double valorAbastecido;

		if (volumeFuturo==capacidadeMaxima)
		{
			valorAbastecido=this.capacidadeMaxima-this.capacidadeAtual;

			encherTanque ();
		
		}
		else if(volumeFuturo>capacidadeMaxima)
		{
			System.out.println("Impossível abastecer essa quantidade");
			return 0;
		}
		else
		{
			this.capacidadeAtual=volumeFuturo;

			valorAbastecido=litros;
		}
		

		return valorAbastecido;
	}

	private void encherTanque ()
	{
		capacidadeAtual=capacidadeMaxima;
	}
	/**
     * Método que calcula a autonomia máxima, com base no consumo e na capacidade máxima, do tanque.
	 *  @return Double com a autonomia máxima do tanque
	 */
	public double autonomiaMaxima() {
		return capacidadeMaxima*CONSUMO;
		
	}
	/**
     * Método que calcula a autonomia atual, com base no consumo e na capacidade atual, do tanque.
	 *  @return Double com a autonomia atual do tanque
	 */
	public double autonomiaAtual() {
		return capacidadeAtual*CONSUMO;
		
	}

	public boolean possuiAutonomia (double km)
	{
		boolean resposta=true;

		if(autonomiaMaxima()<km)
		{
			System.out.println("O veículo não possui autonomia máxima suficiente para realizar a rota.");
			resposta=false;
		}
		else resposta=true;

		return resposta;
	}

	public double litrosFaltando ( double km)
	{
		double litrosPrecisam = km/CONSUMO;
		
		double litrosFaltando = litrosPrecisam-capacidadeAtual;
		return litrosFaltando;
	}

	public void atualizarTanque (double km)
	{
		double valorGasto=km/CONSUMO;
		capacidadeAtual-=valorGasto;
	}
	public void combustivelGasto (double km)
	{
		double combustivelGasto = km*CONSUMO;
		atualizarTanque(combustivelGasto);
		
	}

	public double getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	public void setCapacidadeMaxima(double capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
	public double getCapacidadeAtual() {
		return capacidadeAtual;
	}
	public void setCapacidadeAtual(double capacidadeAtual) {
		this.capacidadeAtual = capacidadeAtual;
	}

	//#endregion
}

