package cucumberRunner;

import com.google.gson.Gson;
// 3. IMPORT CORREGIDO (no era el de selenium.json, era el de gson.reflect)
import com.google.gson.reflect.TypeToken;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.Environment;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class Hooks {
    public static WebDriver driver = DriverFactory.getDriver();
    public static List<Environment> environments;

    public void cargarEnviromentData(){
        String jsonData = "dataResources/datosPrueba.json";
        Gson gson = new Gson();

        try{
            InputStream datosPrueba = getClass().getClassLoader().getResourceAsStream(jsonData);
            if (datosPrueba == null) {
                throw new RuntimeException("Error al cargar el Json: No se pudo encontrar el archivo en " + jsonData);
            }
            Reader reader = new InputStreamReader(datosPrueba);

            // Esto le dice a Gson que esperamos una Lista de objetos Environment
            Type listType = new TypeToken<List<Environment>>(){}.getType();

            // Gson ahora cargará la lista en la variable 'environments'
            environments = gson.fromJson(reader,listType);
            reader.close();
        }catch (Exception e){
            throw new RuntimeException("Error al cargar el Json "+e);
        }
    }

    @Before
    public void setUp() {
        if(environments == null){
            cargarEnviromentData();
        }
        driver.getPageSource();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}