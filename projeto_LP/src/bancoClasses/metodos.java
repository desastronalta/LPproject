package bancoClasses;

public class metodos {
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
}
