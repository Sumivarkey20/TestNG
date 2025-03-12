package testngtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

//softassert - multiple assert in one test case
public class SoftAssertEx {
	
WebDriver driver;
SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
				
		}
@Test(invocationCount = 3)
	
	public void VerifyCheckboxstatus()
	{
		WebElement checkboxclick = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		checkboxclick.click();
		boolean enablestatus = checkboxclick.isEnabled();
		System.out.println(enablestatus);
		boolean actualstatus = checkboxclick.isSelected();
		System.out.println(actualstatus);
		softassert.assertEquals(enablestatus, false);
		softassert.assertTrue(actualstatus);
		softassert.assertAll();
		
		
	}

}
