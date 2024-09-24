package iphone.archive;

public class VideoFile extends File{
    private final int duration;
    private Resolution resolution;
    private int volume;

    public VideoFile(FileInformation information, String path, int duration, Resolution resolution, int volume) {
        super("video", information, path);
        if (!information.getExtension().equals("mp4")) {
            throw new FileExtensionException("Invalid extension for video file");
        }
        this.duration = duration;
        this.resolution = resolution;
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

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}
