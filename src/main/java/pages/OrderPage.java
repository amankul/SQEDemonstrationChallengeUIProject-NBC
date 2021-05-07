package pages;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {

    public WebDriver driver;
    public TestBase testbase = new TestBase();

    By pizza1 = By.id("pizza1Pizza");
    By pizza1Toppings1 = By.xpath("//div[@id='pizza1']//select[@class='toppings1']");
    By pizza1Toppings2 = By.xpath("//div[@id='pizza1']//select[@class='toppings2']");
    By pizza1Quantity = By.id("pizza1Qty");
    By pizza1Cost = By.id("pizza1Cost");
    By radioCreditCard = By.id("ccpayment");
    By radioCash = By.id("cashpayment");
    By email = By.id("email");
    By name = By.id("name");
    By phone = By.id("phone");
    By placeOrderButton = By.id("placeOrder");
    By resetButton = By.id("reset");
    By dialog = By.id("dialog");
    By dialogText = By.xpath("//div[@id='dialog']/p");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ChoosePizza(String pizza) {
        Select dropDown = new Select(driver.findElement(pizza1));
        dropDown.selectByValue(pizza);
    }

    public void ChooseTopping(String top) {
        Select dropDown = new Select(driver.findElement(pizza1Toppings2));
        dropDown.selectByValue(top);
    }

    public void EnterQuantity(String qty) {
        testbase.wait_until_clickable(driver, pizza1Quantity).sendKeys(qty);
    }

    public String GetCost() {
        return testbase.wait_until_clickable(driver, pizza1Cost).getAttribute("value");
    }

    public void EnterName(String nam) {
        testbase.wait_until_clickable(driver, name).sendKeys(nam);
    }

    public void EnterPhone(String fon) {
        testbase.wait_until_clickable(driver, phone).sendKeys(fon);
    }

    public void SelectCredit() {
        testbase.wait_until_clickable(driver, radioCreditCard).click();
    }


    public String PlaceOrder() throws InterruptedException {
        testbase.wait_until_clickable(driver, placeOrderButton).click();
        return testbase.wait_until_clickable(driver, dialogText).getText();
    }
}
