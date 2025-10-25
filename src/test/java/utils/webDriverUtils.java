package utils;

import cucumberRunner.DriverFactory;
import cucumberRunner.Hooks;
import io.cucumber.messages.types.Hook;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.awaitility.Awaitility.await;


public class webDriverUtils {

    // Declaracion metodo para validar que esperara X tiempo por X elemento, si existe retorna el objeto y si no existe , lanzara error
    public void esperarElementoVisible(WebElement ele, int segundos) {
        try {
            System.out.println("Esperando al elemento: "+ele);
            await()
                    .atMost(Duration.ofSeconds(segundos))
                    .pollInterval(Duration.ofMillis(500))

                    .ignoreExceptionsInstanceOf(NoSuchElementException.class)
                    .ignoreExceptionsInstanceOf(StaleElementReferenceException.class)
                    .ignoreExceptionsInstanceOf(NullPointerException.class)
                    .ignoreExceptionsInstanceOf(WebDriverException.class)
                    .until(() -> ele.isDisplayed());
        } catch (ConditionTimeoutException e) {
            throw new RuntimeException("Elemento no se hizo VISIBLE despues de " + segundos + " segundos.", e);
        }
    }

    public Environment environmentByUser(String username){
        // Obtenemos los datos segun user del json datosPrueba.json
        List<Environment> datosPrueba = Hooks.environments;

        Optional<Environment> datosPruebaByUser = datosPrueba.stream()
                .filter(env -> env.getUser().equals(username))
                .findFirst();

        // Error si no existe el user en el .json
        return datosPruebaByUser.orElseThrow(
                () -> new RuntimeException("No se encontró el usuario '" + username + "' en datosPrueba.json")
        );
    }

}
