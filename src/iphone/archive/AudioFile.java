package iphone.archive;

public class AudioFile extends File{
    private final int duration;
    private int volume;

    public AudioFile(FileInformation information, String path, int duration, int volume) {
        super("audio", information, path);
        if (!information.getExtension().equals("mp3") && !information.getExtension().equals("wav")) {
            throw new FileExtensionException("Invalid extension for audio file");
        }
        this.duration = duration;
        this.volume = volume;
    }

    public int getDuration() {
        return duration;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
