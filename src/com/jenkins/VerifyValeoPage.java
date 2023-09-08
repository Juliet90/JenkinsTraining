package com.jenkins;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyValeoPage {

	@Test
	public void searchValeoWebsite() {
		System.out.println("launching chrome browser");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("[--remote-allow-origins=*]");
		WebDriver driver = new ChromeDriver(options);	
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean verifyElement=driver.findElement(By.xpath("//div[@class='flash success']")).isDisplayed();
		Assert.assertTrue(verifyElement);
		driver.quit();
	}
}
