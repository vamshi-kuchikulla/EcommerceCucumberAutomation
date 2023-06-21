package org.cst;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ="src/test/java/org/cst/feature",
        glue = "org/cst/stepDefinations",
        monochrome = true,
        tags = "@Sanity",
        plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
