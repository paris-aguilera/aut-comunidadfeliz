
package cucumberRunner;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        tags = "@fechaFacturacion-activada",
        //tags = "@fechaFacturacion-desactivado",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class TestRunner {


}
