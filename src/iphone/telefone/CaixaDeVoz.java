package iphone.telefone;

import java.util.ArrayList;

public class CaixaDeVoz {
    private final ArrayList<CorreioDeVoz> correiosDeVoz;

    public CaixaDeVoz() {
        correiosDeVoz = new ArrayList<>();
    }

    public void adicionarCorreioDeVoz(CorreioDeVoz correioDeVoz) {
        correiosDeVoz.add(correioDeVoz);
    }

    public void removerCorreioDeVoz(CorreioDeVoz correioDeVoz) {
        correiosDeVoz.remove(correioDeVoz);
    }

    public void removerCorreioDeVoz(String numero) {
        correiosDeVoz.removeIf(correioDeVoz -> correioDeVoz.contato().getTelefone().equals(numero));
    }

    public void removerCorreioDeVoz(Contato contato) {
        correiosDeVoz.removeIf(correioDeVoz -> correioDeVoz.contato().equals(contato));
    }

    public void removerCorreioDeVozNome(String nome) {
        correiosDeVoz.removeIf(correioDeVoz -> correioDeVoz.contato().getNome().equals(nome));
    }

    public void limparCorreiosDeVoz() {
        correiosDeVoz.clear();
    }

    public ArrayList<CorreioDeVoz> getCorreiosDeVoz() {
        return correiosDeVoz;
    }

    @Override
    public String toString() {
        StringBuilder correiosDeVozString = new StringBuilder();
        for (CorreioDeVoz correioDeVoz : correiosDeVoz) {
            String correioDeVozString = "{\n"+correioDeVoz+"\n}";
            if (correiosDeVoz.indexOf(correioDeVoz) != correiosDeVoz.size()-1)
                correioDeVozString += ",";
            correiosDeVozString.append(correioDeVozString).append("\n");
        }
        return correiosDeVozString.toString();
    }

    public void ouvirCorreioDeVoz(CorreioDeVoz correioDeVoz) {
        System.out.println("Ouvindo Correio de Voz de " + correioDeVoz.contato().getNome());
        System.out.println(correioDeVoz.ouvir());
    }

    public void listarCorreiosDeVoz() {
        for (CorreioDeVoz correioDeVoz : correiosDeVoz) {
            System.out.println(correioDeVoz);
        }
    }
}
