package iphone.telefone;

import java.util.HashMap;

public class Agenda {
    private final HashMap<String, Contato> contatos;

    public Agenda() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.put(contato.getNome(), contato);
    }

    public void removerContato(String nome) {
        contatos.remove(nome);
    }

    public Contato buscarContato(String nome) {
        return contatos.get(nome);
    }

    public void listarContatos() {
        for (Contato contato : contatos.values()) {
            System.out.println(contato);
        }
    }

    public void limparAgenda() {
        contatos.clear();
    }

    public HashMap<String, Contato> getContatos() {
        return contatos;
    }

    public void setContatos(HashMap<String, Contato> contatos) {
        this.contatos.clear();
        this.contatos.putAll(contatos);
    }

    @Override
    public String toString() {
        StringBuilder agendaString = new StringBuilder();
        for(int i = 0; i < contatos.size(); i++) {
            Contato contato = (Contato) contatos.values().toArray()[i];
            String contatoString = "{\n"+contato+"\n}";
            if (i != contatos.size()-1)
                contatoString += ",";
            agendaString.append(contatoString).append("\n");
        }
        return agendaString.toString();
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato.getNome());
    }
}
