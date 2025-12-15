# language: es
@retoChoucair
Característica: Registrar usuario

  Escenario: Registrar usuario de manera exitosa

    Dado estoy en la pagina principal
    Y doy clic en la opción Register
    Cuando ingreso mis datos de registro "M" "Juan" "Perez" "corrjjeo@test.com" "MiClave123"
    Entonces valido la creacion del usuario
