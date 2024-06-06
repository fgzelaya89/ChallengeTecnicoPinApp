# Challenge Técnico para PinApp

Este es un proyecto técnico creado para PinApp, en el cual se utilizó la plataforma de Mercado Libre para la generación de pruebas automatizadas, incluyendo pruebas de la API de PetShop.

## Tecnologías y Versiones de las Librerías

- **Java**: 17.0.4.1
- **Selenium**: 4.10.0
- **Cucumber**: 7.7.0
- **JUnit**: 5.8.2
- **WebDriver Manager**: 5.3.2
- **RestAssured**: 4.4.0

## Descripción del Proyecto

Este proyecto consiste en la automatización de pruebas de la página web de Mercado Libre, así como de la API de PetShop. Utiliza Selenium para la automatización del navegador, Cucumber para la gestión de pruebas basadas en BDD (Behavior Driven Development), y Page Object Model (POM) para la organización del código.

## Configuración del Proyecto

### Prerrequisitos

- Java JDK 17 o superior
- Maven 3.6.0 o superior
- ChromeDriver compatible con la versión del navegador Chrome instalada

### Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/fgzelaya89/ChallengeTecnicoPinApp.git
    cd ChallengeTecnicoPinApp
    ```

2. Configura las dependencias de Maven:
    ```sh
    mvn clean install
    ```

3. Asegúrate de que `chromedriver` esté disponible en tu PATH, o configúralo en el proyecto.

### Estructura del Proyecto

El proyecto sigue la estructura estándar de Maven.

## Ejecución de Pruebas

- Para ejecutar el proyecto completo, utiliza el siguiente tag: `@ChallengetecnicoPinApp`.
- Para ejecutar solo los escenarios de Mercado Libre (pruebas FrontEnd), utiliza el tag: `@SearchMercadoLibre`.
- Para ejecutar los escenarios de la API de PetShop (pruebas Backend), utiliza el tag: `@ApiPetShop`.
