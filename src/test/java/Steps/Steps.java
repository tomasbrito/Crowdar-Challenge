package Steps;

import Pages.LoginPage;
import Pages.ShoppingPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Pages.LoginPage.*;
import static Pages.ShoppingPage.*;

public class Steps {

    WebDriver driver;
    LoginPage loginPage;
    ShoppingPage shoppingPage;

    @Before("@WebTest")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        shoppingPage = new ShoppingPage(driver);
    }

    @Given("estoy en la pagina de registro")
    public void abrirPagina(){
        driver.get("https://www.saucedemo.com/");
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingresoElUsuarioYLaContraseña(String user, String password) {
        loginPage.sendText(locatorInputUsername, user);
        loginPage.sendText(locatorInputPassword, password);
    }

    @And("hago click en el boton login")
    public void hagoClickEnElBotonLogin() {
        loginPage.click(locatorButtonLogin);
    }

    @Then("ingreso a la pagina de shopping")
    public void ingresoALaPaginaDeShopping() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
    }


    @Given("estoy en la pagina de shopping")
    public void abrirPaginaShopping(){
        driver.get("https://www.saucedemo.com/");
        loginPage.sendText(locatorInputUsername, "standard_user");
        loginPage.sendText(locatorInputPassword, "secret_sauce");
        loginPage.click(locatorButtonLogin);
    }


    @When("agrego un item")
    public void comprar(){
        shoppingPage.click(locatorButtonAddBackpack);
    }

    @Then("veo el numero de items agregados en el carrito")
    public void veoElNumeroDeItemsAgregadosEnElCarrito() {
        shoppingPage.elementExists(locatorSpanCartNumber);
    }

    @Then("el boton del item agregado cambia")
    public void elBotonDelItemAgregadoCambia() {
        Assertions.assertTrue(shoppingPage.elementExists(locatorButtonRemoveBackpack));
    }


    @Then("veo un cartel de error de usuario y contraseña")
    public void veoUnCartelDeErrorDeUsuarioYContraseña() {
        Assertions.assertTrue(shoppingPage.elementExists(locatorErrorLogin));
    }

    @After("@WebTest")
    public void closeDriver(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Error screenshot");
        }


        driver.quit();
    }


}
