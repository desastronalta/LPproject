package bancoClasses;

import java.util.Scanner;
public class Interface {
	

	
	public void start(Banco banco) throws Excecoes {
		Scanner sc = new Scanner(System.in);
		int choose;
		System.out.println("Bem vindo(a)!");
        System.out.println("=====================================================");
        System.out.println(" INICIO:\n       Opção 1: Login | Opção 2: Cadastrar     ");
        System.out.println("=====================================================");
        choose = sc.nextInt();
        try {
        	verificaEscolha(choose);
        }catch(Excecoes e) {
        	System.out.println("Falha: " + e.getMessage());
        	start(banco);
        }finally {
        	if(choose == 1) {
        		login(banco);
        	}else if(choose == 2) {
        		cadastro(banco);
        	}
        }
	}
	
	public static void verificaEscolha(int choose) throws Excecoes {
		if(choose != 1 && choose != 2) {
			throw new Excecoes("Numero invalido. Escolha entre as opcoes 1 e 2.");
		}
	}
	
	public void login(Banco banco) throws Excecoes {
		Metodos metod = new Metodos();
		Scanner sc = new Scanner(System.in); 
		System.out.println("=====================================================");
        System.out.println("  LOGIN: \n "
        		+ "                  Insira o CPF:         ");
        System.out.println("=====================================================");
        String cpf = sc.next();
        
        System.out.println("=====================================================");
        System.out.println("                Insira o N.Bancario:         ");
        System.out.println("=====================================================");
        int numBanc = sc.nextInt();
        
        System.out.println("=====================================================");
        System.out.println("                  Insira seu NOME:         ");
        System.out.println("=====================================================");
        String nome = sc.next();
        boolean existe = true;
        int posicao = 0;
		try {
			metod.verificarCliente(banco, nome, cpf, numBanc, posicao);
		} catch (Excecoes e) {
			System.out.print(e.getMessage()+"\n");
			existe = false;
		}
		finally{
			if(existe) {
				System.out.println("logado");
				logar(banco, posicao);
			}else {
				System.out.println("tente novamente ou cadastre-se");
				start(banco);
			}
		}
	}
	
	public void cadastro(Banco banco) throws Excecoes {
		Cliente novoCliente = new Cliente();
		Conta novaConta = new Conta();
		System.out.println("=====================================================");
        System.out.println("  CADASTRO: \n "
        		+ "        Insira os dados requisitados abaixo:         \n"
        		+ "!!!Lembre-se de guardar o número fornecido pelo Banco!!!");
        System.out.println("=====================================================");
		Metodos.entrarDados(novoCliente, novaConta);
		banco.addClient(novoCliente, novaConta);
		System.out.println("Cadastro realizado com sucesso!");
		this.start(banco);
	}
	public void logar(Banco banco, int posicao) throws Excecoes {
		Metodos metod = new Metodos();
		Scanner sc = new Scanner(System.in);
		System.out.println("aperte 0 para sair.");
		System.out.println("aperte 1 para efetuar um pagamento.");
		System.out.println("aperte 2 para ver as inforacoes da conta.");
		System.out.println("aperte 3 para colocar dinheiro da conta.");
		int escolha = sc.nextInt();
		switch (escolha){
			case 0:
				System.out.println("Indo para a tela de inicio");
				start(banco);
			case 1:
				System.out.println("insira o valor da compra...");
				double valorCompra = sc.nextDouble();
				try {
					metod.pagar(banco, valorCompra, posicao);
				}catch(Excecoes e) {
					System.out.println("Falha: " + e.getMessage());
					this.logar(banco, posicao);
				}
			case 2:
				Metodos.mostrarCliente(banco, posicao);
			
			case 3:
				metod.entraSaldo(banco, posicao);
			default:
				System.out.println("o numero digitado nao e uma opcao tente novamente.");
				this.logar(banco, posicao);
		}	
	}
}
