package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class PurchaseItem extends TestBase{
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement count;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement card;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchaseBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Thank you for your purchase!')]")
	WebElement confrmMsg;
	
	public PurchaseItem() {
		PageFactory.initElements(driver, this);
	}
	public void placeOrder() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		placeOrderBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		name.sendKeys("Uvaneswar");
		count.sendKeys("India");
		city.sendKeys("Neyveli");
		card.sendKeys("12345678");
		month.sendKeys("March");
		year.sendKeys("2023");
		purchaseBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean isDisp2  = confrmMsg.isDisplayed();
	    Assert.assertTrue(isDisp2);
		

	}

}
