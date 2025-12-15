package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrarPage {

    private WebDriverWait wait;
    private WebDriver driver;


    public RegistrarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Espera explícita con un timeout de 5 segundos
    }

    // Localizador para el botón "Registrar"
    private static By botonRegistrar = By.xpath("//a[@class='ico-register']");

    // Localizador para seleccionar datos

    private static By selectGeneroM = By.id("gender-male");
    private static By selectGeneroF = By.id("gender-female");

    private static By inputNombre = By.id("FirstName");
    private static By inputApellido = By.id("LastName");
    private static By inputCorreo = By.id("Email");
    private static By inputContrasenia = By.id("Password");
    private static By inputConfirmarContrasenia = By.id("ConfirmPassword");

    private static By botonRegistrarUsuario = By.id("register-button");

    private static By mensajeRegistro = By.xpath("//div[@class='page-body']//div[@class='result']");


    // Método para hacer clic en el botón "Register"
    public void clickButtonRegistrar() throws InterruptedException {
        WebElement registrarButton = driver.findElement(botonRegistrar);
        registrarButton.click();

    }


    public void seleccionarGenero(String genero) throws InterruptedException{
        WebElement generoM = driver.findElement(selectGeneroM);
        WebElement generoF = driver.findElement(selectGeneroF);

        if ("M".equals(genero)) {
            generoM.click();
        } else if ("F".equals(genero)) {
            generoF.click();
        }

    }

    public void completarNombreUsuario(String nombre) {
        WebElement nombreUsuario = driver.findElement(inputNombre);
        nombreUsuario.sendKeys(nombre);
    }

    public void completarApellidoUsuario(String apellido) {
        WebElement apellidoUsuario = driver.findElement(inputApellido);
        apellidoUsuario.sendKeys(apellido);
    }

    public void completarCorreoUsuario(String corrreo) {
        String email = "test" + System.currentTimeMillis() + "@mail.com";
        driver.findElement(inputCorreo).sendKeys(email);
    }

    public void completarContrasenia(String contrasenia) {
        WebElement passwordUsuario = driver.findElement(inputContrasenia);
        passwordUsuario.sendKeys(contrasenia);
    }

    public void confirmarContrasenia(String contrasenia) {
        WebElement confirmarPasswordUsuario = driver.findElement(inputConfirmarContrasenia);
        confirmarPasswordUsuario.sendKeys(contrasenia);
    }

    public void clickBotonRegistrarUsuario() {
        WebElement registrarUsuarioButton = driver.findElement(botonRegistrarUsuario);
        registrarUsuarioButton.click();
    }

    public void validarTituloRegistro() {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("body"),
                "Your registration completed"
        ));

        assertTrue(driver.getPageSource().contains("Your registration completed"));
    }


}