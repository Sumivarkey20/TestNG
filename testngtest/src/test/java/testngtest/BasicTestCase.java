package testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestCase {
	
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
				
		}
	@Test
	public void VerifyTitle()
	{
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		//String expected = "Sumi";
		Assert.assertEquals(actualtitle, expected);
		//Assert.assertEquals(expected,actualtitle ); //wrong
		}
	@Test
	public void VerifyUpdateLocation()
	{
	WebElement actualupdateloc = driver.findElement(By.xpath("//span[@id='glow-ingress-line2']"));
	String actual = actualupdateloc.getText();
	System.out.println(actual);
	String expected = "Update location";
	Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
		}
}
