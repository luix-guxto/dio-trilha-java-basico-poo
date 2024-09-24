package iphone.navegador;

import java.util.ArrayList;

public class Navegador {

    private final ArrayList<Aba> abas;
    private final HistoricoNavegacao historicoNavegacao;

    public Navegador() {
        abas = new ArrayList<>();
        historicoNavegacao = new HistoricoNavegacao();
    }

    public void novaAba(PaginaWeb paginaWeb){
        Aba aba = new Aba(paginaWeb);
        abas.add(aba);
    }

    public void fecharAba(int index){
        abas.remove(index);
    }

    public void fecharAba(Aba aba){
        abas.remove(aba);
    }

    public void fecharTodasAbas(){
        abas.clear();
    }

    public void fecharAba(String url){
        for (Aba aba : abas) {
            if(aba.getPaginaWeb().getUrl().equals(url)){
                abas.remove(aba);
                break;
            }
        }
    }

    public void fecharAba(PaginaWeb paginaWeb){
        for (Aba aba : abas) {
            if(aba.getPaginaWeb().equals(paginaWeb)){
                abas.remove(aba);
                break;
            }
        }
    }

    public void adicionarPaginaHistorico(PaginaWeb paginaWeb){
        historicoNavegacao.adicionarPagina(paginaWeb);
    }

    public void removerPaginaHistorico(PaginaWeb paginaWeb){
        historicoNavegacao.removerPagina(paginaWeb);
    }

    public void removerPaginaHistorico(String URL){
        historicoNavegacao.removerPagina(URL);
    }

    public void limparHistorico(){
        historicoNavegacao.limparHistorico();
    }

    public ArrayList<Aba> getAbas() {
        return abas;
    }

    public HistoricoNavegacao getHistoricoNavegacao() {
        return historicoNavegacao;
    }

    public void showAba(int index){
        Aba aba = abas.get(index);
        System.out.println("Aba: " + aba.getPaginaWeb().getTitulo());
        System.out.println(aba.getPaginaWeb());
    }

    public void showHistorico(){
        System.out.println(historicoNavegacao);
    }

}
