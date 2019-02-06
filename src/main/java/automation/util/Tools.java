package automation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
	
	public static WebElement visibilityOf(WebElement element, long timeOutInSeconds, WebDriver driver) {
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));

		return element;
	}
	
}
