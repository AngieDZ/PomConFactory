package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CommoActionPages {

    protected WebDriver driver;
    public CommoActionPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void visitarPagina(String url){

        driver.get(url);
    }
    public void limpiarCajaTexto(WebElement elemento){

        elemento.clear();
    }
    public void escribirTexto(WebElement elemento, String texto){

        elemento.sendKeys(texto);
    }
    public void hacerClick(WebElement elemento){

        elemento.click();
    }
    public boolean verificarElementoVisible(WebElement elemento){

        try {
            return elemento.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void esperarTiempoExplicito(WebElement elemento, int segundos) {
        new WebDriverWait(driver, Duration.ofSeconds(segundos))
                .until(ExpectedConditions.visibilityOf(elemento));
    }
    public void verificarPaginaDeInicio(WebElement elemento){
        esperarTiempoExplicito(elemento, 10);
        verificarElementoVisible(elemento);
    }
}
