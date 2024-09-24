package iphone.archive;

public class ImageFile extends File{
    private Resolution resolution;

    public ImageFile(FileInformation information, String path, Resolution resolution) {
        super("image", information, path);
        if (!information.getExtension().equals("jpg") && !information.getExtension().equals("png")) {
            throw new FileExtensionException("Invalid extension for image file");
        }
        this.resolution = resolution;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}

