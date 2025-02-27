import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AutomationTest extends BaseTest {

    @Test
    public void testRegistroExitoso() {

        homePages.clickBotonSignupLogin();
        signupPage.registrarUsuario("usuarioPrueba12", "usuario12@test.com");

        Assertions.assertTrue(registerPage.verificarElementoVisible(registerPage.mensajeIndicativo),
                "El mensaje indicativo de registro no es visible.");

        registerPage.completarFormulario(
                "Password123!", "15", "June", "1995",
                "Juan", "Pérez", "Calle 123",
                "Estado", "Ciudad", "12345", "555123456"
        );

        registerPage.verificarCuentaCreada();
        Assertions.assertTrue(registerPage.verificarElementoVisible(registerPage.opcionLogged),
                "El usuario no aparece como 'Logged' después del registro.");

        registerPage.eliminarCuenta();
    }

    @Test
    public void testDatosIncorrectos(){

        homePages.clickBotonSignupLogin();

        signupPage.loginIncorrecto("usuario1@test.com", "abcdef");
        signupPage.verificarDatosIncorrectos();
    }

    @Test
    public void testBusquedaProductos(){
       homePages.clickBotonProducto();
       allProducts.buscarProducto("Summer");
    }

    @Test
    public void testFormularioDeContacto(){
        homePages.clickBotonContacto();
        contactPage.llenarFormularion("Usuario1",
                "usuario1@test.com",
                "Talla pequeña",
                "Hola, quisiera obtener más información sobre la devolución",
                "C:\\Users\\DELL\\Downloads\\circular mal uso de los shut.png");

        contactPage.enviarFormulario();
        Assertions.assertTrue(contactPage.verificarMensajeExito(),
                "El mensaje de éxito no apareció.");
        contactPage.regresarInicio();
    }
}
