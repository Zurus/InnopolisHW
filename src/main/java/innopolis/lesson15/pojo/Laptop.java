package innopolis.lesson15.pojo;

public class Laptop {
    private int id;
    private String name;
    private int price;
    private int manufacturerId;

    public Laptop(int id, String name, int price, int manufacturerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "name='" + name + ", price=" + price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
