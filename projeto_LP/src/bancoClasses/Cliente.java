package bancoClasses;

public class Cliente {
	private String nome;
	private String contaType;
	private int saldo;
	private int credito;
	private int numBanco;
	private Banco banco;
	//metodos getters
	public String getNome() {
		return nome;
	}
	public String getContaType() {
		return contaType;
	}
	public int getSaldo() {
		return saldo;
	}
	public int getCredito() {
		return credito;
	}
	public int getNumBanco() {
		return numBanco;
	}
	
	//métodos setter 
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setContaType(String contaType) {
		this.contaType = contaType;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public void setCredito(int credito) {
		this.credito = credito;
	}
	public void setNumBanco(int numBanc) {
		this.numBanco = numBanc;
	}
	public void criarCliente(String nome, String contaType, int saldo, int credito) {
		setNome(nome);
		setContaType(contaType);
		setSaldo(saldo);
		setCredito(credito);
	}
}
