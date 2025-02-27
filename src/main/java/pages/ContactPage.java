package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage extends CommoActionPages{

    public ContactPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[text()='Get In Touch']")
    private WebElement etiquetaGetInTouch;

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement inputNombre;

    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElement inputAsunto;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    private WebElement inputMensaje;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement inputArchivo;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElement botonEnviar;

    @FindBy(xpath = "//div[contains(@class, 'status') and contains(@class, 'alert-success')]")
    private WebElement etiquetaExito;

    @FindBy(xpath = "//a[contains(@class, 'btn-success') and contains(@href, '/')]")
    private WebElement botonInicio;

    @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
    private WebElement imgInicio;

    public void llenarFormularion(String nombre, String email, String asunto, String mensaje, String rutaArchivo) {

        esperarTiempoExplicito(etiquetaGetInTouch, 10);

        if (!verificarElementoVisible(etiquetaGetInTouch)) {
            throw new RuntimeException("El mensaje 'Get In Touch' no está visible.");
        }

            limpiarCajaTexto(inputNombre);
            escribirTexto(inputNombre, nombre);

            limpiarCajaTexto(inputEmail);
            escribirTexto(inputEmail, email);

            limpiarCajaTexto(inputAsunto);
            escribirTexto(inputAsunto, asunto);

            limpiarCajaTexto(inputMensaje);
            escribirTexto(inputMensaje, mensaje);

            if(rutaArchivo != null && !rutaArchivo.isEmpty()){
                cargarArchivo(inputArchivo, rutaArchivo);
            }
    }
    private void cargarArchivo(WebElement elemento, String rutaArchivo) {
        esperarTiempoExplicito(elemento, 10);
        inputArchivo.sendKeys(rutaArchivo);
    }

    public void enviarFormulario() {
        hacerClick(botonEnviar);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean verificarMensajeExito() {
        esperarTiempoExplicito(etiquetaExito, 10);
        return verificarElementoVisible(etiquetaExito);
    }

    public void regresarInicio() {
        hacerClick(botonInicio);
        verificarPaginaDeInicio(imgInicio);
    }

}