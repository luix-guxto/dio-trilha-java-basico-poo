package iphone;

import iphone.archive.*;
import iphone.galeria.Album;
import iphone.galeria.Galeria;
import iphone.musicas.Musicas;
import iphone.musicas.PlayList;
import iphone.navegador.Aba;
import iphone.navegador.Navegador;
import iphone.navegador.PaginaWeb;
import iphone.reprodutor.ReprodutorDeAudios;
import iphone.telefone.Contato;
import iphone.telefone.Ligacao;
import iphone.telefone.Telefone;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public record Iphone(Galeria galeria, Telefone telefone, InformacoesAparelho informacoesAparelho, Musicas musicas, Navegador navegador) {

    @Override
    public String toString() {
        return "Iphone{" +
                " galeria=" + galeria + ",\n" +
                " telefone=" + telefone + ",\n" +
                " informacoesAparelho=" + informacoesAparelho + ",\n" +
                " musicas=" + musicas + ",\n" +
                " navegador=" + navegador + "\n" +
                '}';
    }

    public void ligar() {
        System.out.println("Ligando...");
    }

    public void desligar() {
        System.out.println("Desligando...");
    }

    public void reiniciar() {
        System.out.println("Reiniciando...");
    }

    public void bloquear() {
        System.out.println("Bloqueando...");
    }

    public void desbloquear() {
        System.out.println("Desbloqueando...");
    }

    public void tirarFoto() {
        System.out.println("Tirando foto...");

        // Verifica se existe o album camera
        if (galeria.getAlbum("Camera") == null) {
            Album album = new Album("Camera");
            galeria.addAlbum(album);
        }

        // Adiciona a foto ao album camera
        FileInformation foto = new FileInformation("jpg", new Random().nextInt(10000)+1, new Date(), "Foto_"+new Date()+"_camera");
        Resolution resolution = new Resolution(1920, 1080);
        ImageFile imageFile = new ImageFile(foto, "/camera/", resolution);
        galeria.addImage(galeria.getAlbum("Camera"), imageFile);
    }

    public void gravarVideo(){
        System.out.println("Gravando video...");

        // Verifica se existe o album camera
        if (galeria.getAlbum("Camera") == null) {
            Album album = new Album("Camera");
            galeria.addAlbum(album);
        }

        // Adiciona o video ao album camera
        FileInformation video = new FileInformation("mp4", new Random().nextInt(10000)+1, new Date(), "Video_"+new Date()+"_camera");
        Resolution resolution = new Resolution(1920, 1080);
        VideoFile videoFile = new VideoFile(video, "/camera/", new Random().nextInt(1000)+1, resolution, 100);
        galeria.addVideo(galeria.getAlbum("Camera"), videoFile);
    }

    public ReprodutorDeAudios tocarMusica(AudioFile musica) {

        //find playlist by music file name
        PlayList playList = musicas.getPlayLists().values().stream()
                .filter(p -> p.getMusics().containsValue(musica))
                .findFirst()
                .orElse(null);
        if(playList == null){
            System.out.println("Musica não encontrada");
            return null;
        }
        return musicas.reproduzirMusica(playList, musica.getInformation().getName());
    }

    public void abrirNavegador(){
        System.out.println("Abrindo navegador...");
        PaginaWeb pagina = new PaginaWeb("https://www.google.com", "Google", "Google");
        navegador.novaAba(pagina);
    }

    public void adicionarAba(){
        System.out.println("Adicionando aba...");
        PaginaWeb pagina = new PaginaWeb("https://www.google.com", "Google", "Google");
        navegador.novaAba(pagina);
    }

    public void adicionarAba(PaginaWeb pagina){
        System.out.println("Adicionando aba...");
        navegador.novaAba(pagina);
    }

    public void adicionarAba(String url, String titulo, String conteudo){
        System.out.println("Adicionando aba...");
        PaginaWeb pagina = new PaginaWeb(url, titulo, conteudo);
        navegador.novaAba(pagina);
    }

    public void fecharAbaNome(String titulo){
        System.out.println("Fechando aba...");
        ArrayList<Aba> paginas = navegador.getAbas();
        for(Aba pagina : paginas){
            if(pagina.getPaginaWeb().getTitulo().equals(titulo)){
                navegador.fecharAba(pagina);
                break;
            }
        }
        System.out.println("Aba não encontrada");
    }

    public void fecharAba(PaginaWeb pagina){
        System.out.println("Fechando aba...");
        navegador.fecharAba(pagina.getUrl());
    }
    public void fecharAba(String url){
        System.out.println("Fechando aba...");
        navegador.fecharAba(url);
    }

    public void abrirMapas(){
        System.out.println("Abrindo mapas...");
        PaginaWeb pagina = new PaginaWeb("https://www.google.com/maps", "Google Maps", "Google Maps");
        navegador.novaAba(pagina);
    }

    public void abrirYoutube(){
        System.out.println("Abrindo youtube...");
        PaginaWeb pagina = new PaginaWeb("https://www.youtube.com", "Youtube", "Youtube");
        navegador.novaAba(pagina);
    }

    public void abrirInstagram(){
        System.out.println("Abrindo instagram...");
        PaginaWeb pagina = new PaginaWeb("https://www.instagram.com", "Instagram", "Instagram");
        navegador.novaAba(pagina);
    }

    public void abrirFacebook(){
        System.out.println("Abrindo facebook...");
        PaginaWeb pagina = new PaginaWeb("https://www.facebook.com", "Facebook", "Facebook");
        navegador.novaAba(pagina);
    }

    public void abrirTwitter(){
        System.out.println("Abrindo twitter...");
        PaginaWeb pagina = new PaginaWeb("https://www.x.com", "Twitter", "Twitter");
        navegador.novaAba(pagina);
    }


    public void abrirWhatsapp(){
        System.out.println("Abrindo whatsapp...");
        PaginaWeb pagina = new PaginaWeb("https://www.whatsapp.com", "Whatsapp", "Whatsapp");
        navegador.novaAba(pagina);
    }

    public void abrirTelegram(){
        System.out.println("Abrindo telegram...");
        PaginaWeb pagina = new PaginaWeb("https://www.telegram.com", "Telegram", "Telegram");
        navegador.novaAba(pagina);
    }

    public void abrirLinkedin(){
        System.out.println("Abrindo linkedin...");
        PaginaWeb pagina = new PaginaWeb("https://www.linkedin.com", "Linkedin", "Linkedin");
        navegador.novaAba(pagina);
    }

    //Telefone
    public void ligar(String numero){
        System.out.println("Ligando para " + numero);
        telefone.ligar(telefone.buscarContato(numero));
    }

    public void adicionarContato(String nome, String numero){
        System.out.println("Adicionando contato...");
        telefone.adicionarContato(new Contato(nome, numero));
    }

    public void removerContato(String nome){
        System.out.println("Removendo contato...");
        telefone.removerContato(nome);
    }

    public void listarContatos(){
        System.out.println("Listando contatos...");
        telefone.getAgenda().listarContatos();
    }

    public void limparAgenda(){
        System.out.println("Limpando agenda...");
        telefone.getAgenda().limparAgenda();
    }

    public void receberLigacao(String nome, String numero){
        System.out.println("Recebendo ligação de " + nome + " (" + numero + ")");
        telefone.receberLigacao(new Contato(nome, numero));
    }

    public void atenderLigacao(String numero){
        HashMap<String, Ligacao> ligacoes = telefone.getLigacoes();
        Ligacao ligacao = ligacoes.get(numero);
        if (ligacao == null) {
            System.out.println("Não há ligação ativa para esse número");
            return;
        }
        System.out.println("Atendendo ligação de " + ligacao.getContato().getNome() + " (" + numero + ")");
        telefone.atender(ligacao.getContato());
    }

    public void recusarLigacao(String numero){
        HashMap<String, Ligacao> ligacoes = telefone.getLigacoes();
        Ligacao ligacao = ligacoes.get(numero);
        if (ligacao == null) {
            System.out.println("Não há ligação ativa para esse número");
            return;
        }
        System.out.println("Recusando ligação de " + ligacao.getContato().getNome() + " (" + numero + ")");
        telefone.recusar(ligacao.getContato());
    }

    public void finalizarLigacao(String numero){
        HashMap<String, Ligacao> ligacoes = telefone.getLigacoes();
        Ligacao ligacao = ligacoes.get(numero);
        if (ligacao == null) {
            System.out.println("Não há ligação ativa para esse número");
            return;
        }
        System.out.println("Finalizando ligação de " + ligacao.getContato().getNome() + " (" + numero + ")");
        telefone.desligar(ligacao.getContato().getTelefone());
    }

/*.......*/

}
