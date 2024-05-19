package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

public class BasePage {

public WebDriver driver;
	public static CarBasePage carBasePage;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		carBasePage = new CarBasePage(driver);
		PageFactory.initElements(driver,this);
		
	}
}
