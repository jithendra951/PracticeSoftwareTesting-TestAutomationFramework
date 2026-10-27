package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DropdownUtility;

public class CartPage {

	private By proceedToCheckout_Btn1 = By.xpath("//button[@data-test='proceed-1']");
	private By proceedToCheckout_Btn2 = By.xpath("//button[@data-test='proceed-2']");
	private By proceedToCheckout_Btn3 = By.xpath("//button[@data-test='proceed-3']");
	private By payment_Dropdown = By.id("payment-method");
	private By finish_Btn = By.xpath("//button[@data-test='finish']");
	private By houseNumber_Tf = By.id("house_number");
	private By paymentSuccess_Msg = By.xpath("//div[@data-test='payment-success-message']");
	private By invoiceNumber = By.xpath("//div[@id='order-confirmation']/span");
	// payment options
	// bank transfer
	private By bankName_Tf = By.id("bank_name");
	private By accountName_Tf = By.id("account_name");
	private By accountNumber_Tf = By.id("account_number");
	// credit card
	private By cardNumber_Tf = By.id("credit_card_number");
	private By expiryDate_Tf = By.id("expiration_date");
	private By cvv_Tf = By.id("cvv");
	private By cardHolderName_Tf = By.id("card_holder_name");
	// buy now pay later
	private By monthlyInstallment_Dropdown = By.id("monthly_installments");
	// gift card
	private By giftCardNumber_Tf = By.id("gift_card_number");
	private By validationCode_Tf = By.id("validation_code");

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}


	public void proceedFromCart() {
		driver.findElement(proceedToCheckout_Btn1).click();
	}

	public void proceedFromSignin() {
		driver.findElement(proceedToCheckout_Btn2).click();
	}

	public void enterHouseNumberAndProceed(String houseNumber) {
		driver.findElement(houseNumber_Tf).sendKeys(houseNumber);
		driver.findElement(proceedToCheckout_Btn3).click();
	}

	public void clickConfirmBtn() {
		driver.findElement(finish_Btn).click();
	}

	public void paymentBankTransfer(String bankName, String accountName, String accountNumber) {
		DropdownUtility.selectByValue(driver.findElement(payment_Dropdown), "bank-transfer");
		driver.findElement(bankName_Tf).sendKeys(bankName);
		driver.findElement(accountName_Tf).sendKeys(accountName);
		driver.findElement(accountNumber_Tf).sendKeys(accountNumber);
		driver.findElement(finish_Btn).click();
	}

	public void paymentCashOnDelivery() {
		DropdownUtility.selectByValue(driver.findElement(payment_Dropdown), "cash-on-delivery");
		driver.findElement(finish_Btn).click();
	}

	public void paymentCreditCard(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
		DropdownUtility.selectByValue(driver.findElement(payment_Dropdown), "credit-card");
		driver.findElement(cardNumber_Tf).sendKeys(cardNumber);
		driver.findElement(expiryDate_Tf).sendKeys(expiryDate);
		driver.findElement(cvv_Tf).sendKeys(cvv);
		driver.findElement(cardHolderName_Tf).sendKeys(cardHolderName);
		driver.findElement(finish_Btn).click();
	}

	public void paymentBuyNowPayLater(String installmentsMonths) {
		DropdownUtility.selectByValue(driver.findElement(payment_Dropdown), "buy-now-pay-later");
		DropdownUtility.selectByValue(driver.findElement(monthlyInstallment_Dropdown), installmentsMonths);
		driver.findElement(finish_Btn).click();
	}

	public void paymentGiftCard(String giftCardNumber, String validationCode) {
		DropdownUtility.selectByValue(driver.findElement(payment_Dropdown), "gift-card");
		driver.findElement(giftCardNumber_Tf).sendKeys(giftCardNumber);
		driver.findElement(validationCode_Tf).sendKeys(validationCode);
		driver.findElement(finish_Btn).click();
	}

	public String getPaymentSuccessMsg() {
		return driver.findElement(paymentSuccess_Msg).getText();
	}

	public String getInvoiceNumber() {
		return driver.findElement(invoiceNumber).getText();
	}

}
