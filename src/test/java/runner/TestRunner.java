package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

		@RunWith(Cucumber.class)
		@CucumberOptions(
				features ="classpath:features",
				glue = { "stepDefination" }, monochrome = true, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:cucumber-reports/report.html"})

		public class TestRunner {
			
		}