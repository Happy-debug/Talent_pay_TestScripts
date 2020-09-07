
package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.configuration.Browser;
import com.configuration.Config;
import com.configuration.MyScreenRecorder;

public class CreateProfileTest extends Browser{
	public WebDriver driver;
	
	
	@BeforeMethod
	public void launchURL() {
		driver = browserInformation();
		driver.get(Config.getStringValue("url"));
		}
	
	
	@Test
	public void verifyPageContent() throws Exception {
		
		MyScreenRecorder.startRecording("verifyPageContent");
		driver.findElement(By.id("login_lock")).sendKeys("logintalent*74c_");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'I AM TALENT')]")).click();
		// Fill the form
		driver.findElement(By.cssSelector("a[class='button_grey more forDes']")).click();
		driver.findElements(By.cssSelector(("input[id='talfirstname'][class='signup-talent1-form-text']"))).get(1).sendKeys("Mary");
		driver.findElements(By.cssSelector(("input[id='tallastname'][class='signup-talent1-form-text']"))).get(1).sendKeys("Kom");
		driver.findElements(By.cssSelector(("input[id='talemail'][class='signup-talent1-form-text']"))).get(1).sendKeys("h24.kmar@gmail.com");
		driver.findElements(By.cssSelector(("input[id='talconfemail'][class='signup-talent1-form-text']"))).get(1).sendKeys("h24.kmar@gmail.com");
		driver.findElements(By.cssSelector(("input[id='talusername'][class='signup-talent1-form-text']"))).get(1).sendKeys("h24.Kmar");
		driver.findElement(By.cssSelector("input[id='talpassword']")).sendKeys("Summer@1");
		driver.findElement(By.cssSelector("input[id='talconfpassword']")).sendKeys("Summer@1");

		driver.findElement(By.cssSelector("button[id='signup-talent-submit'][class='signup-talent1-submit']")).click();
		Thread.sleep(3000);
		
		MyScreenRecorder.stopRecording();
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

}
