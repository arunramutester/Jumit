package com.ecommerce.stepDefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTask {
	
	 static WebDriver driver;
	 static long start;
	
	@BeforeClass
	
	   public static void login() {
		
         WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
         String url ="https://www.flipkart.com/";
         driver.get(url);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
	}
	
	@AfterClass
	
	  public static  void close() {
		
         driver.close();
	}

	
	 @Before
	 
	   public void Start() {
		
            start = System.currentTimeMillis();
	}
	 
	 @After
	 
	 public  void end() {
		
         long end = System.currentTimeMillis();
         long tt = end - start ;
         System.out.println("TimeTaken:"+tt);
         
	}
	 
	 @Test
	 
	 public  void method1() {
		  driver.findElement(By.xpath("//button[text()='✕']")).click();
		 WebElement ten = driver.findElement(By.name("q"));
          ten.sendKeys("MiMobiles",Keys.ENTER);
	}
	 @Test
	 
	 public void method2() {
		
     driver.findElement(By.xpath("//div[text()='REDMI 10A (Slate Grey, 32 GB)']")).click();
	}
	 @Test
	 
	 public  void method3() {
		
        String pwind = driver.getWindowHandle();
        Set<String> allwin = driver.getWindowHandles();
        for (String x : allwin) {
			if (!x.equals(pwind)) {
				driver.switchTo().window(x);
				System.out.println("Tab Switched ");
			}
		}
	}
	 
	 public  void method4() {
		
          WebElement button = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
          button.click();
	}
}
