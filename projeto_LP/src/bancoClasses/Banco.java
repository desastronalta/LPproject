package bancoClasses;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Cliente> clientes;
	//assim que criar o objeto banco irá instanciar uma arraylist junto.
	public Banco() {
		clientes = new ArrayList<Cliente>();
	}
	
	private int numerarCliente(){
		return clientes.size();
	}
	
	public void addClient(Cliente cliente) {
		clientes.add(cliente);
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