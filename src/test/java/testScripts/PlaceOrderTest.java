package testScripts;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.CartPage;
import pages.LoginPage;
import pages.PurchasePage;

public class PlaceOrderTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HomePage addSingleItem;
	CartPage delItem;
	PurchasePage placeItemOrder;
	
	
	@BeforeTest
	public void setup() {
		initialize();
	}
	
  @Test
  public void SignIn() {
	  homePage = new HomePage();
	  homePage.signIn();
  }
  @Test(priority=1)
  public void LoginTest() {
	  loginPage = new LoginPage();
	  loginPage.logIn();
  }

  @Test(priority=2,dataProvider="SingleItem")
  public void AddTest(String strCategories, String strItem) {
	  addSingleItem = new HomePage();
	  addSingleItem.singleItemAdd(strCategories,strItem);
  }
  @Test(priority=3)
  public void ViewCartTest() {
	  addSingleItem = new HomePage();
	  addSingleItem.checkSingleCart();
  }
  @Test(priority=4)
  public void DeleteCartTest() {
	  delItem = new CartPage();
	  delItem.delSingleItem();
  }
  @Test(priority=5)
  public void PlaceOrder() {
	  delItem = new CartPage();
	  delItem.placeOrder();
  }
//  @Test(priority=5,dataProvider="MultipleItem")
//  public void MulAddTest(String strCategories, String strItem) {
//	  addMultipleItem = new MultipleHomePage();
//	  addMultipleItem.multipleItemAdd(strCategories,strItem);
//  }
//  @Test(priority=)
//  public void MulAddviewTest() {
//	  addMultipleItem = new MultipleHomePage();
//	  addMultipleItem.checkMultipleCart();
//  }
  @Test(priority=6)
  public void orderCartTest() {
	  placeItemOrder = new PurchasePage();
	  placeItemOrder.placeOrder();
  }
  
  @DataProvider(name="SingleItem")
  public Object[][] getData1() throws CsvValidationException, IOException {
	  String path = System.getProperty("user.dir") +"//src//test//resources//testData//singleTest.csv";
	  String[] cols;
	  CSVReader reader = new CSVReader(new FileReader(path));
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  while((cols = reader.readNext()) !=null) {
		  Object[] record = {cols[0], cols[1]};
		  dataList.add(record);
  }
	  return dataList.toArray(new Object[dataList.size()][]);
  }
//  @DataProvider(name="MultipleItem")
//  public Object[][] getData() throws CsvValidationException, IOException {
//	  String path = System.getProperty("user.dir") +"//src//test//resources//testData//multipletest.csv";
//	  String[] cols;
//	  CSVReader reader = new CSVReader(new FileReader(path));
//	  ArrayList<Object> dataList = new ArrayList<Object>();
//	  while((cols = reader.readNext()) !=null) {
//		  Object[] record = {cols[0], cols[1]};
//		  dataList.add(record);
//  }
//	  return dataList.toArray(new Object[dataList.size()][]);
//  }
}
