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

public class AddMultipleItem extends TestBase{
	
//	@FindBy(xpath="//a[contains(text(),'Home')]")
//	WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement add;
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement cart;
	
	@FindBy(xpath="//td[contains(text(),'ASUS Full HD')]")
	WebElement cartCheckItem;
	
	public AddMultipleItem() {
		PageFactory.initElements(driver, this);
	}
	public void multipleItemAdd(String strCategories, String strItem) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://www.demoblaze.com/index.html");
//		home.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//	driver.navigate().to("https://www.demoblaze.com/index.html");

	}
	public void checkMultipleCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean isDisp  = cartCheckItem.isDisplayed();
		Assert.assertTrue(isDisp);
//		return new DeleteItem();
		
		
	}

}
