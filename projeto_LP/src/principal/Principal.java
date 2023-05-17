package principal;
import bancoClasses.*;

public class Principal {

	public static void main(String[] args) throws Excecoes {
		Banco banco = new Banco();
		Interface janela = new Interface();
		janela.start(banco);
	}
}
