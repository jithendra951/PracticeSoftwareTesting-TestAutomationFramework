package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadDataUtility;
import utilities.ReadPropertyUtility;

public class LocalizationTest extends BaseTest {

	@Test(priority = 1)
	public void germanLanguage() throws IOException {
		String[] languageData = ReadDataUtility.getRowData(1, ReadPropertyUtility.getProperty("languagesheet"));
		homepg.changeLanguage(languageData[0]);
		orderProduct(languageData[1], languageData[2]);
	}

	@Test(priority = 2)
	public void greekLanguage() throws IOException {
		String[] languageData = ReadDataUtility.getRowData(2, ReadPropertyUtility.getProperty("languagesheet"));
		homepg.changeLanguage(languageData[0]);
		orderProduct(languageData[1], languageData[2]);
	}

	@Test(priority = 3)
	public void spanishLanguage() throws IOException {
		String[] languageData = ReadDataUtility.getRowData(3, ReadPropertyUtility.getProperty("languagesheet"));
		homepg.changeLanguage(languageData[0]);
		orderProduct(languageData[1], languageData[2]);
	}

	@Test(priority = 4)
	public void frenchLanguage() throws IOException {
		String[] languageData = ReadDataUtility.getRowData(4, ReadPropertyUtility.getProperty("languagesheet"));
		homepg.changeLanguage(languageData[0]);
		orderProduct(languageData[1], languageData[2]);
	}

	@Test(priority = 5)
	public void dutchLanguage() throws IOException {
		String[] languageData = ReadDataUtility.getRowData(5, ReadPropertyUtility.getProperty("languagesheet"));
		homepg.changeLanguage(languageData[0]);
		orderProduct(languageData[1], languageData[2]);
	}

	@Test(priority = 6)
	public void turkishLanguage() throws IOException {
		String[] languageData = ReadDataUtility.getRowData(6, ReadPropertyUtility.getProperty("languagesheet"));
		homepg.changeLanguage(languageData[0]);
		orderProduct(languageData[1], languageData[2]);
	}

	public void orderProduct(String accountTitle, String addedToCartMsg) throws IOException {
		completeRegistration();
		signinpg.login(registerpg.emailId, registerpg.password);
		Assert.assertEquals(signinpg.getLoginSuccessMsg(), accountTitle);
		homepg.clickHomeButton();
		homepg.selectProduct(ReadPropertyUtility.getProperty("productname"));
		homepg.clickAddToCart(ReadPropertyUtility.getProperty("productquantity"));
		Assert.assertEquals(homepg.getAddedToCartMsg(), addedToCartMsg);
		homepg.clickCartButton();
		cartpg.proceedFromCart();
		cartpg.proceedFromSignin();
		cartpg.enterHouseNumberAndProceed(registerpg.houseNumber);
		cartpg.paymentCashOnDelivery();
		Assert.assertEquals(cartpg.getPaymentSuccessMsg(), "Payment was successful");
		cartpg.clickConfirmBtn();
		Assert.assertNotNull(cartpg.getInvoiceNumber());
		homepg.clickLogoutButton();
	}

}