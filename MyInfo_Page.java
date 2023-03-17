package ORHRM_Testcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyInfo_Page {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
// Scenario- To update the information on my info page
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		userName.sendKeys("Admin"); 
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		pass.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
//click on My_info
		WebElement myInfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b"));
		myInfo.click();
		Thread.sleep(3000);
		
		WebElement oldName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
		System.out.println(oldName.getText());
		
		WebElement editBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		editBtn.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
		firstName.clear();
		firstName.sendKeys("Lingaraj");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
		lastName.clear();
		lastName.sendKeys("Mishra");
		
		WebElement dob = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
		dob.clear();
		dob.sendKeys("1993-07-21");
		
		WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		saveBtn.click();
		
		Thread.sleep(4000);
		
		WebElement newName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
		System.out.println(newName.getText());
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
