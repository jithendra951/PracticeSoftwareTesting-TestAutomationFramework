package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadPropertyUtility;

public class EndToEndOrderTest extends BaseTest {

	@Test
	public void orderProduct() throws IOException {
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
		cartpg.paymentCashOnDelivery();
		Assert.assertEquals(cartpg.getPaymentSuccessMsg(), "Payment was successful");
		cartpg.clickConfirmBtn();
		Assert.assertNotNull(cartpg.getInvoiceNumber());
		homepg.clickLogoutButton();
	}
}
