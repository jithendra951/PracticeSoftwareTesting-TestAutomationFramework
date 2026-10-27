package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.CartPage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import utilities.BrowserUtility;
import utilities.ReadDataUtility;
import utilities.ReadPropertyUtility;

public class BasePage {
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
		driver.get(ReadPropertyUtility.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homepg = new HomePage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
		registerpg = new RegistrationPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)),
				ReadDataUtility.getUserDetails(1));
		signinpg = new SignInPage(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
		cartpg = new CartPage(driver);
		homepg.clickSigninButton();
		signinpg.clickRegisterAccount();
		registerpg.createUser();
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}
}
