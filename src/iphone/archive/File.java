package iphone.archive;
public abstract class File {
    private String path;
    private FileInformation fileInformation;
    private final String type;

    public File(String t, FileInformation i, String p) {
        this.type = t;
        this.fileInformation = i;
        this.path = p;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileInformation getInformation() {
        return fileInformation;
    }

    public void setInformation(FileInformation fileInformation) {
        this.fileInformation = fileInformation;
    }

    public String getType() {
        return type;
    }
}
