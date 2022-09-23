package test1;

import org.testng.annotations.Test;

import data1.LoginData1;
import page1.LoginPage1;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest1 {
	
	
	LoginPage1 lp = new LoginPage1();
	LoginData1 ld = new LoginData1();
  
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	    lp.openBrowser();
		lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  
  @Test (priority = 1)
  public void LoginWithSpecialCharTest() throws InterruptedException {
	  
	  	lp.login(ld.emailwithSpecialChar, ld.wrongPassword);
		String expectedErr = ld.specialCharErr;
		String actualErr = lp.readSpecialCharEmailErr();
		Assert.assertEquals(actualErr, expectedErr);
		
  }

  @Test (priority = 2)
  public void LoginWithEmptyEmail() throws InterruptedException {
	  
	  	lp.login("", ld.wrongPassword);
		
		String expectedErr = ld.emptyEmailErr;
		String actualErr = lp.readEmailErr();
		Assert.assertEquals(actualErr, expectedErr);
		
  }
  
  @Test (priority = 3)
  public void LoginWithEmptyPassword() throws InterruptedException {
	  
	  	lp.login(ld.wrongEmail, "");
		String expectedErr = ld.emptyPassword;
		String actualErr = lp.readPasswordErr();
		Assert.assertEquals(actualErr, expectedErr);
		
  }
  
  @Test (priority = 4)
  public void LoginWithwrongemailpasswordTest() throws InterruptedException {
	  
	  	lp.login(ld.wrongEmail, ld.wrongPassword);
		
		String expectedErr = ld.globalErr;
		String actualErr = lp.readGlobalErr();
		Assert.assertEquals(actualErr, expectedErr);
		
  }
  
 
}
