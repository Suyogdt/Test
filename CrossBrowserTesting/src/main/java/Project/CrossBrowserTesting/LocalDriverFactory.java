package Project.CrossBrowserTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class LocalDriverFactory  
{
	static WebDriver createInstance(String browserName) {
		WebDriver driver = null;
		if (browserName.toLowerCase().contains("firefox")) {
			driver = getFireFoxDriver();
			return driver;
		}
		if (browserName.toLowerCase().contains("chrome")) {
			driver = getChromeDriver();
			return driver;
		}
		return driver;
	}



	private static WebDriver getFireFoxDriver(){
		WebDriver wd;
		String path = "./src/resources/Drivers/Gecko/64/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", path);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.tabs.remote.autostart.2", false);
		wd = new FirefoxDriver(profile);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.manage().deleteAllCookies();
		return wd;
	}

	private static WebDriver getChromeDriver(){
		WebDriver wd;
		String path = ".src/resources/Drivers/Chrome/64/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.manage().deleteAllCookies();
		return wd;
	}
}
