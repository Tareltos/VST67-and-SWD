package entity;

import java.io.IOException;
import java.util.*;
import Loaders.*;

/**
 * Created by Виталя Тарелко on 19.06.2017.
 */
public class ProductList {

    List<Product> list;

    public ProductList() throws IOException {
      list = loadSet.LFromExcel(list, "Autospace.xlsx");
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    public void setData() throws IOException {
        loadSet.setToExcel(list,  "ComperePrice.xls");
    }
}
