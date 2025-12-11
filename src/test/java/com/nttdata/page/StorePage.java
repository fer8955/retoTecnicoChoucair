package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage {

    private WebDriverWait wait;
    private WebDriver driver;


    public StorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera explícita con un timeout de 5 segundos
    }

    // Localizador para el botón "Iniciar sesión"
    private static By buttonIniciar = By.xpath("//span[contains(text(),'Iniciar sesión')]");

    // Localizadores para los campos de usuario y contraseña
    public static By userInput = By.xpath("//input[@id='field-email']");
    public static By passInput = By.xpath("//input[@id='field-password']");

    // Localizador para el botón de inicio de sesión
    public static By loginButton = By.xpath("//button[@id='submit-login']");

    // Localizador para el elemento de validación de inicio de sesión
    public static By elementValidateLogin = By.xpath("//*[@id='_desktop_user_info']/div/a[2]");

    // Localizador para el botón categoría
    public static By buttonCategory = By.xpath("//*[@id='category-3']/a");

    // Localizador para validar Categoría y Subcategoria
    public static By elementValidateCat = By.xpath("//*[@id='js-product-list-header']/div/h1");

    // Localizador para el botón Subcategoría
    public static By buttonSubCategory = By.xpath("//*[@id='subcategories']/ul/li[1]/div[1]/a/picture");

    //Localizador del primer producto
    public static  By FirstProduct = By.xpath("//*[@id='js-product-list']/div[1]/div/article/div/div[1]/a/picture/img");

    //Localizador para añadir cantidad
    public static  By AddCantidad = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[1]/div/span[3]/button[1]");

    //Localizador para añadir al carrito
    public static  By buttonAddCarrito = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button");

    //Localizador para validar el pop up
    public static  By PopUp = By.xpath("//*[@id='blockcart-modal']/div/div");

    //Localizador para validar el producto agregado
    public static  By modalNameProduct = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[1]/div/div[2]/h6");

    //Localizador para precio
    public static  By modalPrice = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[1]/div/div[2]/p");

    //Localizador para Cantidad
    public static  By modalCant = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");

    //Localizador para Monto
    public static  By modalMount = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/p[4]/span[2]");

    //Localizador para button  comprar
    public static  By buttonBuy = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a");

    //Localizador para validar el titulo de la Pagina Carrito
    public static  By titlePageCarrito = By.xpath("//*[@id='main']/div/div[1]/div/div[1]/h1");

    //Localizador para precio Carrito
    public static  By carritoPrice = By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");

    //Localizador para Cantidad Carrito
    public static  By carritoCant = By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input");

    //Localizador para Monto Carrito
    public static  By carritoMount = By.xpath("//*[@id='main']/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");


    // Método para hacer clic en el botón "Iniciar sesión"
    public void clickButtonIniciarSesion() throws InterruptedException {
        WebElement iniciarSesionButton = driver.findElement(buttonIniciar);
        iniciarSesionButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Nueva espera explícita con timeout de 10 segundos
        try {
            // Esperar a que la URL contenga "iniciar-sesion"
            wait.until(ExpectedConditions.urlContains("iniciar-sesion"));
        } catch (TimeoutException e) {
            System.out.println("Error: No se encontró el elemento.");
        }

    }

    // Método para escribir el nombre de usuario
    public void typeUser(String usuario) {
        WebElement typeUser = driver.findElement(userInput);
        typeUser.sendKeys(usuario);
    }

    // Método para escribir la contraseña
    public void typePassword(String clave) {
        WebElement typePass = driver.findElement(passInput);
        typePass.sendKeys(clave);
    }

    // Método para hacer clic en el botón de inicio de sesión
    public void clickIniciarSesion() {
        WebElement submitButton = driver.findElement(loginButton);
        submitButton.click();
    }

    // Método para validar el inicio de sesión
    public void validateLogin() {
        // Esperar a que el elemento de validación de inicio de sesión esté presente en la página
        try {
            WebElement validateLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(elementValidateLogin));
            // Verificar si el elemento de validación de inicio de sesión está presente y mostrar un mensaje
            if (validateLoginElement.isDisplayed()) {
                System.out.println("El inicio de sesión fue exitoso. Elemento de validación encontrado.");
            } else {
                System.out.println("El inicio de sesión falló. No se encontró el elemento de validación.");
            }
        } catch (TimeoutException e) {
            System.out.println("Error: No se encontró el elemento.");
        }


    }

    // Métodos para clic en la categoría y subcategoría
    public void clickCategoria() {
        WebElement categoryButton = driver.findElement(buttonCategory);
        categoryButton.click();
    }

    public void validateCategoria(String categoria) {
        try {
            // Esperar a que el elemento de validación de categoría esté presente en la página
            WebElement validateCategoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(elementValidateCat));
            // Obtener el texto del elemento de validación de categoría
            String categoriaTexto = validateCategoriaElement.getText();
            // Verificar si el texto de la categoría es "Clothes"
            if (categoriaTexto.equals(categoria)) {
                System.out.println("La categoría seleccionada es correcta: " + categoriaTexto);
            } else {
                System.out.println("La categoría seleccionada es incorrecta. Se esperaba" + categoria + " pero se encontró: " + categoriaTexto);
            }
        } catch (TimeoutException e) {
            System.out.println("Error: No se encontró el elemento.");
        }
    }
    // Métodos para clic en la  subcategoría
    public void clickSubCategoria() {
        WebElement SubcategoryButton = driver.findElement(buttonSubCategory);
        SubcategoryButton.click();
    }


    public void validateSubCategoria(String subcategoria) {
        try {
            // Esperar a que el elemento de validación de categoría esté presente en la página
            WebElement validateCategoriaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(elementValidateCat));

            // Obtener el texto del elemento de validación de categoría
            String categoriaTexto = validateCategoriaElement.getText();

            // Verificar si el texto de la subcategoría es "Men"
            if (categoriaTexto.equals(subcategoria)) {
                System.out.println("La subcategoría seleccionada es correcta: " + categoriaTexto);
            } else {
                System.out.println("La subcategoría seleccionada es incorrecta. Se esperaba" + subcategoria + "pero se encontró: " + categoriaTexto);
            }
        } catch (TimeoutException e) {
            System.out.println("Error: No se encontró el elemento");
        }
    }

    public void clickFirstProduct() {
        WebElement ButtonFirstProduct = driver.findElement(FirstProduct);
        ButtonFirstProduct.click();
    }

    public void clickCantidad(int cantidad) {
        WebElement addCantidadButton = driver.findElement(AddCantidad);

        // Iterar para hacer clic en el botón de añadir cantidad la cantidad de veces especificada
        for (int i = 1; i < cantidad; i++) {
            addCantidadButton.click();
        }
    }

    public void addCarrito() {
        WebElement ButtonaddCarrito = driver.findElement(buttonAddCarrito);
        ButtonaddCarrito.click();
    }

    public void validateProduct() {
        try {
            // Esperar a que el popup esté presente
            WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopUp));
            // Verificar si el popup está presente
            if (popupElement.isDisplayed()) {
                System.out.println("El popup de confirmación está presente.");

                // Obtener el texto del nombre del producto en el popup
                WebElement productNameElement = driver.findElement(modalNameProduct);
                String productName = productNameElement.getText();

                // Verificar si el nombre del producto es igual a "Hummingbird printed t-shirt"
                String expectedProductName = "Hummingbird printed t-shirt";

                if (productName.equals(expectedProductName)) {
                    System.out.println("El producto agregado es correcto: " + productName);
                } else {
                    System.out.println("El producto agregado es incorrecto. Se esperaba: " + expectedProductName + " pero se encontró: " + productName);
                }
            }
        }catch(TimeoutException e){
            System.out.println("Error: No se encontró el elemento.");
        }
    }

    public void validateMount() {
        // Obtener el texto del precio del producto del modal
        WebElement priceElement = driver.findElement(modalPrice);
        String priceText = priceElement.getText().trim();

        // Obtener el texto de la cantidad del producto del modal
        WebElement cantElement = driver.findElement(modalCant);
        String cantText = cantElement.getText().trim();

        // Obtener el texto del monto total del producto del modal
        WebElement mountElement = driver.findElement(modalMount);
        String mountText = mountElement.getText().trim();

        // Limpiar los textos para obtener solo los valores numéricos
        double price = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
        int cant = Integer.parseInt(cantText);
        double mount = Double.parseDouble(mountText.replaceAll("[^0-9.]", ""));

        // Calcular el monto esperado multiplicando el precio por la cantidad
        double expectedMount = price * cant;

        // Verificar si el monto calculado coincide con el monto del modal
        if (mount == expectedMount) {
            System.out.println("El monto calculado es correcto: " + mount);
        } else {
            System.out.println("El monto calculado es incorrecto. Se esperaba: " + expectedMount + " pero se encontró: " + mount);
        }
    }

    public void clickBuy() {
        WebElement buyButton = driver.findElement(buttonBuy);
        buyButton.click();
    }

    public void validateCarrito(String title) {
        try {
            WebElement carritoTitleElement = driver.findElement(titlePageCarrito);
            carritoTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titlePageCarrito));
            String carritoTitle = carritoTitleElement.getText().trim();

            if (carritoTitle.equalsIgnoreCase(title)) {
                System.out.println("El título de la página es 'Carrito'.");
            } else {
                System.out.println("Error: El título de la página no es "+ title+ ". Se encontró: " + carritoTitle);
            }
        } catch (TimeoutException e) {
            System.out.println("Error: No se encontró el elemento");
        }

    }

    public void validateMountCarrito() {
        //Obtener el precio de la pagina Carrito
        WebElement priceCarritoElement = driver.findElement(carritoPrice);
        String priceCarritoText = priceCarritoElement.getText().trim();

        //Obtener la cantidad de la pagina Carrito
        WebElement cantCarritoElement = driver.findElement(carritoCant);
        String cantCarritoText = cantCarritoElement.getAttribute("value");

        //Obtener el monto total de la pagina carrito
        WebElement mountCarritoElement = driver.findElement(carritoMount);
        String mountCarritoText = mountCarritoElement.getText().trim();

        // Limpiar los textos para obtener solo los valores numéricos
        double price = Double.parseDouble(priceCarritoText.replaceAll("[^0-9.]", ""));
        int cant = Integer.parseInt(cantCarritoText);
        double mount = Double.parseDouble(mountCarritoText.replaceAll("[^0-9.]", ""));

        // Calcular el monto esperado multiplicando el precio por la cantidad
        double expectedMount = price * cant;

        // Verificar si el monto calculado coincide con el monto del modal
        if (mount == expectedMount) {
            System.out.println("El monto calculado del carrito es correcto: " + mount);
        } else {
            System.out.println("El monto calculado del carrito es incorrecto. Se esperaba: " + expectedMount + " pero se encontró: " + mount);
        }

    }
}