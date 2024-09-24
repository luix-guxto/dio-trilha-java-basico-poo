package iphone.reprodutor;


import iphone.archive.ImageFile;
import iphone.archive.Resolution;

public class VisualizadorDeImagens extends Reprodutor{
    public VisualizadorDeImagens(ImageFile file) {
        super(file);
    }

    @Override
    public void open() {
        System.out.println("Imagem " + super.getActFile().getInformation().getName() + " aberta");
    }

    @Override
    public void close() {
        System.out.println("Imagem " + super.getActFile().getInformation().getName() + " fechada");
    }

    public void next(ImageFile f) {
        super.next(f);
        System.out.println("Próxima imagem");
    }

    public void previous() {
        super.previous();
        System.out.println("Imagem anterior");
    }

    public void zoomIn() {
        System.out.println("Imagem " + super.getActFile().getInformation().getName() + " ampliada");
    }

    public void zoomOut() {
        System.out.println("Imagem " + super.getActFile().getInformation().getName() + " reduzida");
    }

    public void rotate() {
        System.out.println("Imagem " + super.getActFile().getInformation().getName() + " rotacionada");
    }

    public void changeResolution(Resolution r) {
        ImageFile f = ((ImageFile) super.getActFile());
        f.setResolution(r);
        super.setActFile(f);
        System.out.println("Resolução da imagem " + super.getActFile().getInformation().getName() + " alterada");
    }

    public void changeResolution(int width, int height) {
        ImageFile f = ((ImageFile) super.getActFile());
        f.setResolution(new Resolution(width, height));
        super.setActFile(f);
        System.out.println("Resolução da imagem " + super.getActFile().getInformation().getName() + " alterada");
    }

    public Resolution getResolution() {
        return ((ImageFile) super.getActFile()).getResolution();
    }

    public void showResolution() {
        System.out.println("Resolução da imagem " + super.getActFile().getInformation().getName() + ": " + getResolution());
    }
}
