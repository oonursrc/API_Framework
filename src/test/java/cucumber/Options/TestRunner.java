package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json", glue = { "stepDefinitions" })  
// add tags= {"@DeletePlace"} to run only delete place test
public class TestRunner {

}


//mvn test -Dcucumber.options="--tags @AddPlace"  from console to run only addplace test


//for reporting refer to
//https://github.com/damianszczepanik/maven-cucumber-reporting
// run as  "mvn test verify"