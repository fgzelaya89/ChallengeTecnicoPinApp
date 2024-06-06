Feature: ABM de Usuario en PetShop

  @ApiPetShop @ChallengetecnicoPinApp
  Scenario Outline: : Alta de nuevo usurio
    Given la UserAPI de PetShop está disponible
    When Se envia la siguiente informacion: <id>,<username>,<firstName>,<lastName>,<email>,<password>,<phone> y <userStatus>
    Then el codigo de estado de respuesta debe ser 200
    Examples:
      | id  | username | firstName | lastName | email                | password | phone    | userStatus |
      | 123 | fgzelaya | Fernando  | Zelaya   | fgzelaya89@gmail.com | 123123   | 60366036 | 0          |

  @ApiPetShop @ChallengetecnicoPinApp
  Scenario Outline: Buscamo el usuario registrado
    Given la UserAPI de PetShop está disponible
    When llamo a la api de get usuario le envio <username>
    Then el codigo de estado de respuesta debe ser 200
    And Se valida la repuesta con los siguiente datos: la siguiente informacion: <id>,<username>,<firstName>,<lastName>,<email>,<password>,<phone> y <userStatus>
    Examples:
      | id  | username | firstName | lastName   | email                | password | phone    | userStatus |
      | 123 | fgzelaya | Fernando  | Zelaya   | fgzelaya89@gmail.com | 123123   | 60366036 | 0          |

  @ApiPetShop @ChallengetecnicoPinApp
  Scenario Outline: Actualizamo los datos del usuari
    Given la UserAPI de PetShop está disponible
    When llamo a la api de get usuario le envio <username>
    When Actualizamos los datos del usuario <id>,<username>,<firstName>,<lastName>,<email>,<password>,<phone> y <userStatus>
    Then el codigo de estado de respuesta debe ser 200
    And llamo a la api de get usuario le envio <username>
    And Se valida la repuesta con los siguiente datos: la siguiente informacion: <id>,<username>,<firstName>,<lastName>,<email>,<password>,<phone> y <userStatus>
    Examples:
      | id  | username | firstName | lastName   | email                | password | phone    | userStatus |
      | 123 | fgzelaya | Fernando  | Zelaya   | fgzelaya89@gmail.com | 123123   | 60366036 | 0          |
