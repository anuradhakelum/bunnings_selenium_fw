package myRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//run all the feature files
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature", //feature file location
        glue = {"stepDefinitions"}, //step definition folder
        plugin = {"pretty", "html: output/test-output.html", "json: output/test-output.js"
                , "junit: output/test-output.xml"}, // generate reports based on the config
        monochrome = true, // console outputs are more readable
        dryRun = false // compile feature file and step definition and compilation errors
)

public class TestRunner {
}
