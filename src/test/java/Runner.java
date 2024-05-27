import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "Steps",
        plugin = {"pretty", "html:src/reports/cucumber-reports.html"}
)
public class Runner {
}
