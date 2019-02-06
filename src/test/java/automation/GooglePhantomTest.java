package automation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import automation.page.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePhantomTest {
	private WebDriver driver;
	private long initialTime;
	
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.phantomjs().setup();
	}
	
	@Before
	public void setupTest() {
		initialTime = System.currentTimeMillis();
		driver = new PhantomJSDriver();
	}
	
	@After
	public void releaseResource() {
		if (driver != null)
			driver.quit();
		
		System.out.format("Total time elapsed: %ss", (System.currentTimeMillis() - initialTime) / 1000);
	}
	
	@Test
	public void navigateGoogle() {
		driver.manage().window().maximize();
		
		GooglePage page = new GooglePage(driver);
		page.openWebsite().textToSearch("Selenium - Web Browser automation").takeScreenShot();
		
		Assert.assertEquals("https://www.seleniumhq.org/", page.getExpectedResult());
	}

}
