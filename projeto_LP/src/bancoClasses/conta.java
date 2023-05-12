package bancoClasses;
import java.util.Random;
public class conta {
	private double saldo;
	private double credito;
	private double numBanco;
	private double saldoCredito;
	
	//getters
	public double getSaldo() {
		return saldo;
	}
	public double getCredito() {
		return credito;
	}
	public double getNumBanco() {
		return numBanco;
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
	public void setNumBanco(double numBanco) {
		this.numBanco = numBanco;
	}
	public void setSaldoCredito(double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}
	
	public void cadastrarConta(double saldo, double saldoCredito) {
		Random rand = new Random();
		setNumBanco(rand.nextInt(500));
		setSaldo(saldo);
		setSaldoCredito(saldoCredito);
		
	}
}
