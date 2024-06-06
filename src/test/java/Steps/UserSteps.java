package Steps;

import ApiObject.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


import static Config.Properties.BASE_URL;


public class UserSteps {
    private Response response;

    @Given("la UserAPI de PetShop está disponible")
    public void laUserAPIDePetstoreEstáDisponible() {
        Response response = RestAssured.get(BASE_URL + "/pet/findByStatus?status=available");
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("La UserAPI de Petstore No está disponible");
        }
    }

    @When("Se envia la siguiente informacion: (.*),(.*),(.*),(.*),(.*),(.*),(.*) y (.*)")
    public void seEnviaLaSiguienteInformacionY(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) throws JsonProcessingException {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        User userSend = new User();
        userSend.setId(Integer.parseInt(id));
        userSend.setEmail(email);
        userSend.setUsername(username);
        userSend.setFirstName(firstName);
        userSend.setLastName(lastName);
        userSend.setPassword(password);
        userSend.setPhone(phone);
        userSend.setUserStatus(Integer.parseInt(userStatus));


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userSend);
        System.out.println("json: " + json);
        request.body(json);

        response = request.post(BASE_URL + "/user");
        // You can print or log the response if needed
        System.out.println(response.asString());
    }

    @Then("el codigo de estado de respuesta debe ser {int}")
    public void elCodigoDeEstadoDeRespuestaDebeSer(int StatusCode) {
        // Validar que el StatusCode sea 200
        response.then().statusCode(StatusCode);
    }



    @When("llamo a la api de get usuario le envio (.*)")
    public void llamoALaApiDeGetUsuarioLeEnvio(String username) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(BASE_URL + "/user/"+username);
        // You can print or log the response if needed
        System.out.println(response.asString());
    }

    @And("Se valida la repuesta con los siguiente datos: la siguiente informacion: (.*),(.*),(.*),(.*),(.*),(.*),(.*) y (.*)")
    public void seValidaLaRepuestaConLosSiguienteDatosLaSiguienteInformacionIdUsernameFirstNameLastNameEmailPasswordPhoneYUserStatus(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        User userSend = new User();
        userSend.setId(Integer.parseInt(id));
        userSend.setEmail(email);
        userSend.setUsername(username);
        userSend.setFirstName(firstName);
        userSend.setLastName(lastName);
        userSend.setPassword(password);
        userSend.setPhone(phone);
        userSend.setUserStatus(Integer.parseInt(userStatus));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(response.asString(), User.class);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
