import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"summary", "pretty", "html:FeaturesReport"},
        features = {"src/test/resources/features"},
        glue = {"stepdefinition"}
)
public class CucumberConfigTest{
}