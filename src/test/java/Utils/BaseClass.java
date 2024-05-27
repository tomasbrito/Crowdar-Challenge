package Utils;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass extends PageObject {

    protected WebDriver driver;

    public BaseClass(WebDriver driver){
        this.driver = driver;
    }

    public WebElement esperaExplicita(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public void click(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(esperaExplicita(locator)).click().perform();
    }

    public void sendText(By locator, String text){
        esperaExplicita(locator).sendKeys(text);
    }

    public boolean elementExists(By locator){
        try {
            esperaExplicita(locator);
            return true;
        }catch (Error e){
            return false;
        }
    }

}
