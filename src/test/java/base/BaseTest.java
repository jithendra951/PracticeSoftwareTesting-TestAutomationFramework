package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.CartPage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import utilities.BrowserUtility;
import utilities.ReadPropertyUtility;
import utilities.ScreenshotUtility;

public class BaseTest {
	public WebDriver driver;
	public HomePage homepg;
	public SignInPage signinpg;
	public RegistrationPage registerpg;
	public CartPage cartpg;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws IOException {
		driver = BrowserUtility.initBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ReadPropertyUtility.getProperty("url"));
		homepg = new HomePage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
		registerpg = new RegistrationPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
		signinpg = new SignInPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
		cartpg = new CartPage(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			try {
				String filename = result.getTestContext().getName() + "_"
						+ result.getTestClass().getRealClass().getSimpleName() + "_" + result.getName();
				ScreenshotUtility.webpageScreenshot(driver, filename);
			} catch (IOException e) {
				Reporter.log("exception while taking screenshot: " + e.getMessage(), true);
			}
		}
		if (driver != null) {
			driver.quit();
		}
	}

	public void completeRegistration() throws IOException {
		homepg.clickSigninButton();
		signinpg.clickRegisterAccount();
		registerpg.registerUser(1, ReadPropertyUtility.getProperty("registrationsheet"));
	}
}
