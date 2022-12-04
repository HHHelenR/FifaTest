package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

	@Test
	public void validateSearch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("fifa world cup 2022");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		WebElement firstLink = driver.findElement(By.xpath("(//div[@class='ofy7ae'])[1]"));
		String actualText = firstLink.getText();
		System.out.println(actualText);
		String expectedText = "FIFA World Cup Qatar 2022™";
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), 
				"Expected" + expectedText + "but found >>" + actualText);
		
		
		
	}
	
	
	
	
	
	
}
