package teste;
import java.util.Scanner;
import bancoClasses.*;

public class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		Banco banco = new Banco();
		Conta conta1 = new Conta();
		Cliente cliente2 = new Cliente();
		Conta conta2 = new Conta();
		entrarDados(cliente1, conta1);
		System.out.print("\n\n");
		entrarDados(cliente2, conta2);
		banco.addClient(cliente1, conta1);
		banco.addClient(cliente2, conta2);
			
		for(int i= 0; i < banco.getClientes().size();i++) {
			mostrarCliente(banco,i);
		}
		
	sc.close();
	}
	public static void mostrarCliente(Banco banco, int i) {
		
		System.out.print(banco.getClientes().get(i).getContaType()+"\n");
		System.out.print(banco.getClientes().get(i).getCpf()+"\n");
		System.out.print(banco.getContas().get(i).getSaldoCredito()+"\n");
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
}
