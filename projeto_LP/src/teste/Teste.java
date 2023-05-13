package teste;

import bancoClasses.*;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) throws excecoes {
        Scanner sc = new Scanner(System.in);
        Cliente cliente1 = new Cliente();
        Banco banco = new Banco();
        Conta conta1 = new Conta();
        Cliente cliente2 = new Cliente();
        Conta conta2 = new Conta();
        entrarDados(cliente1, conta1);
        System.out.print("\n\n");
        banco.addClient(cliente1, conta1);


        for (int i = 0; i < banco.getClientes().size(); i++) {
            mostrarCliente(banco, i);
        }
        pagarComCredito(cliente1.getCpf(), cliente1.getNumBanco(), banco);
        sc.close();
    }

    public static void mostrarCliente(Banco banco, int i) {

        System.out.print(banco.getClientes().get(i).getContaType() + "\n");
        System.out.print(banco.getClientes().get(i).getCpf() + "\n");
        System.out.print(banco.getContas().get(i).getCredito() + "\n");
        System.out.println(banco.getClientes().get(i).getNumBanco());
    }

    public static void entrarDados(Cliente cliente, Conta conta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("escreva seu name");
        String name = sc.next();
        System.out.println("insira seu cpf");
        String cpf = sc.next();
        System.out.println("insira seu tipo de conta");
        String typeConta = sc.next();
        System.out.println("saldo da conta");
        double saldo = sc.nextDouble();
        cliente.criarCliente(name, typeConta, cpf);
        conta.cadastrarConta(saldo, cliente);
    }

    public static void pagarComCredito(String cpf, int numConta, Banco banco) throws excecoes {
        Conta conta = banco.getConta(numConta, cpf);
        Cliente cliente = banco.getClient(cpf);


        Metodos metodos = new Metodos();
        Scanner input = new Scanner(System.in);

        try {
            metodos.pagar(cliente, conta);
        } catch (excecoes e) {
            System.out.println(e.getMessage());

            System.out.println("Tentar novamente? S/N");
            char c = input.next().charAt(0);
            while ((c != 'N' && c != 'n') && (c != 'S' && c != 's')) {
                System.out.println(e);
                System.out.println("Tentar novamente? S/N");
                c = input.next().charAt(0);
            }

            if (c == 'n' || c == 'N') {
                System.out.println("Sistema fechado");
            } else {
                pagarComCredito(cpf, numConta, banco);
            }

        }

    }
}
