package iphone.reprodutor;

import iphone.archive.File;

public abstract class Reprodutor {
    private File actFile;
    private File prevFile;

    public Reprodutor(File file) {
        this.actFile = file;
    }

    public void setActFile(File file) {
        this.actFile = file;
    }

    public abstract void open();

    public abstract void close();

    public File getActFile() {
        return actFile;
    }

    public void next(File file){
        prevFile = actFile;
        actFile = file;
    }

    public void previous(){
        actFile = prevFile;
        prevFile = null;
    }
}
