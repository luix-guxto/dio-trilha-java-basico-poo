package iphone.galeria;
import iphone.archive.ImageFile;
import iphone.archive.VideoFile;
import iphone.reprodutor.Reprodutor;
import iphone.reprodutor.ReprodutorDeVideo;
import iphone.reprodutor.VisualizadorDeImagens;

import java.util.HashMap;

public class Galeria {
    private final HashMap<String, Album> albums;

    public Galeria(HashMap<String, Album> albums) {
        this.albums = albums;
    }

    public Galeria() {
        this.albums = new HashMap<>();
    }

    public void addAlbum(Album album) {
        albums.put(album.getName(), album);
    }

    public void removeAlbum(String name) {
        albums.remove(name);
    }

    public Album getAlbum(String name) {
        return albums.get(name);
    }

    public HashMap<String, Album> getAlbums() {
        return albums;
    }

    public Reprodutor reproduzirImagem(Album album, String file) {
        ImageFile image = (ImageFile) album.getFile(file);
        return new VisualizadorDeImagens(image);
    }

    public void addImage(Album album, ImageFile image) {
        album.addFile(image);
    }

    public void removeImage(Album album, String name) {
        album.removeFile(name);
    }

    public Reprodutor reproduzirVideo(Album album, String file) {
        VideoFile video = (VideoFile) album.getFile(file);
        return new ReprodutorDeVideo(video);
    }

    public void addVideo(Album album, VideoFile video) {
        album.addFile(video);
    }

    public void removeVideo(Album album, String name) {
        album.removeFile(name);
    }
}
