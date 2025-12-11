package com.nttdata.steps;
import com.nttdata.page.StorePage;
import org.openqa.selenium.WebDriver;

public class StoreSteps {

    private WebDriver driver;
    StorePage page;

    public StoreSteps(WebDriver driver){
        this.driver = driver;
        page = new StorePage(driver);
    }

    public void clickIniciar() throws InterruptedException {
        page.clickButtonIniciarSesion();
    }


    public void typeUser(String usuario) {
        page.typeUser(usuario);
    }

    public void typePassword(String clave) {
        page.typePassword(clave);
    }

    public void login() {
        page.clickIniciarSesion();
    }

    public void validateLogin() {
        page.validateLogin();
    }

    public void categoria(String categoria) {
        page.clickCategoria();
        page.validateCategoria(categoria);
    }

    public void subcategoria(String subcategoria) {
        page.clickSubCategoria();
        page.validateSubCategoria(subcategoria);
    }


    public void processAdd(int cantidad) {
        page.clickFirstProduct();
        page.clickCantidad(cantidad);
        page.addCarrito();

    }

    public void validateProduct() {
        page.validateProduct();
    }

    public void validateMount() {
        page.validateMount();
    }

    public void clickBuy() {
        page.clickBuy();
    }

    public void validateCarrito(String title) {
        page.validateCarrito(title);
    }

    public void validateMountCarrito() {
        page.validateMountCarrito();
    }
}