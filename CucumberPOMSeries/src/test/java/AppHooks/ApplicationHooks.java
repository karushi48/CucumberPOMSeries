package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configreader=new ConfigReader();
		prop = configreader.init_prop();
		
	}
	
	@Before(order=1)
	public void launchBrowser(){
		driverfactory=new DriverFactory();
		String browserName=prop.getProperty("browser");
		driver=driverfactory.init(browserName);
	}
	
	
	@After(order = 0)
	public void quitBroswer()
	{
		driver.quit();
	}
	
	
	@After(order = 1)
	public void teardownMethodforScreenshot(io.cucumber.java.Scenario scenario)
	{
		if(scenario.isFailed())
{			
			String screenshotname=scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotname);
	}
	}
	
}
