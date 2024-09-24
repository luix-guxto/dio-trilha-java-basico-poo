package iphone.archive;

import java.util.Date;

public class FileInformation {
    private String name;
    private Date data;
    private int size;
    private String extension;

    public FileInformation(String extension, int size, Date data, String name) {
        this.extension = extension;
        this.size = size;
        this.data = data;
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getName() {
        return name+"."+extension;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "{\n Name: "+name+"\n Extension: "+extension+"\n Size: "+size+" bytes\n Date: "+data+"\n}";
    }
}
