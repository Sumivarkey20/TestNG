package testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {

	
	WebDriver driver;
	
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login.php/");
		driver.manage().window().maximize();
				
		}
	
	@Test(dataProvider = "logindetails",dataProviderClass = DataProviders.class)
	public void LoginInfo(String login, String password)
	{
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys(login);
		WebElement pass1 = driver.findElement(By.xpath("//input[@id='pass']"));
		pass1.sendKeys(password);
	}
}
