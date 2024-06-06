Feature: Buscar Productos MercadoLibre

  Background: precondicion de ejecuion
    And Configuración del driver de Chrome

  @ChallengetecnicoPinApp
  Scenario: Buscar un producto y verificar el precio
    Given cuando el usuario ingresa home page de MercadoLibre
    When el usuario busca el siguiente producto "notebook gamer"
    Then el usuario observa el siguiente producto "Notebook Acer Aspire 3 15.6 Amd Ryzen 7 5700u 16gb De Ram 512gb Ssd Windows 11 Home"
    And selecciona el producto
    And Se desplazo hacia abajo en la pagina
    Then el precio del producto es igual a "1.075.999"

  @ChallengetecnicoPinApp
  Scenario: Buscar un producto y verificar el detalle
    Given cuando el usuario ingresa home page de MercadoLibre
    When el usuario busca el siguiente producto "smartphone"
    Then el usuario quiere ver el detalle "Celular Quantum Yolo 32 Gb 1 Gb Ram Android 10 8 Mp Rojo 5"
    And Se desplazo hacia abajo en la pagina
    And valida que contega el siguiente detalle "Memoria de 32 GB y 1 GB RAM: espacio para apps y archivos"
    #Then I should see the product details