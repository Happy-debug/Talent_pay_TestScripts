package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.configuration.Browser;
import com.configuration.Config;
import com.configuration.MyScreenRecorder;

public class EditProfileTest extends Browser{
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void launchURL() {
		driver = browserInformation();
		driver.get(Config.getStringValue("url"));
		}
	
	@Test
	
	public void editProfile() throws Exception {
		
		MyScreenRecorder.startRecording("editProfile");
		driver.findElement(By.id("login_lock")).sendKeys("logintalent*74c_");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.cssSelector("a[id='login_in_menu']")).click();
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("h24.Kmar");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Summer@1");
		driver.findElement(By.xpath("//*[@name='enter']")).click();
		Thread.sleep(1000);
		//  Click the Edit button
		WebElement editButton= driver.findElement(By.xpath("//a[@name='view_submit'][@class='green_button view_submit'][@href='http://uat.talentpaycasting.com/talent/profileedit/details']"));
		editButton.sendKeys("\n");
		
		//  Set the all compulsory fields in the Details tab, click on Next Step
		WebElement birthDate= driver.findElement(By.xpath("//select[@class='day form-control']"));
		Select se1= new Select(birthDate);
		se1.selectByValue("22");
		
		WebElement birthMonth = driver.findElement(By.xpath("//select[@class='month form-control']"));
		Select se2= new Select(birthMonth);
		se2.selectByIndex(3);
		
		WebElement birthYear = driver.findElement(By.xpath("//select[@class='year form-control']"));
		Select se3= new Select(birthYear);
		se3.selectByVisibleText("1990");
		
		WebElement countryCode = driver.findElement(By.xpath("//select[@id='telephone_country']"));
		Select se4= new Select(countryCode);
		se4.selectByValue("+61");
		
		driver.findElement(By.xpath("//input[@id='telephone']")).clear();
		driver.findElement(By.xpath("//input[@id='telephone']")).sendKeys("478563245");
		
		WebElement ethnicity = driver.findElement(By.xpath("//select[@name='ethnicity']"));
		Select se5= new Select(ethnicity);
		se5.selectByIndex(1);
		
		WebElement male = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[1]/form/div/div[4]/div[2]/div/div/label[1]"));
   		Actions actions = new Actions(driver);
		actions.moveToElement(male).click().perform();
		WebElement occupation = driver.findElement(By.xpath("//select[@id='talent_occupation']"));
		Select se6= new Select(occupation);
		se6.selectByIndex(1);
		
		driver.findElement(By.xpath("//button[@name='submit']")).sendKeys("\n");
		
		By buttonClass = By.cssSelector("button[class='green_button meadia_next']");
		//driver.findElement(buttonClass).click();
		driver.findElement(buttonClass).sendKeys("\n");
		
		//  Fill in Age Range, Weight, Height, Eye colour. Click on Next Step
		WebElement minAge = driver.findElement(By.xpath("//select[@id='min_age']"));
		Select se7= new Select(minAge);
		se7.selectByValue("15");
		
		WebElement maxAge = driver.findElement(By.xpath("//select[@id='max_age']"));
		Select se8= new Select(maxAge);
		se8.selectByValue("20");
		
		WebElement weight = driver.findElement(By.xpath("//select[@name='weight']"));
		Select se9= new Select(weight);
		se9.selectByValue("15");
		
		WebElement height = driver.findElement(By.xpath("//select[@name='heights']"));
		Select se10= new Select(height);
		se10.selectByValue("66");
		
		WebElement eyeColour = driver.findElement(By.xpath("//select[@name='eye_color']"));
		Select se11= new Select(eyeColour);
		se11.selectByIndex(1);
		
		driver.findElements(By.xpath("//button[@class='green_button']")).get(1).sendKeys("\n");
		Thread.sleep(3000);
		//  Select a First language , Add a skill,	 Click on Next Step
		WebElement firstLanguage = driver.findElement(By.xpath("//select[@name='native_language']"));
		Select se12= new Select(firstLanguage);
		se12.selectByIndex(1);
		
		driver.findElements(By.xpath("//button[@class='green_button']")).get(2).sendKeys("\n");
		//one more page in between
		// Not able to select the two check boxes “Web” and “TV Series
		
		driver.findElements(By.xpath("//button[@class='green_button']")).get(3).sendKeys("\n");
				
		Thread.sleep(3000);	
		// Last Page -  Click “TV Series”, add a client name, select Year “2020”. click on Update.
		WebElement year = driver.findElements(By.xpath("//select[@name='exp_year[]']")).get(0);
		Select se13= new Select(year);
		se13.selectByIndex(1);
		WebElement tvSeries = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[6]/form/div/div[4]/div[1]/div[2]/div/label[14]"));    
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(tvSeries).click().perform();
		
		
		// There are two ways we can update a text field. One is commented below and other is used.
		//By inputClass = By.cssSelector("input[class='form-control exp_title']");
		//driver.findElement(inputClass).sendKeys("Phantom");
		driver.findElement(By.xpath("//*[@class='form-control exp_title']")).clear();
		driver.findElement(By.xpath("//*[@class='form-control exp_title']")).sendKeys("Phantom");
		driver.findElements(By.xpath("//button[@class='green_button']")).get(4).sendKeys("\n");

		Thread.sleep(3000);	
		MyScreenRecorder.stopRecording();
	}
	
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
}

}
