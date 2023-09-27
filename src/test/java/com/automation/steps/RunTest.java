package com.automation.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@DemoAutomationPracticeForm",
        features = "src/test/resources/features",
        glue = "com.automation.steps")
public class RunTest {
}
