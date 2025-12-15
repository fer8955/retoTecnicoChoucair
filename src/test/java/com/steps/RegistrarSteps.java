package com.steps;
import com.page.RegistrarPage;
import org.openqa.selenium.WebDriver;


public class RegistrarSteps {

    private WebDriver driver;
    RegistrarPage page;

    public RegistrarSteps(WebDriver driver){
        this.driver = driver;
        page = new RegistrarPage(driver);
    }

    public void clickRegistrar() throws InterruptedException {
        page.clickButtonRegistrar();
    }

    public void selccionarGenero(String genero) throws InterruptedException {
        page.seleccionarGenero(genero);
    }

    public void completarNombreUsuario(String nombre) {
        page.completarNombreUsuario(nombre);
    }

    public void completarApellidoUsuario(String apellido) {
        page.completarApellidoUsuario(apellido);
    }

    public void completarCorreoUsuario(String correo) {
        page.completarCorreoUsuario(correo);
    }

    public void completarContrasenia(String contrasenia) {
        page.completarContrasenia(contrasenia);
    }

    public void confirmarContrasenia(String contrasenia) {
        page.confirmarContrasenia(contrasenia);
    }

    public void clickRegistrarUsuario() {
        page.clickBotonRegistrarUsuario();
    }

    public void validarTituloRegistro() {
        page.validarTituloRegistro();
    }
}
