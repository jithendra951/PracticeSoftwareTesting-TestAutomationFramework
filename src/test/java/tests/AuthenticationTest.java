package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;

public class AuthenticationTest extends BasePage {

	@Test(priority = 1)
	public void validLogin() throws IOException {
		signinpg.login(registerpg.emailId, registerpg.password);
		Assert.assertEquals(signinpg.getLoginSuccessMsg(), "My account");
		homepg.clickLogoutButton();
	}

	@Test(priority = 2)
	public void duplicateUserRegistration() throws IOException {
		signinpg.clickRegisterAccount();
		registerpg.createUser();
		Assert.assertEquals(registerpg.getRegisterErrorMsg(), "A customer with this email address already exists.");
	}
}