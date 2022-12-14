package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/Cucumber",glue="Cucumber.stepDefinition",monochrome=true,plugin= {"html:target/Cucmber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
}
