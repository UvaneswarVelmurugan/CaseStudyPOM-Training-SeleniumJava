package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	WebElement del;
	
	@FindBy(xpath="//td[contains(text(),'Samsung galaxy s6')]")
	WebElement cartCheckItem;
	
	@FindBy(xpath="//h3[@class='panel-title']")
	WebElement checkRate;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	public void delSingleItem() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String strBef = checkRate.getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		del.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String strAft = checkRate.getText();
     	if(strBef!=strAft) {
				  Assert.assertTrue(strBef!=strAft);
			  }
    // 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//	driver.navigate().to("https://www.demoblaze.com/index.html");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions. 
//		return new PurchaseItem();
	}

}
