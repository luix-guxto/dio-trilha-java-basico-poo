package iphone.galeria;

import iphone.archive.File;
import java.util.TreeMap;

public class Album {
    private final TreeMap<String, File> files;
    private String name;

    public Album(String name) {
        this.name = name;
        files = new TreeMap<>();
    }

    public void addFile(File file) {
        files.put(file.getInformation().getName(), file);
    }

    public void removeFile(String name) {
        files.remove(name);
    }

    public File getFile(String name) {
        return files.get(name);
    }

    public TreeMap<String, File> getFiles() {
        return files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
