package testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx {
	
	WebDriver driver;
	
		
		@BeforeMethod
		public void LaunchBrowser()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
					
			}
		
		@Test(dataProvider = "products",dataProviderClass = DataProviders.class)
		public void VerifyProduct(String product)
		{
			WebElement searchprod = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			System.out.println(product);
			searchprod.sendKeys(product);
		}

}
