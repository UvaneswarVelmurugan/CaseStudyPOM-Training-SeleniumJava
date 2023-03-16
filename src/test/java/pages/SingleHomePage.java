package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class SingleHomePage extends TestBase{

//	@FindBy(xpath="//a[contains(text(),'Phones')]")
//	WebElement cat;
//	
//	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]")
//	WebElement item;
//	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement add;
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement cart;
	
	@FindBy(xpath="//td[contains(text(),'Samsung galaxy s6')]")
	WebElement cartCheckItem;
	
	public SingleHomePage() {
		PageFactory.initElements(driver, this);
	}
	public void singleItemAdd(String strCategories, String strItem) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	//	driver.navigate().to("https://www.demoblaze.com/index.html");
		
		WebElement cat = driver.findElement(By.linkText(strCategories));
		cat.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement item = driver.findElement(By.linkText(strItem));
		item.click();
		
//		cat.click();
//		item.click();
		add.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	public void checkSingleCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean isDisp  = cartCheckItem.isDisplayed();
		Assert.assertTrue(isDisp);
//		return new DeleteItem();
		
		
	}

}
