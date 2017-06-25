package pages;

import entity.Product;
import entity.User;
import org.openqa.selenium.By;
import utils.Screenshoter;

import java.util.List;

/**
 * Created by Sergey_Poritskiy on 6/15/2017.
 */
public class MainPage extends AbstractPage {
    private User user = new User("morozov@autospace.by","123456");
    private static final String MAIN_URL = "http://vst67.ru";
    private static final By LOGIN_FORM_LOCATOR = By.xpath(".//*[@id='login']");
    private static final By PASSWORD_FORM_LOCATOR = By.xpath(".//*[@id='pass']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath(".//*[@id='go']");

    public MainPage open() {
        driver.get(MAIN_URL);
        return this;
    }

    public void logIn(){
        highlightElement(LOGIN_FORM_LOCATOR);
        highlightElement(PASSWORD_FORM_LOCATOR);
        highlightElement(LOGIN_BUTTON_LOCATOR);
        Screenshoter.takeScreenshot();
        driver.findElement(LOGIN_FORM_LOCATOR).sendKeys(user.getMail());
        driver.findElement(PASSWORD_FORM_LOCATOR).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();

    }
    public List<Product> findProduct(List<Product> list) throws InterruptedException {

        for(int i =0; i<list.size(); i++){
            String url = "http://vst67.ru/?pbrandnumber=" +list.get(i).getArt() +"&pbrandname="+list.get(i).getBrand();
            System.out.println(url);
            driver.get(url);
            Thread.sleep(15000);
            try {
                String time = driver.findElement(By.xpath(".//*[@id='searchResultsTable']/tbody/tr[3]/td[6]")).getText();
                String count = driver.findElement(By.xpath(".//*[@id='searchResultsTable']/tbody/tr[3]/td[5]/span")).getText();
                String price = driver.findElement(By.xpath(".//*[@id='searchResultsTable']/tbody/tr[3]/td[7]")).getText();
                // String [] p = price.split(" ");
                System.out.println(list.get(i).getArt() + " Count " + count + " DeliveryTime: " + time + " Best_Price :" + price+ " Autospace :" + list.get(i).getCost());
                list.get(i).setTime(time);
                list.get(i).setrCount(count);
                list.get(i).setCostFrom(price);

            }
            catch(Exception e){}
        }
        return list;
    }


}
