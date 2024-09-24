package iphone.telefone;

import iphone.archive.AudioFile;
import iphone.archive.FileInformation;

import java.util.*;

public class Telefone {
    private String numero;
    private final CaixaDeVoz caixaDeVoz;
    private final HashMap<String, Ligacao> ligacoes;
    private Agenda agenda;

    public Telefone(String numero) {
        this.numero = numero;
        caixaDeVoz = new CaixaDeVoz();
        ligacoes = new HashMap<>();
    }

    public void adicionarContato(Contato contato) {
        agenda.adicionarContato(contato);
    }

    public void removerContato(String nome) {
        agenda.removerContato(nome);
    }

    public Contato buscarContato(String nome) {
        return agenda.buscarContato(nome);
    }

    public void limparAgenda() {
        agenda.limparAgenda();
    }

    public void setContatos(HashMap<String, Contato> contatos) {
        agenda.setContatos(contatos);
    }

    public void removerContato(Contato contato) {
        agenda.removerContato(contato);
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }
    public void ligar(Contato contato) {
        Ligacao ligacao = new Ligacao(contato);
        ligacoes.put(contato.getTelefone(), ligacao);
        System.out.println("Ligando para " + contato.getNome());
    }

    public void ligar(String name, String number) {
        Contato contato = new Contato(name, number);
        ligar(contato);
    }

    public void desligar(String number) {
        Ligacao ligacao = ligacoes.get(number);
        if (ligacao != null) {
            ligacao.finalizar();
            System.out.println("Desligando de " + ligacao.getContato().getNome());
        } else {
            System.out.println("Não há ligação ativa para esse número");
        }
    }

    public void desligar(Contato contato) {
        desligar(contato.getTelefone());
    }

    public void receberLigacao(Contato contato) {
        Ligacao ligacao = new Ligacao(contato);
        ligacoes.put(contato.getTelefone(), ligacao);
        System.out.println("Recebendo ligação de " + contato.getNome());
    }

    public void receberLigacao(String name, String number) {
        Contato contato = new Contato(name, number);
        receberLigacao(contato);
    }

    public void atender(String number) {
        Ligacao ligacao = ligacoes.get(number);
        if (ligacao != null) {
            ligacao.atender();
        } else {
            System.out.println("Não há ligação ativa para esse número");
        }
    }

    public void atender(Contato contato) {
        atender(contato.getTelefone());
    }

    public void recusar(String number) {
        Ligacao ligacao = ligacoes.get(number);
        if (ligacao != null) {
            ligacao.recusar();
            final FileInformation fileInformation = new FileInformation("wav", new Random().nextInt(1000), new Date(),"Chamada recusada de: " + ligacao.getContato().getNome()+" - "+ligacao.getContato().getTelefone());
            final AudioFile audioFile = new AudioFile(fileInformation, "/correiosDeVoz/", new Random().nextInt(10000), 100);
            caixaDeVoz.adicionarCorreioDeVoz(new CorreioDeVoz(audioFile, ligacao.getContato()));
        } else {
            System.out.println("Não há ligação ativa para esse número");
        }
    }

    public void recusar(Contato contato) {
        recusar(contato.getTelefone());
    }

    public void chamadaPerdida(String number) {
        Ligacao ligacao = ligacoes.get(number);
        if (ligacao != null) {
            if (!ligacao.isAtendida()) {
                System.out.println("Chamada perdida de " + ligacao.getContato().getNome());
                final FileInformation fileInformation = new FileInformation("wav", new Random().nextInt(1000), new Date(),"Chamada perdida de: " + ligacao.getContato().getNome()+" - "+ligacao.getContato().getTelefone());
                final AudioFile audioFile = new AudioFile(fileInformation, "/correiosDeVoz/", new Random().nextInt(10000), 100);
                caixaDeVoz.adicionarCorreioDeVoz(new CorreioDeVoz(audioFile, ligacao.getContato()));
            }
        } else {
            System.out.println("Não há ligação ativa para esse número");
        }
    }

    public void chamadaPerdida(Contato contato) {
        chamadaPerdida(contato.getTelefone());
    }

    private void ouvirCorreioDeVoz(CorreioDeVoz correioDeVoz) {
        caixaDeVoz.ouvirCorreioDeVoz(correioDeVoz);
    }

    public void ouvirCorreioDeVoz(String number) {
        CorreioDeVoz correioDeVoz = caixaDeVoz.getCorreiosDeVoz().stream().filter(correio -> correio.contato().getTelefone().equals(number)).findFirst().orElse(null);
        if (correioDeVoz != null) {
            ouvirCorreioDeVoz(correioDeVoz);
        } else {
            System.out.println("Não há correio de voz para esse número");
        }
    }

    public void ouvirCorreioDeVoz(Contato contato) {
        ouvirCorreioDeVoz(contato.getTelefone());
    }

    public void listarCorreiosDeVoz() {
        caixaDeVoz.listarCorreiosDeVoz();
    }

    public void listarContatos() {
        agenda.listarContatos();
    }

    public void listarLigacoes() {
        for (Ligacao ligacao : ligacoes.values()) {
            System.out.println(ligacao);
        }
    }

    public void limparCorreiosDeVoz() {
        caixaDeVoz.limparCorreiosDeVoz();
    }

    public void limparLigacoes() {
        ligacoes.clear();
    }
    public HashMap<String, Ligacao> getLigacoes() {
        return ligacoes;
    }
}
