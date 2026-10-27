package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;

public class EndToEndOrderTest extends BasePage {

	@Test
	public void orderProduct() throws IOException {
		signinpg.login(registerpg.emailId, registerpg.password);
		Assert.assertEquals(signinpg.getLoginSuccessMsg(), "My account");
		homepg.clickHomeButton();
		homepg.selectProduct("Claw Hammer with Shock Reduction Grip");
		homepg.clickAddToCart("2");
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
