package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public static void webpageScreenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temporary_location = ts.getScreenshotAs(OutputType.FILE);
		File permanent_location = new File("./screenshot/" + filename + ".png");
		FileHandler.copy(temporary_location, permanent_location);
	}

	public static void webelementScreenshot(WebDriver driver, WebElement element, String filename) throws IOException {
		File temporary_location = element.getScreenshotAs(OutputType.FILE);
		File permanent_location = new File("./screenshot/" + filename + ".png");
		FileHandler.copy(temporary_location, permanent_location);
	}
}
