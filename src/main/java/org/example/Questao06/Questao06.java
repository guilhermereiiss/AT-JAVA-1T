package org.example.Questao06;

public class Questao06 {
    public static void main(String[] args) {
        Veiculo veiculo1 = new Veiculo("NEYMAR-1234", "Sedan", 2020, 50000);
        Veiculo veiculo2 = new Veiculo("JAVA-5678", "SUV", 2018, 75000);

        System.out.println("Dados iniciais dos veiculos:");
        veiculo1.exibirDetalhes();
        veiculo2.exibirDetalhes();

        System.out.println("Registrando viagens...");
        veiculo1.registrarViagem(120);
        veiculo2.registrarViagem(200);

        System.out.println("\nDados atualizados dos veiculos:");
        veiculo1.exibirDetalhes();
        veiculo2.exibirDetalhes();
    }
}


