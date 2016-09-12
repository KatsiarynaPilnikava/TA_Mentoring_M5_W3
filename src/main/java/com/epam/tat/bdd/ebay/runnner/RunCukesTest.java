package com.epam.tat.bdd.ebay.runnner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "pretty", "junit:target/surefire-reports/TESTRunCukesTest.xml", "html:target/cucumber", "json:target/cucumber.json" }, 
		monochrome = true, 
        tags = {"~@ignore", " @run"},
        glue = { "classpath:com/epam/tat/bdd" },
        features = "src/main/resources/features/"  //refer to Feature file
)
public class RunCukesTest {
}
