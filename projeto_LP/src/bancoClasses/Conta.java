package bancoClasses;


public class Conta extends Cliente{
	private double saldo;
	private double credito;
	private double saldoCredito = credito;
	
	//getters
	public double getSaldo() {
		return saldo;
	}
	public double getCredito() {
		return credito;
	}
	
	public double getSaldoCredito() {
		return saldoCredito;
	}
	
	//setters
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	public void setSaldoCredito(double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}
	
	public void cadastrarConta(double saldo, Cliente cliente) {
		setSaldo(saldo);
		setCredito(TypeConta.valueOf(cliente.getContaType()).credit());
	}
}
