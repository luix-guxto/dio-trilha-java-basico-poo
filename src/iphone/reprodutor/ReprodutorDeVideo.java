package iphone.reprodutor;

import iphone.archive.Resolution;
import iphone.archive.VideoFile;

public class ReprodutorDeVideo extends Reprodutor{
    public ReprodutorDeVideo(VideoFile file) {
        super(file);
    }


    @Override
    public void open() {
        System.out.println("Vídeo " + super.getActFile().getInformation().getName() + " aberto");
    }

    @Override
    public void close() {
        System.out.println("Vídeo " + super.getActFile().getInformation().getName() + " fechado");
    }

    public void next(VideoFile f) {
        super.next(f);
        System.out.println("Próximo vídeo");
    }

    public void previous() {
        super.previous();
        System.out.println("Vídeo anterior");
    }

    public void play() {
        System.out.println("Vídeo " + super.getActFile().getInformation().getName() + " reproduzido");
    }

    public void pause() {
        System.out.println("Vídeo " + super.getActFile().getInformation().getName() + " pausado");
    }

    public void stop() {
        System.out.println("Vídeo " + super.getActFile().getInformation().getName() + " parado");
    }

    public void changeVolume(int volume) {
        VideoFile f = ((VideoFile) super.getActFile());
        f.setVolume(volume);
        super.setActFile(f);
        System.out.println("Volume do vídeo " + super.getActFile().getInformation().getName() + " alterado para " + volume);
    }

    public int getVolume() {
        return ((VideoFile) super.getActFile()).getVolume();
    }

    public String getDuration() {
        int duration = ((VideoFile) super.getActFile()).getDuration();
        int hours = duration / 3600;
        int minutes = (duration % 3600) / 60;
        int seconds = duration % 60;
        return hours + "h" + minutes + "m" + seconds + "s";
    }

    public void changeResolution(int width, int height) {
        VideoFile f = ((VideoFile) super.getActFile());
        f.setResolution(new Resolution(width, height));
        super.setActFile(f);
        System.out.println("Resolução do vídeo " + super.getActFile().getInformation().getName() + " alterada");
    }

    public void changeResolution(Resolution resolution) {
        VideoFile f = ((VideoFile) super.getActFile());
        f.setResolution(resolution);
        super.setActFile(f);
        System.out.println("Resolução do vídeo " + super.getActFile().getInformation().getName() + " alterada");
    }

}
