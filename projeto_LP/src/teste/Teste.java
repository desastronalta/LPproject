package teste;

import bancoClasses.*;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Metodos metodo = new Metodos();
		Scanner sc = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		Banco banco = new Banco();
		Conta conta1 = new Conta();
		Cliente cliente2 = new Cliente();
		Conta conta2 = new Conta();
		Metodos.entrarDados(cliente1, conta1);
		Metodos.entrarDados(cliente2, conta2);
		banco.addClient(cliente1, conta1);
		banco.addClient(cliente2, conta2);
		System.out.println("Para acessar a conta informe os dados a seguir");
		System.out.println("Numero bancario");
		int numBanco = sc.nextInt();
		System.out.println("nome:");
		String nome = sc.next();
		String cpf = sc.next();
		boolean existe = true;
		try {
			metodo.verificarCliente(banco, nome, cpf, numBanco);
		} catch (Excecoes e) {
			System.out.print(e.getMessage()+"\n");
			existe = false;
		}
		finally{
			if(existe) {
				System.out.println("logado");
				
			}else System.out.println("tente novamente ou cadastre-se");
		}
	sc.close();
	}

}
