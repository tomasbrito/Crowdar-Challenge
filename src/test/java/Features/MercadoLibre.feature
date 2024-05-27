Feature: Verificar departamentos en Mercado Libre

  @Test
  Scenario: obtener departamentos de Mercado Libre y verificar que contenga departamentos
    Given estoy en la página de departamentos de Mercado Libre
    When recibo la lista de departamentos
    Then la lista de departamentos no debe estar vacía