package qa.af.dbb.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/main/resources/bdd-scenarios", 
glue= {"qa.af.bdd.stepdef"}, 
plugin = {"pretty", "html:target/cucumber" ,"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin"})
public class CucumberTest {

}
