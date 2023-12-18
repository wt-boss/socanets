package cm.welltechafrica.saconet.model;

public class SliderItem {

    private int imageRessource;
    private String label;

    public SliderItem(int imageRessource, String label) {
        this.imageRessource = imageRessource;
        this.label = label;
    }


    public int getImageRessource() {
        return imageRessource;
    }

    public void setImageRessource(int imageRessource) {
        this.imageRessource = imageRessource;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
