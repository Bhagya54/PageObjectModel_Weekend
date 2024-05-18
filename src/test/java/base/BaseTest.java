package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import extentlisteners.ExtentListeners;
import utility.DbManager;
import utility.ExcelReader;
import utility.MonitoringMail;

public class BaseTest {

	
	
	
	public WebDriver driver;
	public Properties config = new Properties();
	public Properties or = new Properties();
	public FileInputStream fis;
	public ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	public Logger log = Logger.getLogger(BaseTest.class);
	public MonitoringMail mail = new MonitoringMail();
	public WebDriverWait wait;
	
	
	
	public void setUp(String browser)  {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Test Execution started");
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/Config.properties");
			config.load(fis);
			log.info("Config file has been loaded");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			log.info("Chrome browser has launched");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			log.info("Firefox browser has launched");
		}
		
		try {
			DbManager.setMysqlDbConnection();
			log.info("Database connection established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		driver.get(config.getProperty("testsiteurl"));
		
	}
	
	
		
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
