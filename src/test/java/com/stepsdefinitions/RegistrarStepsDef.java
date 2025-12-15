package com.stepsdefinitions;
import com.steps.RegistrarSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
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

public class RegistrarStepsDef {
    private static final Logger log = LoggerFactory.getLogger(RegistrarStepsDef.class);
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

    @Dado("estoy en la pagina principal")
    public void estoyEnLaPaginaPrincipal() {

        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get("https://demowebshop.tricentis.com/");

        // Esperar carga mínima del DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Screenshot
        screenShot();

    }

    @Y("doy clic en la opción Register")
    public void doyClicEnLaOpciónRegister() throws InterruptedException {
        RegistrarSteps registrarSteps = new RegistrarSteps(driver);
        registrarSteps.clickRegistrar();
    }

    @Cuando("ingreso mis datos de registro {string} {string} {string} {string} {string}")
    public void ingresoMisDatosDeRegistro(String genero, String nombre, String apellido, String correo, String contrasenia) throws InterruptedException {
        RegistrarSteps ingresarDatos = new RegistrarSteps(driver);
        ingresarDatos.selccionarGenero(genero);
        ingresarDatos.completarNombreUsuario(nombre);
        ingresarDatos.completarApellidoUsuario(apellido);
        ingresarDatos.completarCorreoUsuario(correo);
        ingresarDatos.completarContrasenia(contrasenia);
        ingresarDatos.confirmarContrasenia(contrasenia);
        ingresarDatos.clickRegistrarUsuario();
    }

    @Entonces("valido la creacion del usuario")
    public void validoLaCreacionDelUsuario() {
        RegistrarSteps validarTitulo = new RegistrarSteps(driver);
        validarTitulo.validarTituloRegistro();
    }


}