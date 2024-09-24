package iphone.navegador;

import java.util.ArrayList;

public class PaginaWeb {
    private String url;
    private String titulo;
    private String conteudo;
    private final ArrayList<String> cookies;

    public PaginaWeb(String url, String titulo, String conteudo) {
        this.url = url;
        this.titulo = titulo;
        this.conteudo = conteudo;
        cookies = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return conteudo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.conteudo = contenido;
    }

    @Override
    public String toString() {
        return "PaginaWeb{" +
                " url='" + url + "',\n"+
                " titulo='" + titulo + "',\n"+
                " contenido='" + conteudo + "'\n" +
                '}';
    }

    public void addCookie(String cookie){
        cookies.add(cookie);
    }

    public void removeCookie(String cookie){
        cookies.remove(cookie);
    }

    public void clearCookies(){
        cookies.clear();
    }

    public ArrayList<String> getCookies(){
        return cookies;
    }

    public boolean hasCookies(){
        return !cookies.isEmpty();
    }

    public boolean hasCookie(String cookie){
        return cookies.contains(cookie);
    }

    public void printCookies(){
        System.out.println("Cookies:[");
        for(String cookie : cookies){
            System.out.print(" {\""+cookie+"\"}");
            if (cookies.indexOf(cookie) != cookies.size()-1)
                System.out.println(",");
            else
                System.out.println();
        }
        System.out.println("]");
    }

    public void print(){
        System.out.println("PaginaWeb{");
        System.out.println(" url='"+url+"'");
        System.out.println(" titulo='"+titulo+"'");
        System.out.println(" conteudo='"+conteudo+"'");
        printCookies();
        System.out.println("}");
    }
}
