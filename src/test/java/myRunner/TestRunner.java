package myRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html: target/test-output.html", "json: target/test-output.js"
                , "junit: target/test-output.xml"},
        monochrome = true,
        dryRun = false
)

public class TestRunner {
}
