# language: es
@testfeature
Característica: Validación del Carrito de Compras en la tienda

  Escenario: Validación del Precio de un Producto

    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "fernando.meza5@unmsm.edu.pe" y clave "fer5678MW"
    Cuando navego a la categoría "CLOTHES" y subcategoría "MEN"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el título de la página del "carrito"
    Y vuelvo a validar el cálculo de precios en el carrito
