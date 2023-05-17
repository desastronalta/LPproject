package bancoClasses;

import java.util.Random;
import java.util.Scanner;

public class Metodos {
	public void pagar(Banco banco, double valorCompra, int posicao) throws Excecoes{
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha 1 para pagar no debito ou 2 para pagar com credito.");
		int escolha = sc.nextInt();
			if(escolha == 1) {
				double saldo = banco.getContas().get(posicao).getSaldo();
				 
				 if(saldo < valorCompra) {
					 throw new Excecoes("voce nao possui saldo o suficiente para efetuar a compra. ");
				 }else {
					 banco.getContas().get(posicao).setSaldo(saldo - valorCompra);
				 }
			}
			if(escolha == 2) {
				double saldo = banco.getContas().get(posicao).getSaldoCredito();
				if(saldo < valorCompra) {
					throw new Excecoes("voce nao possui creditos o suficiente para efetuar a compra. ");
				}else {
					banco.getContas().get(posicao).setSaldoCredito(saldo - valorCompra);			
				}
			}else {
				this.pagar(banco, valorCompra, posicao);
			}
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
	
	
	public int searchCliente(String nome, String cpf, int numBanco, Banco banco) {
		int posicao = -1;
		for (int i = 0; i < banco.getClientes().size(); i++) {
            if ( banco.getClientes().get(i).getNome().equals(nome)) {
            	System.out.println("nome encontrado");
                if ( banco.getClientes().get(i).getCpf().compareTo(cpf) == 0) {
                	System.out.println("cpf encontrado");
                    if ( banco.getClientes().get(i).getNumBanco() == numBanco) {
                    	System.out.println("nun banco encontrado");
                       posicao = i;
                       break;
                    }
                }
            }
		}
		return posicao;
	}
	
	
	public static int criarNumBanco() {
		Random rand = new Random();
		int numBanco = rand.nextInt(100, 999);
		return numBanco;
	}
	
	
	public void entraSaldo(Banco banco, int i){
		Scanner sc = new Scanner(System.in);
		System.out.println("insira o valor que sera depositado na conta");
		double valor = sc.nextDouble();
		double saldo = banco.getContas().get(i).getSaldo();
		banco.getContas().get(i).setSaldo(saldo + valor);
	}
	
	
	public void verificarCliente(int posicao) throws Excecoes {

		if(posicao == -1) {
			throw new Excecoes("Os dados nao sao compativeis, tente novamente, ou caso nao tenha cadastro,"
					+ " por favor selecione 'cadastrar cliente.'");
		}
	}

	@SuppressWarnings("finally")
	public boolean validaConta(int posicao) {
		boolean existe = true;
		try {
			verificarCliente(posicao);
		} catch (Excecoes e) {
			System.out.print(e.getMessage()+"\n");
			existe = false;
		}
		finally{
			return existe;
		}
	}
	
}
