package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //locators
    public final static By locatorInputUsername = By.xpath("//input[@id='user-name']");
    public final static By locatorInputPassword = By.xpath("//input[@id='password']");
    public final static By locatorButtonLogin = By.xpath("//input[@id='login-button']");
    public final static By locatorErrorLogin = By.xpath("//div[@class='error-message-container error']");


}
