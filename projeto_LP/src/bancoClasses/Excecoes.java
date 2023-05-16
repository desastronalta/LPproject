package bancoClasses;

public class Excecoes extends Exception {

    private String message;

    public Excecoes(String message) {
        this.message = message;
    }    
    @Override
    public String getMessage() {
        return message;
    }
}
