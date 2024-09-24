package iphone.navegador;

import java.util.ArrayList;

public class HistoricoNavegacao {
    private final ArrayList<PaginaWeb> historico;

    public HistoricoNavegacao() {
        historico = new ArrayList<>();
    }

    public void adicionarPagina(PaginaWeb pagina) {
        historico.add(pagina);
    }

    public void removerPagina(PaginaWeb pagina) {
        historico.remove(pagina);
    }

    public void removerPagina(String URL) {
        historico.removeIf(pagina -> pagina.getUrl().equals(URL));
    }

    public void limparHistorico() {
        historico.clear();
    }

    @Override
    public String toString() {
        StringBuilder historicoString = new StringBuilder();
        for (PaginaWeb pagina : historico) {
            String paginaString = "{\n"+pagina+"\n}";
            if (historico.indexOf(pagina) != historico.size()-1)
                paginaString += ",";
            historicoString.append(paginaString).append("\n");
        }
        return historicoString.toString();
    }

    public ArrayList<PaginaWeb> getHistorico() {
        return historico;
    }
}
