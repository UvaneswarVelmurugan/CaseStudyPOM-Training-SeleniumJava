package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(id="loginusername")
	WebElement name;
	
	@FindBy(id="loginpassword")
	WebElement pwd;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement signInCnfrm;
	
	@FindBy(id="nameofuser")
	WebElement username;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void logIn() {
		
		name.sendKeys("Uvaneswar");
		pwd.sendKeys("Uvan123");
		signInCnfrm.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(username, "Welcome Uvaneswar"));
//		return new AddSingleItem();
	}
//	public void userName() {
//		name.sendKeys("Uvaneswar");
//	}
//	public void password() {
//		pwd.sendKeys("Uvan123");
//	}
//	public void signInCnf() {
//		signInCnfrm.click();
//	}
}
