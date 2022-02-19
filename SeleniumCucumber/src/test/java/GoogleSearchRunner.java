import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(features =  "src/test/java/feature", 
			glue= {"/Batch01/src/test/java/stepDefinition"}) 
	
	 
	public class GoogleSearchRunner {
}
