package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class runners extends AbstractTestNGCucumberTests {
}
