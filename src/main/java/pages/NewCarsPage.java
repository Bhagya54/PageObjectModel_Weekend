package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NewCarsPage extends BasePage {

	@FindBy(xpath="//*[text()='Maruti Suzuki']")
	WebElement maruti;
	@FindBy(xpath="//*[text()='BMW']")
	WebElement bmw;
	@FindBy(xpath="//*[text()='Mahindra']")
	WebElement mahindra;
	@FindBy(xpath="//*[text()='Hyundai']")
	WebElement hyundai;
	@FindBy(xpath="//*[text()='Tata']")
	WebElement tata;
	@FindBy(xpath="//*[text()='Toyota']")
	WebElement toyota;



	public NewCarsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MarutiPage gotoMaruti() {		
		maruti.click();
		return new MarutiPage(driver);
	}
	
	public HyundaiPage gotoHyundai() {		
		hyundai.click();
		return new HyundaiPage(driver);
	}
	
	public MahindraPage gotoMahindra() {		
		mahindra.click();
		return new MahindraPage(driver);
	}
	
	public TataPage gotoTata() {		
		tata.click();
		return new TataPage(driver);
	}
	
	public ToyotaPage gotoToyota() {		
		toyota.click();
		return new ToyotaPage(driver);
	}
	
	public BMWPage gotoBmw() {		
		bmw.click();
		return new BMWPage(driver);
	}
}
