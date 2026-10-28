package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.MouseActionsUtility;

public class HomePage {

	private By home_Btn = By.xpath("//a[@data-test='nav-home']");
	private By SingIn_Btn = By.xpath("//a[@data-test='nav-sign-in']");
	private By Cart_Btn = By.xpath("//a[@href='/checkout']");
	private By profile_Options = By.id("menu");
	private By logout_Btn = By.xpath("//a[@data-test='nav-sign-out']");
	private By language_Dropdown = By.id("language");
	private By productLists = By.xpath("//a[@class='card']//h5");
	private By languages = By.xpath("//a[starts-with(@data-test,'lang-')]");
	private By addToCart_Btn = By.id("btn-add-to-cart");
	private By quantity_Tf = By.id("quantity-input");
	private By productAdded_alert = By.xpath("//div[@role='alert']");

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void clickHomeButton() {
		driver.findElement(home_Btn).click();
	}

	public void clickSigninButton() {
		driver.findElement(SingIn_Btn).click();
	}

	public void clickCartButton() {
		driver.findElement(Cart_Btn).click();
	}
	
	public void changeLanguage(String language) {
		driver.findElement(language_Dropdown).click();
		for(WebElement element : driver.findElements(languages)) {
			if(element.getText().equalsIgnoreCase(language)) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				break;
			}
		}
	}

	public void selectProduct(String productName) {
		for (WebElement element : driver.findElements(productLists)) {
			if (element.getText().equalsIgnoreCase(productName)) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				break;
			}
		}
	}

	public void clickAddToCart(String quantity) {
		wait.until(ExpectedConditions.elementToBeClickable(quantity_Tf));
		MouseActionsUtility.scrollDown(driver, 500);
		driver.findElement(quantity_Tf).clear();
		driver.findElement(quantity_Tf).sendKeys(quantity);
		driver.findElement(addToCart_Btn).click();
	}

	public String getAddedToCartMsg() {
		wait.until(ExpectedConditions.elementToBeClickable(productAdded_alert));
		String productAdded_msg = driver.findElement(productAdded_alert).getText();
		driver.findElement(productAdded_alert).click();
		return productAdded_msg;
	}

	public void clickLogoutButton() {
		driver.findElement(profile_Options).click();
		driver.findElement(logout_Btn).click();
	}
}
