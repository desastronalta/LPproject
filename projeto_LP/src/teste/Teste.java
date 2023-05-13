package teste;

import bancoClasses.*;

import java.util.Scanner;

public class Teste {
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
<<<<<<< Upstream, based on forMerge/main
	public static void mostrarCliente(Banco banco, int i) {
		
		System.out.print(banco.getClientes().get(i).getContaType()+"\n");
		System.out.print(banco.getClientes().get(i).getCpf()+"\n");
		System.out.print(banco.getContas().get(i).getSaldoCredito()+"\n");
	}

=======
>>>>>>> fc3b3f7 *
}
