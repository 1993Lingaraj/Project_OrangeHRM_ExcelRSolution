package ORHRM_Testcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_ORHRM {

	public static void main(String[] args) throws InterruptedException {
		// Scenario- To login to a page
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		userName.sendKeys("Admin"); 
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		pass.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		// sleep for 3 seconds (implicit & explicit wait)
		Thread.sleep(3000);
		
		/*
		// Scenario- To compare actual and expected
		
		WebElement actualmsg = driver.findElement(By.xpath("//div[@id='forgotPasswordLink']/a"));
		String actual=actualmsg.getText();
		System.out.println("Actual message:"+actual);
		
		String expected="Forgot your password?";
		
		if(actual.equals(expected))
		{
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		*/
		
		/*
		// Scenario-Actions- To perform various actions on elements
		WebElement perf = driver.findElement(By.xpath("//a[@id='menu__Performance']/b"));
		
		Actions act=new Actions(driver);
		act.moveToElement(perf).click().perform();
		
		WebElement empTrack = driver.findElement(By.xpath("//a[@id='menu_performance_viewEmployeePerformanceTrackerList']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(empTrack).click().perform();
		*/
		
		
		// Scenario-Select- Selecting from a drop down menu
		WebElement leave = driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"));
		Actions act=new Actions(driver);
		act.moveToElement(leave).click().perform();
		
		WebElement subUnit = driver.findElement(By.xpath("//select[@id='leaveList_cmbSubunit']"));
		Select sel=new Select(subUnit);
		sel.selectByVisibleText("Engineering");
		
		driver.close();

	}

}
