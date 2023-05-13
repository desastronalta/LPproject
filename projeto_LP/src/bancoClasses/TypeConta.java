package bancoClasses;
public enum TypeConta {
    light (300),
    bronze (1000),
    gold (2500),
    Platinum(5000),
    black(10000),
    infinite (1.0/0.0);

    private final double credit;
    TypeConta(double credit){
        this.credit = credit;
    }
    public double credit(){return credit;}
}