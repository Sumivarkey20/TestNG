package testngtest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
// hard Assert, if it fails it will terminate 
public class HeaderVerificationEx {
	
WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
				
		}
	
	@Test(priority = 1) //least value will be executed first
	public void SingleCheckboxHeader()
	{
		WebElement singlecheckbox = driver.findElement(By.xpath("//div[contains(text(),'Single Checkbox Demo')]"));
		String actual = singlecheckbox.getText();
		System.out.println(actual);
		String expected = "Single Checkbox Demo";
		Assert.assertEquals(actual, expected);
		System.out.println("First Test Case");
		
		}
	
	//@Test(priority = 5)
	@Test
	
	public void VerifyCheckboxelement()
	{
		WebElement checkboxclick = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		checkboxclick.click();
		boolean actualstatus = checkboxclick.isSelected();
		System.out.println(actualstatus);
		//Assert.assertEquals(actualstatus, true);
		Assert.assertTrue(actualstatus); //if expected is true
		//Assert.assertFalse(actualstatus);//if expected is false
		System.out.println("Second Test Case");
	}
	//@Test(priority = 3,enabled = false)
	@Test(dependsOnMethods = "VerifyCheckboxelement" ) //will skip this method if the mentioned one fails
	public void SelectAllColor()
	{
		WebElement backgroundcolor = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		String actualcolor=backgroundcolor.getCssValue("color");
		System.out.println(actualcolor);
		String expectedcolor = "rgba(255, 255, 255, 1)";
		Assert.assertEquals(actualcolor,expectedcolor,"Error Msg-Faild" ); //can pass a msg, will be displayed if failed
	}
}
