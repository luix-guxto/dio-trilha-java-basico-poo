package iphone.reprodutor;

import iphone.archive.AudioFile;

public class ReprodutorDeAudios extends Reprodutor{
    public ReprodutorDeAudios(AudioFile file) {
        super(file);
    }

    @Override
    public void open() {
        System.out.println("Áudio " + super.getActFile().getInformation().getName() + " aberto");
    }

    @Override
    public void close() {
        System.out.println("Áudio " + super.getActFile().getInformation().getName() + " fechado");
    }

    public void next(AudioFile f) {
        super.next(f);
        System.out.println("Próximo áudio");
    }

    public void previous() {
        super.previous();
        System.out.println("Áudio anterior");
    }
    
    public void play() {
        System.out.println("Áudio " + super.getActFile().getInformation().getName() + " reproduzido");
    }
    
    public void pause() {
        System.out.println("Áudio " + super.getActFile().getInformation().getName() + " pausado");
    }

    public void stop() {
        System.out.println("Áudio " + super.getActFile().getInformation().getName() + " parado");
    }

    public void changeVolume(int volume) {
        AudioFile f = ((AudioFile) super.getActFile());
        f.setVolume(volume);
        super.setActFile(f);
        System.out.println("Volume do áudio " + super.getActFile().getInformation().getName() + " alterado para " + volume);
    }

    public int getVolume() {
        return ((AudioFile) super.getActFile()).getVolume();
    }

    public String getDuration() {
        int duration = ((AudioFile) super.getActFile()).getDuration();
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + "m" + seconds + "s";
    }
    
}
