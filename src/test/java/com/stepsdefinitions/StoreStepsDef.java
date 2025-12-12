package com.stepsdefinitions;
import com.steps.StoreSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class StoreStepsDef {
    private static final Logger log = LoggerFactory.getLogger(StoreStepsDef.class);
    private WebDriver driver;
    private Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {

        // Aumentar ventana (muy importante en GitHub Actions)
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get("https://qalab.bensg.com/store/");

        // Esperar carga mínima del DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Obtener HTML
        String html = driver.getPageSource();

        System.out.println("========== HTML OBTENIDO EN GITHUB ACTIONS ==========");
        System.out.println(html.substring(0, Math.min(html.length(), 5000)));
        System.out.println("========== FIN HTML (RECORTADO) ==========");

        // Screenshot
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) throws InterruptedException {
        StoreSteps loginSteps = new StoreSteps(driver);
        loginSteps.clickIniciar();
        loginSteps.typeUser(usuario);
        loginSteps.typePassword(clave);
        loginSteps.login();
        loginSteps.validateLogin();
        screenShot();
    }

    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navegoALaCategoríaYSubcategoría(String categoria, String subcategoria) {
        StoreSteps catSubSteps = new StoreSteps(driver);
        catSubSteps.categoria(categoria);
        screenShot();
        catSubSteps.subcategoria(subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        StoreSteps addCarritoSteps = new StoreSteps(driver);
        addCarritoSteps.processAdd(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        StoreSteps validateProductSteps = new StoreSteps(driver);
        validateProductSteps.validateProduct();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        StoreSteps validateMountSteps = new StoreSteps(driver);
        validateMountSteps.validateMount();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        StoreSteps clickBuySteps = new StoreSteps(driver);
        clickBuySteps.clickBuy();
        screenShot();
    }

    @Entonces("valido el título de la página del {string}")
    public void validoElTítuloDeLaPáginaDelCarrito(String title) {
        StoreSteps validateCarritoSteps = new StoreSteps(driver);
        validateCarritoSteps.validateCarrito(title);
        screenShot();
    }

    @Y("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCálculoDePreciosEnElCarrito() {
        StoreSteps validateMountCarritoSteps = new StoreSteps(driver);
        validateMountCarritoSteps.validateMountCarrito();
    }
}