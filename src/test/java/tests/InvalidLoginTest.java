package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class InvalidLoginTest extends BaseTest {

	@Test
	public void invalidEmailLogin() throws IOException {
		completeRegistration();
		signinpg.login(registerpg.randomEmail(), registerpg.password);
		Assert.assertEquals(signinpg.getInvalidLoginErrorMsg(), "Invalid email or password");
	}

	@Test
	public void invalidPasswordLogin() throws IOException {
		completeRegistration();
		signinpg.login(registerpg.emailId, registerpg.randomPassword());
		Assert.assertEquals(signinpg.getInvalidLoginErrorMsg(), "Invalid email or password");
	}

	@Test
	public void loginWithEmptyEmail() throws IOException {
		homepg.clickSigninButton();
		signinpg.login("", registerpg.randomPassword());
		Assert.assertEquals(signinpg.getEmailErrorMsg(), "Email is required");
	}

	@Test
	public void loginWithEmptyPassword() throws IOException {
		homepg.clickSigninButton();
		signinpg.login(registerpg.randomEmail(), "");
		Assert.assertEquals(signinpg.getPasswordErrorMsg(), "Password is required");
	}

	@Test
	public void loginWithEmptyEmailAndPassword() throws IOException {
		homepg.clickSigninButton();
		signinpg.login("", "");
		Assert.assertEquals(signinpg.getEmailErrorMsg(), "Email is required");
		Assert.assertEquals(signinpg.getPasswordErrorMsg(), "Password is required");
	}

}
