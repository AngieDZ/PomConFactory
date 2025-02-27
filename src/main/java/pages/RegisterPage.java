package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage extends CommoActionPages {

    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[normalize-space(.)='Enter Account Information']")
    public WebElement mensajeIndicativo;

    @FindBy(id = "id_gender2")
    private WebElement botonOpcionMrs;

    @FindBy(id = "password")
    private WebElement contrasenia;

    @FindBy(id = "days")
    private WebElement seleccionarDia;

    @FindBy(id = "months")
    private WebElement seleccionarMes;

    @FindBy(id = "years")
    private WebElement seleccionarAnio;

    @FindBy(id = "newsletter")
    private WebElement casillaBoletin;

    @FindBy(id = "optin")
    private WebElement casillaVerificacion;

    @FindBy(id = "first_name")
    private WebElement inputNombre;

    @FindBy(id = "last_name")
    private WebElement inputApellido;

    @FindBy(id = "address1")
    private WebElement inputDireccion;

    @FindBy(id = "state")
    private WebElement inputEstado;

    @FindBy(id = "city")
    private WebElement inputCiudad;

    @FindBy(id = "zipcode")
    private WebElement inputPostal;

    @FindBy(id = "mobile_number")
    private WebElement inputNumero;

    @FindBy(xpath = "//button[normalize-space(.)='Create Account']")
    private WebElement botonCreate;

    @FindBy(xpath = "//h2[@data-qa='account-created']/b[contains(text(), 'Account Created!')]")
    private WebElement mensajeExitoso;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement botonContinuar;

    @FindBy(xpath = "//a[i[contains(@class, 'fa-user')]]")
    public WebElement opcionLogged;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement botonBorrar;

    @FindBy(xpath = "//b[normalize-space(text())='Account Deleted!']")
    private WebElement mensajeCuentaEliminada;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continuar;

    public void completarFormulario(String pass, String dia, String mes, String anio, String nombre,
                                    String apellido, String direccion, String estado, String ciudad,
                                    String postal, String numero) {
        esperarTiempoExplicito(mensajeIndicativo, 10);
        if (verificarElementoVisible(mensajeIndicativo)) {
            hacerClick(botonOpcionMrs);
            escribirTexto(contrasenia, pass);
            seleccionarFechaNacimiento(dia, mes, anio);
            hacerClick(casillaBoletin);
            hacerClick(casillaVerificacion);
            escribirTexto(inputNombre, nombre);
            escribirTexto(inputApellido, apellido);
            escribirTexto(inputDireccion, direccion);
            escribirTexto(inputEstado, estado);
            escribirTexto(inputCiudad, ciudad);
            escribirTexto(inputPostal, postal);
            escribirTexto(inputNumero, numero);
            hacerClick(botonCreate);
        } else {
            throw new RuntimeException("No se cargó el formulario de registro correctamente.");
        }
    }

    public void verificarCuentaCreada() {
        esperarTiempoExplicito(mensajeExitoso, 10);
        if (verificarElementoVisible(mensajeExitoso)) {
            hacerClick(botonContinuar);
            verificarElementoVisible(opcionLogged);
        } else {
            throw new RuntimeException("El mensaje de cuenta creada no apareció.");
        }
    }

    public void eliminarCuenta() {
        esperarTiempoExplicito(botonBorrar, 10);
        hacerClick(botonBorrar);

        if (verificarElementoVisible(mensajeCuentaEliminada)) {
            esperarTiempoExplicito(continuar, 10);
            hacerClick(continuar);
        } else {
            throw new RuntimeException("No se eliminó la cuenta correctamente.");
        }
    }

    private void seleccionarFechaNacimiento(String dia, String mes, String anio) {
        new Select(seleccionarDia).selectByVisibleText(dia);
        new Select(seleccionarMes).selectByVisibleText(mes);
        new Select(seleccionarAnio).selectByVisibleText(anio);
    }
}