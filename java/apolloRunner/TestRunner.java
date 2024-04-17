package apolloRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resource\\Features",
glue="apollo_StepDefinition",tags="@ApolloDoctors",
plugin= {("pretty")
		,"html:target/HTMLReports/TopSpecialities.html"
		,"json:target/JSONReports/TopSpecialities.json"
		,"junit:target/JUNITReports/TopSpecialities.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
 
}
