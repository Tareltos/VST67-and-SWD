import entity.Product;
import entity.*;
import logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import utils.Screenshoter;
import utils.WebDriverSingleton;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Виталя Тарелко on 19.06.2017.
 */
public class vst_67 {
    public static final MainPage mainPage = new MainPage().open();
    public static ProductList pl = null;


    public static void main(String[] args) throws InterruptedException, IOException {
        List<Product> product_list = vst_67.loadData();
        vst_67.logIn();
        product_list = vst_67.findProduct(product_list);
        pl.setList(product_list);
        pl.setData();
        vst_67.kill();

    }



    public static void logIn() {

        Screenshoter.takeScreenshot();
        mainPage.logIn();
        Screenshoter.takeScreenshot();
    }
    public static List<Product> findProduct(List<Product> list) throws InterruptedException {
        return mainPage.findProduct(list);
    }

    public static void kill(){
        WebDriverSingleton.kill();
    }

    public static List<Product> loadData(){

        try {
            pl = new ProductList();
        } catch (IOException e) {

            Logger.error("Cannot load Data from Excel");
        }
        List<Product> list = pl.getList();
        return list;
    }

}
