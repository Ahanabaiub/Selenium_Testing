package com.ahanab.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class loginTest {

    WebDriver driver;

    @BeforeClass
    void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Developer Tools\\Crome Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/ENotes_war_exploded/login.jsp");

    }

    @Test
    void login(){
        driver.findElement(By.name("email")).sendKeys("rahim24@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1235");
        driver.findElement(By.className("btn-primary")).click();

//        if(driver.getTitle().equals("Home")){
//            Assert.assertTrue(true);
//        }
//        else{
//            Assert.assertTrue(false);
//        }
        Assert.assertEquals("Home",driver.getTitle(),"Login Failed " +
                "because incorrect password.");

    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }


}
