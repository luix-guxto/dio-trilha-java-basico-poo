package iphone.musicas;

import iphone.reprodutor.Reprodutor;
import iphone.reprodutor.ReprodutorDeAudios;

import java.util.HashMap;

public class Musicas {
    private final HashMap<String, PlayList> playLists;

    public Musicas() {
        playLists = new HashMap<>();
    }

    public void addPlayList(PlayList playList) {
        playLists.put(playList.getName(), playList);
    }

    public void removePlayList(String name) {
        playLists.remove(name);
    }

    public PlayList getPlayList(String name) {
        return playLists.get(name);
    }

    public ReprodutorDeAudios reproduzirMusica(PlayList playList, String file) {
        return new ReprodutorDeAudios(playList.getMusic(file));
    }

    public void listarPlayLists() {
        for (PlayList playList : playLists.values()) {
            System.out.println(playList);
        }
    }

    public void listarMusicas() {
        for (PlayList playList : playLists.values()) {
            playList.listarMusicas();
        }
    }

    public void listarMusicas(String playList) {
        playLists.get(playList).listarMusicas();
    }

    public HashMap<String, PlayList> getPlayLists() {
        return playLists;
    }
}
