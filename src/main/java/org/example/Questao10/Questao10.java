package org.example.Questao10;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questao10 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            List<String> registros = cadastrarCompras(3);
            salvarCompras(registros);
            lerCompras();
        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static List<String> cadastrarCompras(int quantidade) {
        List<String> registros = new ArrayList<>();

        registros.add("Produto | Quantidade | Preço Unitario | Valor Total");
        registros.add("--------|------------|---------------|------------");

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("\nCadastro da compra: " + i);

            System.out.print("Produto: ");
            String produto = scanner.nextLine();

            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(scanner.nextLine());

            System.out.print("Preço: R$ ");
            double preco = Double.parseDouble(scanner.nextLine());
            double valorTotal = qtd * preco;

            String registro = String.format("%-8s | %-10d | R$ %-10.2f | R$ %.2f", produto, qtd, preco, valorTotal);
            registros.add(registro);
        }
        return registros;
    }

    private static void salvarCompras(List<String> registros) throws IOException {
        Path arquivo = Path.of("compras.txt");

        try {
            Files.createFile(arquivo);
            System.out.println("\nArquivo criado: " + arquivo.toAbsolutePath());
        } catch (FileAlreadyExistsException e) {
            System.out.println("\nO arquivo ja existe e sera subsituido: " + arquivo.toAbsolutePath());
        }
        Files.write(arquivo, registros, StandardCharsets.UTF_8);
    }

    private static void lerCompras() throws IOException {
        Path arquivo = Path.of("compras.txt");

        if (Files.exists(arquivo)) {
            System.out.println("\n*** Compras Registradas ***");
            List<String> linhas = Files.readAllLines(arquivo, StandardCharsets.UTF_8);
            linhas.forEach(System.out::println);
        } else {
            System.out.println("Arquivo de compras não encontrado!");
        }
    }
}
