package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class MercadoLibreSteps {

    private Response response;

    @Given("estoy en la página de departamentos de Mercado Libre")
    public void estoyEnLaPaginaDeDepartamentosDeMercadoLibre() {
        // Setup básico para RestAssured, si es necesario.
        RestAssured.baseURI = "https://www.mercadolibre.com.ar";
    }

    @When("recibo la lista de departamentos")
    public void obtengoLaListaDeDepartamentos() {
        response =
                given()
                        .when()
                        .get("/menu/departments")
                        .then()
                        .extract()
                        .response();
    }

    @Then("la lista de departamentos no debe estar vacía")
    public void laListaDeDepartamentosNoDebeEstarVacia() {
        List<String> departamentos = response.jsonPath().getList("departments.name");
        Assertions.assertFalse(departamentos.isEmpty());
    }
}