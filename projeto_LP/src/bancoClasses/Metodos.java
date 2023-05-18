package bancoClasses;

import java.util.InputMismatchException;
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
				 }
				 else {
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
			}
	}
	
	
	public static void entrarDados(Cliente cliente, Conta conta) throws InputMismatchException  {
			Scanner sc = new Scanner(System.in);
			String name = null;
			String cpf = null;
			String typeConta = null;
			boolean verificacao = false;
				try {
					System.out.println("Digite seu nome");
					name = sc.next();
					System.out.println("Insira seu cpf");
					cpf = sc.next();
					System.out.println("Insira seu tipo de conta");
					typeConta = sc.next();
					System.out.println("Saldo da conta");
				}catch(InputMismatchException e) {
					throw new InputMismatchException("Erro ao ler os dados. por favor digite novamente.");
				}
			
			double saldo = sc.nextDouble();
			cliente.criarCliente(name, typeConta, cpf);
			conta.cadastrarConta(saldo,  cliente);
			System.out.println("Seu numero bancario é: " + cliente.getNumBanco());
	}
	
	
	public static void mostrarCliente(Banco banco, int i) {
		System.out.print("\n\n====================================================\n");
		System.out.print("Nome :"+banco.getClientes().get(i).getNome()+"\n");
		System.out.print("Rank da conta :"+banco.getClientes().get(i).getContaType()+"\n");
		System.out.print("CPF :"+banco.getClientes().get(i).getCpf()+"\n");
		System.out.print("Credito :"+banco.getContas().get(i).getSaldoCredito()+"\n");
		System.out.print("Saldo :"+banco.getContas().get(i).getSaldo()+"\n");
		System.out.print("N.Bancario :"+banco.getClientes().get(i).getNumBanco()+"\n");
		System.out.print("======================================================\n\n");
	}
	
	
	public int searchCliente(String nome, String cpf, int numBanco, Banco banco) {
		int posicao = -1;
		for (int i = 0; i < banco.getClientes().size(); i++) {
            if ( banco.getClientes().get(i).getNome().equals(nome)) {
            	
                if ( banco.getClientes().get(i).getCpf().compareTo(cpf) == 0) {
                
                    if ( banco.getClientes().get(i).getNumBanco() == numBanco) {
                    
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
			throw new Excecoes("Os dados nao sao compativeis, tente novamente.\nCaso nao tenha cadastro,"
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
