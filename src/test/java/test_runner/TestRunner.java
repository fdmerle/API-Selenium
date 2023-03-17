package test_runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin= {"pretty", "html:target/Destination.html"},
        features = "src/test/java/features",
        glue = {"step_definitions"},
        tags = ("@Automated and not @NotAutomated")
)
public class TestRunner {

}
