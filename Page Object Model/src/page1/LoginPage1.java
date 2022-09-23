package page1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	WebDriver driver;
	
	//WebElement email = driver.findElement(By.id("username"));
	//WebElement password = driver.findElement(By.id("uapPassword"));
	
	@FindBy(id = "username")
	public WebElement email;
	
	@FindBy(id = "uapPassword")
	public WebElement password;
	
	@FindBy(xpath = "//button[@class='btn btn-block td-button-secondary']")
	public WebElement login;
	
	@FindBy(id = "error")
	public WebElement SpecialCharEmailErr;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter your Username or Access Card number.')]")
	public WebElement EmailErr;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter your password')]")
	public WebElement PasswordErr;
	
	@FindBy(id = "error")
	public WebElement GlobalErr;
		
	
	public void openBrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Selenium\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Seleniumjars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.Chrome.driver", "C:\\Selenium\\Seleniumjars\\Chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\Selenium\\Seleniumjars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		
		PageFactory.initElements(driver, this);
	}
	
	public void openLoginPage() {
		driver.get("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		Thread.sleep(4000);
		  
		email.sendKeys(a);
		password.sendKeys(b);
		login.click();
		
		Thread.sleep(4000);
	}
	
	public String readSpecialCharEmailErr() {
		String actualErr = SpecialCharEmailErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}
	
	public String readEmailErr() {
		String actualErr = EmailErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}
	
	public String readPasswordErr() {
		String actualErr = PasswordErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}
	
	public String readGlobalErr() {
		String actualErr = GlobalErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}

}
