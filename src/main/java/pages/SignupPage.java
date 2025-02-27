package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends CommoActionPages{
    public SignupPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space(.)='New User Signup!']")
    private WebElement mensajeIndicativo;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNombre;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement botonSignup;

    @FindBy(xpath = "//h2[normalize-space(.)='Login to your account']")
    private WebElement mensajeIndicativoLogin;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement inputEmailLogin;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement inputContrasenia;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement botonLogin;

    @FindBy(xpath = "//p[normalize-space(text())='Your email or password is incorrect!']")
    private WebElement mensajeDatosIncorrectos;


    public void registrarUsuario(String nombre, String email) {
        esperarTiempoExplicito(mensajeIndicativo, 10);

        if (verificarElementoVisible(mensajeIndicativo)) {
            limpiarCajaTexto(inputNombre);
            escribirTexto(inputNombre, nombre);

            limpiarCajaTexto(inputEmail);
            escribirTexto(inputEmail, email);

            hacerClick(botonSignup);
        } else {
            throw new RuntimeException("El mensaje '¡Registro de nuevo usuario!' no está visible.");
        }
    }

    public void loginIncorrecto (String email, String pass) {

        esperarTiempoExplicito(mensajeIndicativoLogin, 10);

        if (verificarElementoVisible(mensajeIndicativoLogin)) {
            limpiarCajaTexto(inputEmailLogin);
            escribirTexto(inputEmailLogin, email);

            limpiarCajaTexto(inputContrasenia);
            escribirTexto(inputContrasenia, pass);

            hacerClick(botonLogin);
        } else {
            throw new RuntimeException("El mensaje '¡Login to your account!' no está visible.");
        }
    }
    public boolean verificarDatosIncorrectos() {
        esperarTiempoExplicito(mensajeDatosIncorrectos, 10);
        return verificarElementoVisible(mensajeDatosIncorrectos);
    }
}
