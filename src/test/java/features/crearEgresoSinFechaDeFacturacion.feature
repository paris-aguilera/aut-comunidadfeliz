Feature: Incorporaremos un nuevo egreso con el campo fecha de facturacion activado/desactivado segun caso

#La precondicion de estos 2 casos, el campo "fecha de facturacion" estara siempre activado
  @TC-1 @fechaFacturacion-activada
  Scenario: Crear un egreso con campo fecha de facturacion activado completando campos obligatorios
    Given El usuario "usuariopruebaQA@comunidadfeliz.com" ingresa a comunidadfeliz
    And En la configuracion activamos el campo "fecha de facturacion" y volvemos al inicio de la app
    And Selecciona menu "Cobranza y recaudación" con submenu "Egresos"
    And Da click en el boton "+ Nuevo Egreso"
    And Visualiza la seccion "Nuevo Egreso"
    And Ingresa campos obligatorios en la seccion "Nuevo Egreso"
    | campo                               | dato           |
    | Monto                               | 100000         |
    | Proveedor: Razón social y RUT       | Otro           |
    | Nombre                              | pruebaAut      |
    | Descripción                         | descripcionAut |
    And Da click en el boton "Guardar"
    And Se visualiza el mensaje "El egreso ha sido creado exitosamente"
    And Se visualiza en la vista el egreso ingresado correctamente

  @TC-2 @fechaFacturacion-activada
  Scenario: Intento crear un egreso con campo fecha de facturacion activado sin completar campos obligatorios
    Given El usuario "usuariopruebaQA" ingresa a comunidadfeliz
    And En la configuracion activamos el campo "fecha de facturacion" y volvemos al inicio de la app
    And Selecciona menu "Cobranza y recaudación" con submenu "Egresos"
    And Da click en el boton "+ Nuevo Egreso"
    And Visualiza la seccion "Nuevo Egreso"
    And Da click en el boton "Guardar"
    And Se valida la existencia de los errores en campos obligatorios
      | campo                               | error                                                           |
      | Monto                               | Ingrese un monto valido                                         |
      | Proveedor: Razón social y RUT       | Ingrese un Proveedor valido                                     |
      | Nombre                              | El nombre del proveedor no puede estar en blanco                |
      | Descripción                         | La descripción no puede estar en blanco                         |


#La precondicion de estos 2 casos, el campo "fecha de facturacion" estara siempre desactivado
  @TC-3 @fechaFacturacion-desactivado
  Scenario: Crear un egreso con campo fecha de facturacion desactivado completando campos obligatorios
    Given El usuario "usuariopruebaQA" ingresa a comunidadfeliz
    And En la configuracion desactivamos el campo "fecha de facturacion" y volvemos al inicio de la app
    And Selecciona menu "Cobranza y recaudación" con submenu "Egresos"
    And Da click en el boton "+ Nuevo Egreso"
    And Visualiza la seccion "Nuevo Egreso"
    And Ingresa campos obligatorios en la seccion "Nuevo Egreso"
      | campo                               | dato           |
      | Monto                               | 100000         |
      | Proveedor: Razón social y RUT       | Otro           |
      | Nombre                              | pruebaAut      |
      | Descripción                         | descripcionAut |
    And Da click en el boton "Guardar"
    And Se visualiza el mensaje "El egreso ha sido creado exitosamente"
    And Se visualiza en la vista el egreso ingresado correctamente

  @TC-4 @fechaFacturacion-desactivado
  Scenario: Intento crear un egreso con campo fecha de facturacion desactivado sin completar campos obligatorios
    Given El usuario "usuariopruebaQA" ingresa a comunidadfeliz
    And En la configuracion desactivamos el campo "fecha de facturacion" y volvemos al inicio de la app
    And Selecciona menu "Cobranza y recaudación" con submenu "Egresos"
    And Da click en el boton "+ Nuevo Egreso"
    And Visualiza la seccion "Nuevo Egreso"
    And Da click en el boton "Guardar"
    And Se valida la existencia de los errores en campos obligatorios
      | campo                               | error                                                           |
      | Monto                               | Ingrese un monto valido                                         |
      | Proveedor: Razón social y RUT       | Ingrese un Proveedor valido                                     |
      | Nombre                              | El nombre del proveedor no puede estar en blanco                |
      | Descripción                         | La descripción no puede estar en blanco                         |

#Casos bordes: intentar crear muchos nuevos egresos al hacer click simultaneamente al boton guardar con campo fechaFacturacion activado/desactivado
@TC-5 @casosBordes
  Scenario: Crear un egreso con campo fecha de facturacion activado completando campos obligatorios
    Given El usuario "usuariopruebaQA" ingresa a comunidadfeliz
    And En la configuracion activamos el campo "fecha de facturacion" y volvemos al inicio de la app
    And Selecciona menu "Cobranza y recaudación" con submenu "Egresos"
    And Da click en el boton "+ Nuevo Egreso"
    And Visualiza la seccion "Nuevo Egreso"
    And Ingresa campos obligatorios en la seccion "Nuevo Egreso"
      | campo                               | dato           |
      | Monto                               | 100000         |
      | Proveedor: Razón social y RUT       | Otro           |
      | Nombre                              | pruebaAut      |
      | Descripción                         | descripcionAut |
    And Forzamos el boton "Guardar" y le damos click hasta 10 veces de forma simultanea
    And Se visualiza el mensaje "El egreso ha sido creado exitosamente"
    And Se visualiza en la vista que el egreso fue ingresado correctamente solo una vez


  @TC-6 @casosBordes
  Scenario: Crear un egreso con campo fecha de facturacion desactivado completando campos obligatorios
    Given El usuario "usuariopruebaQA" ingresa a comunidadfeliz
    And En la configuracion desactivamos el campo "fecha de facturacion" y volvemos al inicio de la app
    And Selecciona menu "Cobranza y recaudación" con submenu "Egresos"
    And Da click en el boton "+ Nuevo Egreso"
    And Visualiza la seccion "Nuevo Egreso"
    And Ingresa campos obligatorios en la seccion "Nuevo Egreso"
      | campo                               | dato           |
      | Monto                               | 100000         |
      | Proveedor: Razón social y RUT       | Otro           |
      | Nombre                              | pruebaAut      |
      | Descripción                         | descripcionAut |
    And Forzamos el boton "Guardar" y le damos click hasta 10 veces de forma simultanea
    And Se visualiza el mensaje "El egreso ha sido creado exitosamente"
    And Se visualiza en la vista que el egreso fue ingresado correctamente solo una vez