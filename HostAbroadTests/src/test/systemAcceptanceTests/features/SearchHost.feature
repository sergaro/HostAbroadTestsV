Feature: Buscar usuario (anfitrión).

  Descripción: Como usuario registrado quiero poder 
  buscar a anfitriones para poder alojarme en sus casas.
  
  @First
  Scenario: Buscar usuario Happy Path
    Given el usuario navega hasta la pagina de search
    When el usuario selecciona como tipo de usuario anfitrión
    And  pulsa el botón de buscar
    Then el usuario podrá ver un listado con los anfitriones
  
  @Second  
  Scenario: Buscar usuario Error
    Given el usuario navega hasta la pagina de search
    When el usuario selecciona como tipo de usuario anfitrión
    And  pulsa el botón de buscar
    Then mostrará un listado vacío
    And  un mensaje indicando que no hay ningún anfitrión registrado.