package Apphooks;


	import java.io.IOException;
	import java.util.Properties;

	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	import com.driver.Driverfactory;
	import com.qa.utilities.configReader;

	import io.cucumber.java.Scenario;

	import org.testng.annotations.Parameters;


	public class ApplicationHooks {
		private Driverfactory driverfactory;
		private WebDriver driver;
		private configReader configReader;
		Properties prop;
		
		@Before(order = 0)
		public void getProperty() throws IOException{
			configReader =new configReader();
			prop =configReader.init_prop();
		}	
		@Before(order = 1)
		public void launchBrowser() {
			String browserName = prop.getProperty("browser");
			driverfactory = new Driverfactory();
			driver = driverfactory.init_driver(browserName);
			
			}
		@After(order = 0)
		public void quitBrowser() {
		driver.quit();
		}
		@After(order = 1)
		public void tearDown(Scenario scenario) throws IOException{
			if(scenario.isFailed()) {
				//take screenshot
				String screenshotName = scenario.getName().replaceAll("", "");
				byte[] sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcepath, "image/png", screenshotName);
			}
			
		}
	}



