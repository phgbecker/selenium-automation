package automation.page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.util.Tools;

public class GooglePage {
	
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchInput;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public GooglePage openWebsite() {
		driver.get("http://www.google.com");
		
		return this;
	}
	
	public GooglePage textToSearch(String text) {
		Tools.visibilityOf(searchInput, 5, driver);
		searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
		
		return this;
	}

	public String getExpectedResult() {
		return driver.findElement(By.xpath("//a[@href=\"https://www.seleniumhq.org/\"]/div/cite")).getText();
	}

	public GooglePage takeScreenShot() {
		try {
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("screenShot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
}
