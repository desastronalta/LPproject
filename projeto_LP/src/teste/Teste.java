package teste;
import java.util.Scanner;
import bancoClasses.*;

public class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		Banco banco = new Banco();
		Conta conta1 = new Conta();
		Cliente clinte2 = new Cliente();
		Conta conta2 = new Conta();
		for(int i= 0; i < banco.getClientes().size();i++) {
			System.out.println("escreva seu name");
			String name = sc.next();
			System.out.println("insira seu cpf");
			String cpf = sc.next();
			System.out.println("insira seu tipo de conta");
			String typeConta = sc.next();
			System.out.println();
			double saldo = sc.nextDouble();
			TypeConta.light.credit();
			banco.getClientes().get(i).criarCliente(name, typeConta, cpf);
			banco.getContas().get(i).cadastrarConta(saldo);
		}
		for(int i= 0; i < banco.getClientes().size();i++) {
			mostrarCliente(banco,i);
		}
		
	sc.close();
	}
	public static void mostrarCliente(Banco banco, int i) {
		System.out.println(banco.getClientes().get(i).getContaType());
		System.out.println(banco.getClientes().get(i).getCpf());
	}
}
