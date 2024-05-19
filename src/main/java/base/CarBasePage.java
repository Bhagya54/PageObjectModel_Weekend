package base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBasePage {
	public WebDriver driver;
	
	public CarBasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//h1")
	WebElement carTitle;
	public String getTitle() {
		
		return carTitle.getText();
		
	}
	
	@FindBy(xpath="//div/div/div/a/h3")
	List<WebElement> carModels;
	
	@FindBy(xpath="//div/div/div/div[3]/div/span/span[1]")
	List<WebElement> carPrices;
	
	
	public void getCarModelAndPrices() {
		for(int i=0;i<carPrices.size();i++) {
			System.out.println("Car Model: " + carModels.get(i).getText() +
					" Car Price: " + carPrices.get(i).getText());
		}
	}
	
	
}
