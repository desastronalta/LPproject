package bancoClasses;

import java.util.Scanner;

public class Metodos {
    Scanner input = new Scanner(System.in);

    public void pagar(Cliente cliente, Conta conta) throws excecoes {

        double value = input.nextDouble();
        double credit = conta.getSaldoCredito();

        if (value > credit) {
            throw new excecoes("Saldo insuficiente.\n" + "Saldo atual: " + credit);
        }
        conta.setSaldoCredito(credit - value);

        System.out.println("Pagamento realizado com sucesso! \n" +
                "Saldo atual: " + conta.getSaldoCredito());
    }
}
