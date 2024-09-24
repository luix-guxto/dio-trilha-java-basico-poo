package iphone.navegador;

public class Aba{
    private PaginaWeb paginaWeb;

    public Aba(PaginaWeb paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public PaginaWeb getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(PaginaWeb paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
