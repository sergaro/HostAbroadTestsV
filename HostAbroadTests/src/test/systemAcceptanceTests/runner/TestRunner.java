package systemAcceptanceTests.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


/**
 * This class is used to configured the execution of the tests
 * 
 * Only the author can modify this class.
 * @author Gasan Nazer
 * **/

@RunWith(Cucumber.class)
@CucumberOptions(
features ="src/test/systemAcceptanceTests/features"
,glue= "systemAcceptanceTests.seleniumgluecode",
plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
		 "junit:target/cucumber-reports/Cucumber.xml",
		 "html:target/cucumber-reports",
		 "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true
)
public class TestRunner {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    }
}
