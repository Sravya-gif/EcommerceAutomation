package com.srm.utils;

import java.io.File;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotUtil {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
        Thread.sleep(3000);

        try {

          
            driver.findElement(By.linkText("Signup / Login")).click();
            Thread.sleep(2000);

           
            driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                  .sendKeys("srilakshmisravya_alahari@srmap.edu.in");

            driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                  .sendKeys("admin123");

            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

            Thread.sleep(3000);

            
            boolean isLoggedIn = driver.findElement(
                    By.xpath("//*[contains(text(),'Logged in as')]"))
                    .isDisplayed();

            if (!isLoggedIn) {
                throw new Exception("Login Failed");
            }

            System.out.println("Login Successful");

            
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/success_" + System.currentTimeMillis() + ".png");
            FileHandler.copy(src, dest);

            System.out.println("Screenshot captured on success");

        } catch (Exception e) {

            
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/failure_" + System.currentTimeMillis() + ".png");
            FileHandler.copy(src, dest);
 
            System.out.println("Screenshot captured on failure");
        }

        driver.quit();
    }

	public static void takeScreenshot(WebDriver driver, String string) {
		// TODO Auto-generated method stub
		
	}
}