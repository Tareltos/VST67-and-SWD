import Product.Product;
import Product.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Виталя Тарелко on 19.06.2017.
 */
public class vst_67 {



    public static void main(String[] args) throws InterruptedException, IOException {
        ProductList pl = new ProductList();
        List<Product> list = pl.getList();

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://vst67.ru");

        //search for LOGIN lform
        driver.findElement(By.xpath(".//*[@id='login']")).sendKeys("morozov@autospace.by");
        driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("123456");
        driver.findElement(By.xpath(".//*[@id='go']")).click();
        Thread.sleep(1000);
        // search by articul frof All List
        for(int i =0; i<list.size(); i++){
            driver.findElement(By.xpath(".//*[@id='pcode']")).clear();
            driver.findElement(By.xpath(".//*[@id='pcode']")).sendKeys(list.get(i).getArt());
            driver.findElement(By.xpath(".//*[@id='srchform']/div/div[2]/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/div/noindex/table/tbody/tr[3]/td[2]")).click();
            Thread.sleep(15000);
         try {
             String time = driver.findElement(By.xpath(".//*[@id='searchResultsTable']/tbody/tr[3]/td[6]")).getText();
             String count = driver.findElement(By.xpath(".//*[@id='searchResultsTable']/tbody/tr[3]/td[5]/span")).getText();
             String price = driver.findElement(By.xpath(".//*[@id='searchResultsTable']/tbody/tr[3]/td[7]")).getText();
             System.out.println(list.get(i).getArt() + " Count " + count + " DeliveryTime: " + time + " Best_Price :" + price);

         }
         catch(Exception e){}
        }
        Thread.sleep(3000);



        driver.close();

    }
}
