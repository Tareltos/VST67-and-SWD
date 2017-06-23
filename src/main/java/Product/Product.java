package Product;

/**
 * Created by Виталя Тарелко on 19.06.2017.
 */
public class Product {
    private String brand;
    private String group;
    private String art;
    private int code;
    private String e;
    private int count;
    private double sbs;
    private double cost;
    private String costFrom;
    private String time;
    private String rCount;



    public Product() {
    }

    public Product(String brand, String group, String art, int code, String e, int count, double sbs, double cost) {
        this.brand = brand;
        this.group = group;
        this.art = art;
        this.code = code;
        this.e = e;
        this.count = count;
        this.sbs = sbs;
        this.cost = cost;
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

    public String getCostFrom() {
        return costFrom;
    }

    public void setCostFrom(String costFrom) {
        this.costFrom = costFrom;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public double getSbs() {
        return sbs;
    }

    public void setSbs(double sbs) {
        this.sbs = sbs;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getrCount() {
        return rCount;
    }

    public void setrCount(String rCount) {
        this.rCount = rCount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}