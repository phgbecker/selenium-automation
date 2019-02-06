package automation;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import automation.page.TheDogFatherPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TheDogFatherTest {
	private WebDriver driver;
	private long initialTime;
	
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Before
	public void setupTest() {
		initialTime = System.currentTimeMillis();
		driver = new ChromeDriver();
	}
	
	@After
	public void releaseResource() {
		if (driver != null)
			driver.quit();
		
		System.out.format("Total time elapsed: %ss", (System.currentTimeMillis() - initialTime) / 1000);
	}
	
	@Test
	public void fetchProducts() {
		driver.manage().window().maximize();
		
		TheDogFatherPage page = new TheDogFatherPage(driver);
		List<String> products = page.openWebsite().getProducts();
		
		Assert.assertTrue("17 cm - R$ 12,90", products.contains("17 cm - R$ 12,90"));
	}


}
