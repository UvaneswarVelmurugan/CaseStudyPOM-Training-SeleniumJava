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
import pages.AddMultipleItem;
import pages.AddSingleItem;
import pages.DeleteItem;
import pages.LoginPage;
import pages.PurchaseItem;

public class PlaceOrderTest extends TestBase{
	
	LoginPage loginPage;
	AddSingleItem addSingleItem;
	AddMultipleItem addMultipleItem;
	DeleteItem delItem;
	PurchaseItem placeItemOrder;
	
	
	@BeforeTest
	public void setup() {
		initialize();
	}
	
  @Test(priority=1)
  public void LoginTest() {
	  loginPage = new LoginPage();
	  loginPage.logIn();
  }
//	  addSingleItem = loginPage.logIn();
//	  addSingleItem.singleItemAdd();
//	  delItem = addSingleItem.checkSingleCart();
////	  delItem.delSingleItem();
//	  placeItemOrder = delItem.delSingleItem();
//	  placeItemOrder.placeOrder();
	 
  
  @Test(priority=2,dataProvider="SingleItem")
  public void AddTest(String strCategories, String strItem) {
	  addSingleItem = new AddSingleItem();
	  addSingleItem.singleItemAdd(strCategories,strItem);
  }
  @Test(priority=3)
  public void ViewCartTest() {
	  addSingleItem = new AddSingleItem();
	  addSingleItem.checkSingleCart();
  }
  @Test(priority=4)
  public void DeleteCartTest() {
	  delItem = new DeleteItem();
	  delItem.delSingleItem();
  }
  @Test(priority=5,dataProvider="MultipleItem")
  public void MulAddTest(String strCategories, String strItem) {
	  addMultipleItem = new AddMultipleItem();
	  addMultipleItem.multipleItemAdd(strCategories,strItem);
  }
  @Test(priority=6)
  public void MulAddviewTest() {
	  addMultipleItem = new AddMultipleItem();
	  addMultipleItem.checkMultipleCart();
  }
  @Test(priority=7)
  public void orderCartTest() {
	  placeItemOrder = new PurchaseItem();
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
  @DataProvider(name="MultipleItem")
  public Object[][] getData() throws CsvValidationException, IOException {
	  String path = System.getProperty("user.dir") +"//src//test//resources//testData//multipletest.csv";
	  String[] cols;
	  CSVReader reader = new CSVReader(new FileReader(path));
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  while((cols = reader.readNext()) !=null) {
		  Object[] record = {cols[0], cols[1]};
		  dataList.add(record);
  }
	  return dataList.toArray(new Object[dataList.size()][]);
  }
}