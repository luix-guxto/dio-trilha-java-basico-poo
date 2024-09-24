package iphone.telefone;

import iphone.archive.AudioFile;
import iphone.reprodutor.Reprodutor;
import iphone.reprodutor.ReprodutorDeAudios;

public record CorreioDeVoz(AudioFile audioFile, Contato contato) {

    @Override
    public String toString() {
        return "CorreioDeVoz{" +
                " audioFile=" + audioFile + ",\n" +
                " contato=" + contato + "\n" +
                '}';
    }

    public Reprodutor ouvir() {
        return new ReprodutorDeAudios(audioFile);
    }
}
