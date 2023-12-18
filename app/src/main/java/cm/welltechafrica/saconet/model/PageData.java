package cm.welltechafrica.saconet.model;

public class PageData {

    private int imageRessource;
    private String title;
    private String body;

    public PageData(int imageRessource, String title, String body) {
        this.imageRessource = imageRessource;
        this.title = title;
        this.body = body;
    }

    public int getImageRessource() {
        return imageRessource;
    }

    public void setImageRessource(int imageRessource) {
        this.imageRessource = imageRessource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
