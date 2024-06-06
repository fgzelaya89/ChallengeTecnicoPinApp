Feature: ABM de Usuario en PetShop

  @ApiPetShop
  Scenario Outline: : Alta de nuevo usurio
    Given la UserAPI de PetShop está disponible
    When Se envia la siguiente informacion: <id>,<username>,<firstName>,<lastName>,<email>,<password>,<phone> y <userStatus>
    Then el codigo de estado de respuesta debe ser 200
    Examples:
      | id  | username | firstName       | lastName   | email             | password | phone    | userStatus |
      | 123 | Fernando | Nano de cordoba | Feer nando | Nano89@Nano89.com | 123123   | 60366036 | 0          |

  @ApiPetShop
  Scenario Outline: : Buscamo el usuario registrado
    Given la UserAPI de PetShop está disponible
    When llamo a la api de get usuario le envio <username>
    Then el codigo de estado de respuesta debe ser 200
    And Se valida la repuesta con los siguiente datos: la siguiente informacion: <id>,<username>,<firstName>,<lastName>,<email>,<password>,<phone> y <userStatus>
    Examples:
      | id  | username | firstName       | lastName   | email             | password | phone    | userStatus |
      | 123 | Fernando | Nano de cordoba | Feer nando | Nano89@Nano89.com | 123123   | 60366036 | 0          |

