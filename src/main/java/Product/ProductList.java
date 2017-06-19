package Product;

import java.util.ArrayList;

/**
 * Created by Виталя Тарелко on 19.06.2017.
 */
public class ProductList {
    private Product product = new Product("Airtex","1680", 5, 990);
    private Product product2 = new Product("Airtex","1700", 8, 1090);
    private Product product3 = new Product("Airtex","9274", 16, 1490);
    private Product product4 = new Product("Airtex","1609", 3, 1390);
    ArrayList<Product> list;

    public ProductList() {
        list = new ArrayList<Product>();
        list.add(product);
        list.add(product2);
        list.add(product3);
        list.add(product4);
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }
}
