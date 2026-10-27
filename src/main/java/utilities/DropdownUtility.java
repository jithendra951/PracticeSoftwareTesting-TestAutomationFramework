package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {

	public static Select select(WebElement dropdown) {
		return new Select(dropdown);
	}

	// to select the options in the dropdown
	public static void selectByIndex(WebElement dropdown, int index) {
		select(dropdown).selectByIndex(index);
	}

	public static void selectByValue(WebElement dropdown, String value) {
		select(dropdown).selectByValue(value);
	}

	public static void selectByVisibleText(WebElement dropdown, String text) {
		select(dropdown).selectByVisibleText(text);
	}

	public static void selectByContainsVisibleText(WebElement dropdown, String text) {
		select(dropdown).selectByContainsVisibleText(text);
		;
	}

	// to deselect the options in the dropdown
	public static void deselectByIndex(WebElement dropdown, int index) {
		select(dropdown).deselectByIndex(index);
	}

	public static void deselectByValue(WebElement dropdown, String value) {
		select(dropdown).deselectByValue(value);
	}

	public static void deselectByVisibleText(WebElement dropdown, String text) {
		select(dropdown).deselectByVisibleText(text);
	}

	public static void deSelectByContainsVisibleText(WebElement dropdown, String text) {
		select(dropdown).deSelectByContainsVisibleText(text);
	}

	public static void deselectAll(WebElement dropdown) {
		select(dropdown).deselectAll();
	}

	// to fetch the options in the dropdown
	public static WebElement getFirstSelectedOption(WebElement dropdown) {
		return select(dropdown).getFirstSelectedOption();
	}

	public static List<WebElement> getAllOptions(WebElement dropdown) {
		return select(dropdown).getOptions();
	}

	public static List<WebElement> getAllSelectedOption(WebElement dropdown) {
		return select(dropdown).getAllSelectedOptions();
	}

	// printing options
	public static void printFirstSelectedOption(WebElement dropdown) {
		System.out.println(getFirstSelectedOption(dropdown).getText());
	}

	public static void printAllOptions(WebElement dropdown) {
		for (WebElement option : getAllOptions(dropdown)) {
			System.out.println(option.getText());
		}
	}

	public static void printAllSelectedOptions(WebElement dropdown) {
		for (WebElement option : getAllSelectedOption(dropdown)) {
			System.out.println(option.getText());
		}
	}
}
