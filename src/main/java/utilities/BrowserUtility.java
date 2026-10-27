package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserUtility {
	// initBrowser - intialize browser or method name can be given as browserSetup()
	public static WebDriver initBrowser(String browser) {
		switch (browser) {
		case "chrome":
			return new ChromeDriver(chromeOptions());
		case "firefox":
			return new FirefoxDriver(firefoxOptions());
		case "edge":
			return new EdgeDriver(edgeOptions());
		}
		return new ChromeDriver(chromeOptions());// if the input is invalid chrome will be the default
	}

	// browser options
	public static ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		return options;
	}

	public static FirefoxOptions firefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("-private-window");
		return options;
	}

	public static EdgeOptions edgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inprivate");
		return options;
	}
}
