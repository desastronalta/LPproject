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
		cliente.setNumBanco(numerarCliente()-1);
	}
	public boolean searchCliente(int numBanco) {
		int i;
		for(i = 0; i<clientes.size()-1; i++) {
			if(clientes.get(i).getNumBanco() == numBanco) {
				return true;
			}
		}
		return false;
	}
}