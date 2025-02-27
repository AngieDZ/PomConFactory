package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePages extends CommoActionPages{
    public HomePages(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement botonSignupLogin;

    @FindBy(xpath = "//a[normalize-space(text())='Products']")
    private WebElement botonProducto;

    @FindBy(xpath = "//a[@href='/contact_us' and contains(text(), 'Contact us')]")
    private WebElement botonContacto;

    public void clickBotonSignupLogin() {
        esperarTiempoExplicito(botonSignupLogin, 10);
        hacerClick(botonSignupLogin);
    }

    public void clickBotonProducto() {
        esperarTiempoExplicito(botonProducto, 10);
        hacerClick(botonProducto);
    }

    public void clickBotonContacto() {
        esperarTiempoExplicito(botonContacto, 10);
        hacerClick(botonContacto);
    }
}
