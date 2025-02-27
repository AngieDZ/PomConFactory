package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProducts extends CommoActionPages{

    public AllProducts(WebDriver driver){
    super(driver);
    PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[normalize-space(text())='All Products']")
    private WebElement etiquetaAll;
    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement inputBusqueda;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement botonBusqueda;

    @FindBy(xpath = "//h2[@class='title text-center' and text()='Searched Products']")
    private WebElement etiquetaSearched;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    private List<WebElement> productosRelacionados;

    public void buscarProducto(String producto){

        if(verificarElementoVisible(etiquetaAll)){

            limpiarCajaTexto(inputBusqueda);
            escribirTexto(inputBusqueda, producto);
            hacerClick(botonBusqueda);

            if(!verificarElementoVisible(etiquetaSearched)){
                throw new RuntimeException("La etiqueta 'Searched Products' no está visible.");
            }
            verificarProductoRelacionado(producto);
        } else {
            throw new RuntimeException("Todos los productos no estan visible.");
        }
    }

    private void verificarProductoRelacionado(String productoEsperado) {

        if (productosRelacionados.isEmpty()){
            throw new RuntimeException("No se encontro producto relacionado con la busqueda.");
        }
        for (WebElement producto : productosRelacionados){
            String nombreProducto = producto.getText().trim();

            if (nombreProducto.toLowerCase().contains(productoEsperado.toLowerCase())){
                return;
            }
        }
        throw new RuntimeException("No se encontró coincidencia con: " + productoEsperado);
    }
}
