package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Feature/Leaftap.feature",
				glue="steps",
				monochrome=true, 
				publish=true)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
}
