package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.MouseActionsUtility;

public class SignInPage {

	private By email_Tf = By.id("email");
	private By password_Tf = By.id("password");
	private By login_Btn = By.xpath("//input[@type='submit']");
	private By registerAccount_Link = By.xpath("//a[@aria-label='Register your account']");
	private By loginHeader = By.xpath("//div[@class='col-lg-6 auth-form']/h3");
	private By myAccountHeader = By.xpath("//h1[@data-test='page-title']");

	WebDriver driver;
	WebDriverWait wait;

	public SignInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void clickRegisterAccount() {
		MouseActionsUtility.scrollElementToBottom(driver, driver.findElement(registerAccount_Link));
		wait.until(ExpectedConditions.elementToBeClickable(registerAccount_Link));
		driver.findElement(registerAccount_Link).click();
	}

	public void login(String email, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
		driver.findElement(email_Tf).sendKeys(email);
		driver.findElement(password_Tf).sendKeys(password);
		driver.findElement(login_Btn).click();
	}

	public String getLoginSuccessMsg() {
		return driver.findElement(myAccountHeader).getText();
	}
}