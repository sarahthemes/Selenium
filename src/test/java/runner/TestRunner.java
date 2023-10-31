package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features="src/test/java/features"
,glue= {"steps"}
,plugin= {"prettey","html:tsrget/cucumber-html-report"}
)
public class TestRunner {


}