package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadPropertyUtility;

public class AuthenticationTest extends BaseTest {

	@Test(priority = 1)
	public void validLogin() throws IOException {
		completeRegistration();
		signinpg.login(registerpg.emailId, registerpg.password);
		Assert.assertEquals(signinpg.getLoginSuccessMsg(), "My account");
		homepg.clickLogoutButton();
	}

	@Test(priority = 2)
	public void duplicateUserRegistration() throws IOException {
		completeRegistration();
		signinpg.clickRegisterAccount();
		registerpg.registerUser(1, ReadPropertyUtility.getProperty("registrationsheet"));
		Assert.assertEquals(registerpg.getRegisterErrorMsg(), "A customer with this email address already exists.");
	}
}