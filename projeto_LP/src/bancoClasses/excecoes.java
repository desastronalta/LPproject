package bancoClasses;

public class excecoes extends Exception {

    String message;

    public excecoes(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
