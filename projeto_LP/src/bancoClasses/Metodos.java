package bancoClasses;

import java.util.Scanner;

public class Metodos {
	public boolean validarCpf(Cliente cliente, String cpf) {
		if(cliente.getCpf().equals(cpf)) {
			return true;
		}
		return false;
	}
	public boolean validarNome(Cliente cliente, String name) {
		if(cliente.getNome().equalsIgnoreCase(name)) {
			return true;
		}
		return false;
	}
	public boolean validarNome(Cliente cliente, int numBanco) {
		if(cliente.getNumBanco() == numBanco) {
			return true;
		}
		return false;
	}
	public void pagar(Conta conta, double valorCompra, int opcao){
		double valorAtual;
		if(opcao == 1) {
			valorAtual = conta.getSaldo()-valorCompra;
			conta.setSaldo(valorAtual);
		}else if(opcao == 2) {
			valorAtual = conta.getSaldoCredito()-valorCompra; 
		}else System.out.println("numero incorreto digite novamente");
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
		conta.cadastrarConta(saldo, typeConta);
	}
	public static void mostrarCliente(Banco banco, int i) {
		
		System.out.print(banco.getClientes().get(i).getContaType()+"\n");
		System.out.print(banco.getClientes().get(i).getCpf()+"\n");
		System.out.print(banco.getContas().get(i).getSaldoCredito()+"\n");
	}
}
