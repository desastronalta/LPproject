package bancoClasses;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    //assim que criar o objeto banco irá instanciar uma arraylist junto.
    public Banco() {
        clientes = new ArrayList<Cliente>();
        contas = new ArrayList<Conta>();
    }


    public void addClient(Cliente cliente, Conta conta) {
        clientes.add(cliente);
        contas.add(conta);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getClient(String cpf) throws Excecoes {

        Cliente cliente = clientes.stream().filter(clienteIn ->
                        cpf.equals(clienteIn.getCpf())).
                findFirst().orElse(null);

        if (cliente == null) {
            throw new Excecoes("Cliente não cadastrado");
        }
        return cliente;
    }

    public Conta getConta(int numBanco, String cpf) throws Excecoes {

        Conta conta = contas.stream().filter(contaIn ->
                {
                    try {
                        return numBanco == getClient(cpf).getNumBanco();
                    } catch (Excecoes e) {
                        System.out.println(e.getMessage());
                    }
                    return false;
                })
                .findFirst().orElse(null);
        if (conta == null) {
            throw new Excecoes("Conta não encontrada");
        }

        return conta;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void excluirConta(String nome, String cpf, int numBanco) {

        //contas.removeIf(conta ->  getClient(cpf).getNumBanco() == numBanco);

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nome)) {
                if (clientes.get(i).getCpf().equals(cpf)) {
                    if (clientes.get(i).getNumBanco() == numBanco) {
                        clientes.remove(i);
                        contas.remove(i);
                    }
                }
            }
        }
    }
}
	