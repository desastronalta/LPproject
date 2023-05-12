package bancoClasses;

public class Cliente {
	private String nome;
	private String contaType;
	private String cpf;
	
	
	
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
	
	public void criarCliente(String nome, String contaType, String cpf ) {
		setNome(nome);
		setContaType(contaType);
		setCpf(cpf);
	}
}
