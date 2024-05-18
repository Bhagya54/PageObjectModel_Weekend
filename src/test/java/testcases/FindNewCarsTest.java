package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import pages.NewCarsPage;
import utility.DataUtils;

public class FindNewCarsTest extends BaseTest{

	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "dp")
	public void getFindNewCars(String runmode,String browser,String brandName) {
		
		if(runmode.equals("n")) {
			throw new SkipException("Skipping this testcase as runmode is n");
		}
		
		setUp(browser);
		
		HomePage home = new HomePage(driver); 
		NewCarsPage newCar = home.findNewCars(); 
		if(brandName.equalsIgnoreCase("hyundai")) {
			newCar.gotoHyundai();
		}
		else if(brandName.equalsIgnoreCase("bmw")) {
			newCar.gotoBmw();
		}
		else if(brandName.equalsIgnoreCase("maruti")) {
			newCar.gotoMaruti();
		}
		else if(brandName.equalsIgnoreCase("mahindra")) {
			newCar.gotoMahindra();
		}
		else if(brandName.equalsIgnoreCase("toyota")) {
			newCar.gotoToyota();
		}
		else if(brandName.equalsIgnoreCase("tata")) {
			newCar.gotoTata();
		}
		else if(brandName.equalsIgnoreCase("bmw")) {
			newCar.gotoBmw();
		}
		
		System.out.println(driver.getTitle());
		ExtentListeners.test.info("Navigated to " + brandName + " page");
		
	}
}
