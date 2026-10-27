package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

public class MouseActionsUtility {

	public static Actions action(WebDriver driver) {
		return new Actions(driver);
	}

	// hovering can be used for displaying the tool tip & then screenshot can be
	// taken
	public static void hoverMouseOnElement(WebDriver driver, WebElement element) {
		action(driver).moveToElement(element).perform();
	}

	public static void hoverMouseOnElementCoordinates(WebDriver driver, WebElement element, int x, int y) {
		action(driver).moveToElement(element, x, y).perform();
	}

	// hover in the screen or hover in the browser window
	public static void hoverMouseToCoordinates(WebDriver driver, int x, int y) {
		action(driver).moveToLocation(x, y).perform();
	}

	public static void click(WebDriver driver) {
		action(driver).click().perform();
	}

	public static void rightClick(WebDriver driver) {
		action(driver).contextClick().perform();
	}

	public static void doubleClick(WebDriver driver) {
		action(driver).doubleClick().perform();
	}

	public static void clickElement(WebDriver driver, WebElement element) {
		action(driver).moveToElement(element).click().perform();
	}

	public static void rightClickElement(WebDriver driver, WebElement element) {
		action(driver).contextClick(element).perform();
	}

	public static void doubleClickElement(WebDriver driver, WebElement element) {
		action(driver).doubleClick(element).perform();
	}

	public static void hoverMouseFromCurrentPos(WebDriver driver, int x, int y) {
		action(driver).moveByOffset(x, y).perform();
	}

	public static void dragAndDropToTarget(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		action(driver).dragAndDrop(sourceElement, targetElement).perform();
	}

	public static void dragAndDropToCoordinates(WebDriver driver, WebElement sourceElement, int x, int y) {
		action(driver).dragAndDropBy(sourceElement, x, y).perform();
	}

	// scroll actions
	public static void scrollDown(WebDriver driver, int y) {
		action(driver).scrollFromOrigin(ScrollOrigin.fromViewport(), 0, Math.abs(y)).perform();
	}

	public static void scrollUp(WebDriver driver, int y) {
		action(driver).scrollFromOrigin(ScrollOrigin.fromViewport(), 0, -Math.abs(y)).perform();
	}

	public static void scrollByCoordinates(WebDriver driver, int x, int y) {
		action(driver).scrollByAmount(x, y).perform();
	}

	public static void scrollFromTheElement(WebDriver driver, WebElement element, int x, int y) {
		action(driver).scrollFromOrigin(ScrollOrigin.fromElement(element), x, y).perform();
	}
	
	public static void scrollElementToTop(WebDriver driver,WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollElementToBottom(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

}