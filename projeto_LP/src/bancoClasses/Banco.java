package bancoClasses;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Cliente> clientes;
	private ArrayList<Conta> contas;
	//assim que criar o objeto banco irá instanciar uma arraylist junto.
	public Banco() {
		clientes = new ArrayList<Cliente>();
		contas = new ArrayList<Conta>();
	}
	
	
	public void addClient(Cliente cliente, Conta conta) {
		clientes.add(cliente);
		contas.add(conta);
	}
	
	public void excluirConta(String nome, String cpf, int numBanco) {
		for(int i = 0; i < clientes.size();i++) {
			if(clientes.get(i).getNome().equals(nome)) {
				if(clientes.get(i).getCpf().equals(cpf)) {
					if(clientes.get(i).getNumBanco() == numBanco){
						clientes.remove(i);
						contas.remove(i);
					}
				}
			}
		}
	}
	
	public boolean searchCliente(String cpf) {
		int i;
		for(i = 0; i<clientes.size()-1; i++) {
			if(clientes.get(i).getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
}