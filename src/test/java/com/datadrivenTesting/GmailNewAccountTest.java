package com.datadrivenTesting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class GmailNewAccountTest {
	
WebDriver driver ;
	
@BeforeTest
public void setUp() {

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en-GB&flowName=GlifWebSignIn&flowEntry=SignUp");
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@DataProvider
public Iterator<Object[]> getTestData() {
ArrayList<Object[]> testdata= TestUtil.getDataFromExcel();
return testdata.iterator();
}

@Test(dataProvider="getTestData")
public void gmailAccountTest(String firstName, String lastName,String userName , String password, String confirm ){
	
driver.findElement(By.name("firstName")).clear();
driver.findElement(By.name("firstName")).sendKeys(firstName);

driver.findElement(By.name("lastName")).clear();
driver.findElement(By.name("lastName")).sendKeys(lastName);

driver.findElement(By.name("Username")).clear();
driver.findElement(By.name("Username")).sendKeys(userName);

driver.findElement(By.name("Passwd")).clear();
driver.findElement(By.name("Passwd")).sendKeys(password);

driver.findElement(By.name("ConfirmPasswd")).clear();
driver.findElement(By.name("ConfirmPasswd")).sendKeys(confirm);
	
}

@AfterTest
public void tearDown() {
driver.quit();
}
}