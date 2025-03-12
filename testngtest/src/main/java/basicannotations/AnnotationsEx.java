package basicannotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsEx {
	
	public class AnnotationsDemo 
	{
	@BeforeSuite
	public void BeforesSuite()
	{
		System.out.println("Before Suite");
		}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite");
		}
	
	@BeforeTest
	public void Beforestest()
	{
		System.out.println("Before Test");
		}
	
	@AfterTest
	public void Aftertest()
	{
		System.out.println("After Test");
		}
	
	@Test
	public void Testcase1()
	{
		System.out.println("Test Case");
		}
	
	@BeforeClass
	public void Beforeclass()
	{
		System.out.println("Before Class");
		}
	
	@AfterClass
	public void Afterclass()
	{
		System.out.println("After Class");
		}
	
	@BeforeMethod
	public void Beforemethod()
	{
		System.out.println("Before Method");
		}
	
	@AfterMethod
	public void Aftermethod()
	{
		System.out.println("After Method");
		}
	
	@Test
	public void Testcase2()
	{
		System.out.println("Test Case2");
		}
	}

}
