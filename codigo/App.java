public class App {
        // Criando uma frota de veículos com capacidade para 5 veículos
        static Frota frota = new Frota(5);

	public static void main(String[] args) 
        {

        

        // Criando alguns veículos e adicionando-os à frota
        Veiculo veiculo1 = new Veiculo("ABC1234", 80.0); // Placa e capacidade do tanque
        Veiculo veiculo2 = new Veiculo("DEF5678", 90.0);
        Veiculo veiculo3 = new Veiculo("GHI9012", 100.0);

        frota.adicionarVeiculo(veiculo1);
        frota.adicionarVeiculo(veiculo2);
        frota.adicionarVeiculo(veiculo3);


        // Criando algumas rotas para os veículos
        Rota rota1 = new Rota(75.0, new Data(10, 1, 2023)); // Quilometragem e data
        Rota rota2 = new Rota(75.0, new Data(15, 1, 2023));
        Rota rota3 = new Rota(200.0, new Data(20, 1, 2023));

        Rota r1 = new Rota(150.0, new Data(2, 2, 2023)); 
        Rota r2 = new Rota(200.0, new Data(5, 3, 2023));
        Rota r11 = new Rota(200.0, new Data(2, 3, 2023)); 
        Rota r22 = new Rota(200.0, new Data(5, 3, 2023));
        Rota r3 = new Rota(200.0, new Data(7, 3, 2023));

        Rota t1 = new Rota(100.0, new Data(12, 1, 2023)); 
        Rota t2 = new Rota(400.0, new Data(27, 1, 2023));
        Rota t3 = new Rota(300.0, new Data(30, 1, 2023));
        Rota t4 = new Rota(400.0, new Data(30, 2, 2023));

        // Adicionando as rotas aos veículos
        veiculo1.addRota(rota1);
        veiculo1.addRota(rota1);
        veiculo1.addRota(rota2);
        veiculo1.addRota(rota3);

        veiculo2.addRota(r1);
        veiculo2.addRota(r2);
        veiculo2.addRota(r11);
        veiculo2.addRota(r22);
        veiculo2.addRota(r3);

        veiculo3.addRota(t1);
        veiculo3.addRota(t2);
        veiculo3.addRota(t3);
        veiculo3.addRota(t4);
       

        // Testando os métodos da classe Frota
        System.out.println();
        System.out.println(">>>>>>>>////////// Relatório da Frota //////////>>>>>>>>"+ frota.relatorioFrota());
        System.out.println();
     
        System.out.println("Veículo com maior quilometragem total: " + frota.maiorKmTotal());

        
        System.out.println("Veículo com maior média de quilometragem por rota: " + frota.maiorKmMedia());

       
        System.out.println("Quilometragem total da frota: " + frota.quilometragemTotal() + " km");

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

}

}


