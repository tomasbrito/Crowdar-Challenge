package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingPage extends BaseClass {

    public ShoppingPage(WebDriver driver){
        super(driver);
    }


    //locators
    public static final By locatorButtonCart = By.xpath("//a[@class='shopping_cart_link'");
    public static final By locatorSpanCartNumber = By.xpath("//span[@class='shopping_cart_badge']");

    public static final By locatorButtonRemoveBackpack = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    public static final By locatorButtonAddBackpack = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static final By locatorButtonJacket = By.xpath("//a[@id='add-to-cart-sauce-labs-fleece-jacket'");

}
