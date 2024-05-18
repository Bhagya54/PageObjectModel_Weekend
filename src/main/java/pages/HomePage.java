package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[text()='NEW CARS']")
	WebElement newCar;
	@FindBy(xpath="//*[text()='Find New Cars']")
	WebElement findNewCar;
	
	public void searchNewCars() {
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/span"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div[1]/div/input"))
				.sendKeys("Hyundai");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/div/button"))
				.click();
	}

	public void searchUsedCars() {

	}

	public NewCarsPage findNewCars() {
		//WebElement newCar = driver.findElement(By.xpath("//*[text()='NEW CARS']"));
		Actions act = new Actions(driver);
		act.moveToElement(newCar).perform();
		findNewCar.click();
		return new NewCarsPage(driver);
	}
}
