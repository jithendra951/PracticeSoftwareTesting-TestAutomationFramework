package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadPropertyUtility;

public class PaymentsTest extends BaseTest {

	@Test
	public void bankTransfer() throws IOException {
		proceedTillPayment();
		cartpg.paymentBankTransfer("AXIS Bank", "SB Account", "10095160936193");
		Assert.assertEquals(cartpg.getPaymentSuccessMsg(), "Payment was successful");
		cartpg.clickConfirmBtn();
		Assert.assertNotNull(cartpg.getInvoiceNumber());
		homepg.clickLogoutButton();
	}

	@Test
	public void creditCard() throws IOException {
		proceedTillPayment();
		cartpg.paymentCreditCard("1234-1234-1234-1234", "01/2027", "123", "Siddharth Nair");
		Assert.assertEquals(cartpg.getPaymentSuccessMsg(), "Payment was successful");
		cartpg.clickConfirmBtn();
		Assert.assertNotNull(cartpg.getInvoiceNumber());
		homepg.clickLogoutButton();
	}

	@Test
	public void buyNowPayLater() throws IOException {
		proceedTillPayment();
		cartpg.paymentBuyNowPayLater("3");
		Assert.assertEquals(cartpg.getPaymentSuccessMsg(), "Payment was successful");
		cartpg.clickConfirmBtn();
		Assert.assertNotNull(cartpg.getInvoiceNumber());
		homepg.clickLogoutButton();
	}

	@Test
	public void giftCard() throws IOException {
		proceedTillPayment();
		cartpg.paymentGiftCard("0123456789123456", "1234");
		Assert.assertEquals(cartpg.getPaymentSuccessMsg(), "Payment was successful");
		cartpg.clickConfirmBtn();
		Assert.assertNotNull(cartpg.getInvoiceNumber());
		homepg.clickLogoutButton();
	}

	public void proceedTillPayment() throws IOException {
		completeRegistration();
		signinpg.login(registerpg.emailId, registerpg.password);
		Assert.assertEquals(signinpg.getLoginSuccessMsg(), "My account");
		homepg.clickHomeButton();
		homepg.selectProduct(ReadPropertyUtility.getProperty("productname"));
		homepg.clickAddToCart(ReadPropertyUtility.getProperty("productquantity"));
		Assert.assertEquals(homepg.getAddedToCartMsg(), "Product added to shopping cart.");
		homepg.clickCartButton();
		cartpg.proceedFromCart();
		cartpg.proceedFromSignin();
		cartpg.enterHouseNumberAndProceed(registerpg.houseNumber);
	}

}