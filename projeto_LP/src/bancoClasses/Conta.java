package bancoClasses;


public class Conta {
    private double saldo;
    private double credito;
    private double saldoCredito;

    //getters
    public double getSaldo() {
        return saldo;
    }

    //setters
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(double saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public void cadastrarConta(double saldo, Cliente cliente) {
        setSaldo(saldo);
        setCredito(TypeConta.valueOf(cliente.getContaType()).credit());
        setSaldoCredito(getCredito());
    }
}
