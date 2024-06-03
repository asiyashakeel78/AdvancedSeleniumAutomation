package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Feature11",
	    glue = "stepDefinition11",
	    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
	    monochrome = true
	    )

public class Myrunner11 extends AbstractTestNGCucumberTests{

}
