package bancoClasses;

import java.util.Random;
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
	public boolean validarNumBanco(Cliente cliente, int numBanco) {
		if(cliente.getNumBanco() == numBanco) {
			return true;
		}
		return false;
	}
	public void pagar(Conta conta, double valorCompra, int opcao){
		if(opcao == 1) {
			conta.setSaldo(conta.getSaldo()-valorCompra);
		}else if(opcao == 2) {
			conta.setCredito(conta.getCredito()-valorCompra);
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
		conta.cadastrarConta(saldo,  cliente);
		System.out.println("seu numero bancario é: " + cliente.getNumBanco());
	}
	
	
	public static void mostrarCliente(Banco banco, int i) {
		System.out.print("nome :"+banco.getClientes().get(i).getNome()+"\n");
		System.out.print("Rank da conta :"+banco.getClientes().get(i).getContaType()+"\n");
		System.out.print("CPF :"+banco.getClientes().get(i).getCpf()+"\n");
		System.out.print("Credito :"+banco.getContas().get(i).getSaldoCredito()+"\n");
		System.out.print("N.Bancario :"+banco.getClientes().get(i).getNumBanco()+"\n");
	}
	
	
	public boolean searchCliente(String nome, String cpf, int numBanco, Banco banco) {
		boolean achou = true;
		for (int i = 0; i < banco.getClientes().size(); i++) {
            if ( banco.getClientes().get(i).getNome().equals(nome)) {
                if ( banco.getClientes().get(i).getCpf().equals(cpf)) {
                    if ( banco.getClientes().get(i).getNumBanco() == numBanco) {
                       achou = false;
                       break;
                    }
                }
            } 
		}
		return achou;
	}
	
	
	public static int criarNumBanco() {
		Random rand = new Random();
		int numBanco = rand.nextInt(100, 999);
		return numBanco;
	}
	
	
	public void entraSaldo(double valor, Conta conta){
		conta.setSaldo(conta.getSaldo() + valor);
	}
	
	
	public void verificarCliente(Banco banco, String cpf, String nome, int numBanco) throws Excecoes {
		Metodos metodo = new Metodos();
		if(!metodo.searchCliente(nome, cpf, numBanco, banco)) {
			throw new Excecoes("Os dados nao sao compativeis, tente novamente, ou caso nao tenha cadastro,"
					+ " por favor selecione 'cadastrar cliente.'");
		}
	}
}
