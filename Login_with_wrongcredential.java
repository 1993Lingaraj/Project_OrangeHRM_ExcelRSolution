package ORHRM_Testcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_with_wrongcredential {

	public static void main(String[] args)throws InterruptedException {
		// Scenario- To feed the wrong password and check for error message
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		userName.sendKeys("Admin"); 
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		pass.sendKeys("admin#1993");
		
		String expectedMess="Invalid credentials";
		
		WebElement login = driver.findElement(By.xpath("//div/input[@type='submit']"));
		login.click();
		
		WebElement acmessage = driver.findElement(By.xpath("//div[@id='divLoginButton']/span[@id='spanMessage']"));
		String actualMess=acmessage.getText();
		
		if(actualMess.equals(expectedMess))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");		
		}
		
		driver.close();
		
	}

}
