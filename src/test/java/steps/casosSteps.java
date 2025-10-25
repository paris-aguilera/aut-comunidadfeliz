package steps;

import cucumberRunner.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.loginPage;
import utils.Environment;
import utils.webDriverUtils;

public class casosSteps {

    webDriverUtils webUtils;
    WebDriver driver;
    loginPage login = new loginPage();

    public casosSteps() {
        this.driver = DriverFactory.getDriver();
        this.webUtils = new webDriverUtils();
    }
    @Given("El usuario {string} ingresa a comunidadfeliz")
    public void elUsuarioIngresaAComunidadfeliz(String user) {
        Environment env = webUtils.environmentByUser(user);
        // Ingresamos al ambiente segun el user
        driver.get(env.getUrl());
        // Ingresamos el login con user y pass
        login.ingresoLogin(env.getUser(),env.getPass());
    }
}
