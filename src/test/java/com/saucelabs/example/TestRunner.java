package com.saucelabs.example;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import gherkin.formatter.model.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", glue = {"com/saucelabs/example/stepdefs"},
//        tags = {"~@Ignored"},
//        tags = {"@buyaphone"},
//        tags = {"@findastore"},
//        tags = {"@navigation"},
        tags = {"@getaquote"},
        snippets = SnippetType.CAMELCASE, format = {
//                "pretty:target/cucumber-reports/cucumber-pretty.txt",
//                "html:target/cucumber-reports/cucumber-html-report",
//                "junit:target/cucumber-reports/junit.xml",
        "json:target/cucumber-reports/cucumber.json", "rerun:target/cucumber-reports/rerun.txt", "usage:target/cucumber-reports/cucumber-usage.json"})
public class TestRunner
{
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass()
    throws Exception
    {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeatureWrapper)
    {
        CucumberFeature cucumberFeature = cucumberFeatureWrapper.getCucumberFeature();
        Feature feature = cucumberFeature.getGherkinFeature();
        testNGCucumberRunner.runCucumber(cucumberFeature);
    }

    @DataProvider
    public Object[][] features()
    {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass()
    throws Exception
    {
        testNGCucumberRunner.finish();
    }
}