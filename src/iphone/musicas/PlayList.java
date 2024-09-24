package iphone.musicas;

import iphone.archive.AudioFile;

import java.util.TreeMap;

public class PlayList {
    private final TreeMap<String, AudioFile> playList;
    private String name;

    public PlayList(String name) {
        this.name = name;
        playList = new TreeMap<>();
    }

    public void addMusic(AudioFile file) {
        playList.put(file.getInformation().getName(), file);
    }

    public void removeMusic(String name) {
        playList.remove(name);
    }

    public AudioFile getMusic(String name) {
        return playList.get(name);
    }

    public TreeMap<String, AudioFile> getMusics() {
        return playList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void listarMusicas() {
        for (AudioFile file : playList.values()) {
            System.out.println(file);
        }
    }
}
