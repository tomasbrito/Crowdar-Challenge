Feature: Shopping

  @Test @WebTest
  Scenario: Numeros de items agregados al carrito
    Given estoy en la pagina de shopping
    When agrego un item
    Then veo el numero de items agregados en el carrito

  @Test @WebTest
  Scenario: Cambio de boton al agregar item al carro
    Given estoy en la pagina de shopping
    When agrego un item
    Then el boton del item agregado cambia


