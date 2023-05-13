package teste;

import bancoClasses.*;

import java.util.Scanner;

public class Teste {
   public static void pagarComCredito(String cpf, int numConta, Banco banco) throws excecoes {
        Conta conta = banco.getConta(numConta, cpf);
        Cliente cliente = banco.getClient(cpf);


        Metodos metodos = new Metodos();
        Scanner input = new Scanner(System.in);

        metodos.pagar(conta, 100, 1);

    }

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		Banco banco = new Banco();
		Conta conta1 = new Conta();
		Cliente cliente2 = new Cliente();
		Conta conta2 = new Conta();
		Metodos.entrarDados(cliente1, conta1);
		banco.addClient(cliente1, conta1);
			
		for(int i= 0; i < banco.getClientes().size();i++) {
			Metodos.mostrarCliente(banco,i);
		}
		
	sc.close();
	}
	public static void mostrarCliente(Banco banco, int i) {
		
		System.out.print(banco.getClientes().get(i).getContaType()+"\n");
		System.out.print(banco.getClientes().get(i).getCpf()+"\n");
		System.out.print(banco.getContas().get(i).getSaldoCredito()+"\n");
		System.out.print(banco.getContas().get(i).getSaldo()+"\n");
	}

}
