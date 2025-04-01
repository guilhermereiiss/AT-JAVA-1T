package org.example.Questao03;
import java.util.Scanner;

public class Imposto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu salario mensal: ");
        double salarioMensal = scanner.nextDouble();
        double salarioAnual = salarioMensal * 12;

        double taxinha;
        if (salarioAnual <= 22847.76) {
            taxinha = 0;
        } else if (salarioAnual <= 33919.80) {
            taxinha = 0.075;
        } else if (salarioAnual <= 45012.60) {
            taxinha = 0.15;
        } else {
            taxinha = 0.275;
        }

        double imposto = salarioAnual * taxinha;
        double salarioLiquido = salarioAnual - imposto;

        System.out.println("\nNome: " + nome);
        System.out.println("Salario Anual: R$ " + salarioAnual);
        System.out.println("Imposto a pagar: R$ "+ imposto);
        System.out.println("Salario Liquido: R$ "+ salarioLiquido);

        scanner.close();
    }
}
