package Product;

/**
 * Created by Виталя Тарелко on 19.06.2017.
 */
public class Product {
    private String brand;
    private String art;
    private int count;
    private double cost;
    private double costFrom;

    public Product() {
    }

    public Product(String brand, String art, int count, double cost) {
        this.brand=brand;
        this.art = art;
        this.count = count;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCostFrom() {
        return costFrom;
    }

    public void setCostFrom(double costFrom) {
        this.costFrom = costFrom;
    }
}
