package edu.curso.java.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Users/588472/Documents/Capacitacion/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://www.seleniumhq.org/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.linkText("Download")).click();
		driver.findElement(By.linkText("Documentation")).click();
		driver.findElement(By.id("q")).clear();
		driver.findElement(By.id("q")).sendKeys("java");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By
				.xpath("//div[@id='cse']/div/div/div/div[5]/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr/td[2]/div[4]/div[2]"))
				.click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
