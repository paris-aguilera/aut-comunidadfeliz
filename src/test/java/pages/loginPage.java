package pages;

import cucumberRunner.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// Importa PageFactory
import org.openqa.selenium.support.PageFactory;
import utils.webDriverUtils;

public class loginPage {
    WebDriver driver;
    public webDriverUtils utils = new webDriverUtils();

    public loginPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement userInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnIniciarSesion;

    public void ingresoLogin(String user, String pass){

        utils.esperarElementoVisible(userInput,30);
        utils.esperarElementoVisible(passInput,30);
        utils.esperarElementoVisible(btnIniciarSesion,30);

        userInput.sendKeys(user);
        passInput.sendKeys(pass);
        btnIniciarSesion.click();
    }
}