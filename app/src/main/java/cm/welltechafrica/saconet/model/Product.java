package cm.welltechafrica.saconet.model;

public class Product {

    private int imageRessource;
    private String name;
    private String price;
    private String specialPrice;

    public Product(int imageRessource, String name, String price, String specialPrice) {
        this.imageRessource = imageRessource;
        this.name = name;
        this.price = price;
        this.specialPrice = specialPrice;
    }

    public int getImageRessource() {
        return imageRessource;
    }

    public void setImageRessource(int imageRessource) {
        this.imageRessource = imageRessource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }
}

