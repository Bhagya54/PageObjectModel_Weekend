package testcases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pages.BMWPage;
import pages.HomePage;
import pages.NewCarsPage;

public class CarWale {

	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        
        driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.carwale.com/");
		
		
		 HomePage home = new HomePage(driver); 
		 NewCarsPage newCar = home.findNewCars(); 
		 BMWPage bmw = newCar.gotoBmw();
		 bmw.doSomething();
		 

		
		//new HomePage(driver).findNewCars().gotoBmw().doSomething();
	}

}
