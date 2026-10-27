package pages;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DropdownUtility;
import utilities.MouseActionsUtility;

public class RegistrationPage {

	private By firstname_Tf = By.id("first_name");
	private By lastname_Tf = By.id("last_name");
	private By dob_Tf = By.id("dob");
	private By countryDropdown = By.id("country");
	private By postalCode_Tf = By.id("postal_code");
	private By houseNumber_Tf = By.id("house_number");
	private By phone_Tf = By.id("phone");
	private By email_Tf = By.id("email");
	private By password_Tf = By.id("password");
	private By showPassword = By.xpath("//div[@class='input-group-append']");
	private By register_Btn = By.xpath("//button[@type='submit']");
	private By registerError = By.xpath("//div[@data-test='register-error']/div/div");

	public String emailId;
	public String password;
	public String houseNumber;
	String[] userdetails;

	WebDriver driver;
	WebDriverWait wait;

	public RegistrationPage(WebDriver driver, WebDriverWait wait, String[] userdetails) {
		this.driver = driver;
		this.wait = wait;
		this.userdetails = userdetails;
		emailId = randomEmail();
		password = randomPassword();
	}

	public void createUser() throws IOException {
		driver.findElement(firstname_Tf).sendKeys(userdetails[0]);
		driver.findElement(lastname_Tf).sendKeys(userdetails[1]);
		driver.findElement(dob_Tf).sendKeys(userdetails[2]);
		if (userdetails[3].length() == 2) {
			DropdownUtility.selectByValue(driver.findElement(countryDropdown), userdetails[3]);
		} else {
			DropdownUtility.selectByVisibleText(driver.findElement(countryDropdown), userdetails[3]);
		}
		driver.findElement(postalCode_Tf).sendKeys(userdetails[4]);
		houseNumber = userdetails[5];
		driver.findElement(houseNumber_Tf).sendKeys(houseNumber);
		driver.findElement(phone_Tf).sendKeys(userdetails[6]);
		driver.findElement(email_Tf).sendKeys(emailId);
		driver.findElement(password_Tf).sendKeys(password);
		driver.findElement(showPassword).click();
		driver.findElement(showPassword).click();
		MouseActionsUtility.scrollDown(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(register_Btn));
		driver.findElement(register_Btn).click();
	}

	public String getRegisterErrorMsg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(registerError));
		return driver.findElement(registerError).getText();
	}

	Random random = new Random();
	String lower_char = "abcdefghijklmnopqrstuvwxyz";
	String upper_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String numbers = "0123456789";
	String special_Char = "!@#$%^&*()~`-=_+<>?,./";

	public String randomEmail() {
		String emailId = "";
		for (int i = 0; i < 5; i++) {
			emailId += lower_char.charAt(random.nextInt(lower_char.length()));
			emailId += numbers.charAt(random.nextInt(numbers.length()));
		}
		return emailId + "@gmail.com";
	}

	public String randomPassword() {
		String password = "";
		for (int i = 0; i < 5; i++) {
			password += lower_char.charAt(random.nextInt(lower_char.length()));
		}
		password += numbers.charAt(random.nextInt(numbers.length()));
		password += special_Char.charAt(random.nextInt(special_Char.length()));
		password += upper_char.charAt(random.nextInt(upper_char.length()));
		return password;
	}

}