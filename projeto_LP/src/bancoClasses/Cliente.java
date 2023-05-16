package bancoClasses;

import java.util.Random;

public class Cliente {
	private String nome;
	private String contaType;
	private String cpf;
	private int numBanco;
	
	
	
	//getter's methods
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getContaType() {
		return contaType;
	}
	public int getNumBanco() {
		return numBanco;
	}
	
	//setter's methods
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setContaType(String contaType) {
		this.contaType = contaType;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNumBanco(int numBanco) {
		this.numBanco = numBanco;
	}
	public void criarCliente(String nome, String contaType, String cpf ) {
		
		setNome(nome);
		setContaType(contaType);
		setCpf(cpf);
		setNumBanco(Metodos.criarNumBanco());
	}
}
