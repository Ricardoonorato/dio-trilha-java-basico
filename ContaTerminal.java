import java.util.Scanner;

class Conta {
    private int agencia;
    private int numero;
    private String titular;
    private double saldo;

    // Construtor
    public Conta(int agencia, int numero, String titular, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Getters e Setters (opcional, mas recomendados para encapsulamento)
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }
}

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o número da agência: ");
            int agencia = scanner.nextInt();

            System.out.print("Digite o número da conta: ");
            int numero = scanner.nextInt();

            scanner.nextLine(); // Limpa o buffer do scanner

            System.out.print("Digite o nome do cliente: ");
            String titular = scanner.nextLine();

            System.out.print("Digite o saldo inicial: ");
            double saldo = scanner.nextDouble();

            // Cria um objeto Conta com os dados informados
            Conta conta = new Conta(agencia, numero, titular, saldo);

            System.out.println("\nConta criada com sucesso!");
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Saldo: R$" + conta.getSaldo());

            // Exemplo de depósito e saque
            conta.depositar(100);
            System.out.println("Saldo após depósito: R$" + conta.getSaldo());

            conta.sacar(50);
            System.out.println("Saldo após saque: R$" + conta.getSaldo());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace(); // Para depuração
        }
    }
}