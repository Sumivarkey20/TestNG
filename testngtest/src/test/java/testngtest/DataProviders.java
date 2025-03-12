package testngtest;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="products")
	public Object[][] amazoneproduct()
	{
		return new Object [][] {{"shoes"},{"watch"},{"phone"}};
	}
	
	@DataProvider(name="logindetails")
	public Object[][] facebooklogin()
	{
		return new Object [][] {{"9567720013","*Test1234"},
            {"1234567890","*test1234"},
            {"7895642313","*Test1234"},
            {"9567720013","*Te1234"}};
	}

}
