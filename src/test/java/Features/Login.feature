Feature: Login

  @Test @WebTest
  Scenario: Login correcto
    Given estoy en la pagina de registro
    When ingreso el usuario 'standard_user' y la contraseña 'secret_sauce'
    And hago click en el boton login
    Then ingreso a la pagina de shopping

  @Test @WebTest
  Scenario: Login incorrecto
    Given estoy en la pagina de registro
    When ingreso el usuario 'standard_user' y la contraseña 'secret_sauce'
    And hago click en el boton login
    Then veo un cartel de error de usuario y contraseña


