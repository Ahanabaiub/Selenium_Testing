package com.ahanab.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenNote {

    WebDriver driver;

    @BeforeClass
    void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Developer Tools\\Crome Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/ENotes_war_exploded/login.jsp");

    }

    @Test
    void myNotes(){
        driver.findElement(By.name("email")).sendKeys("rahim24@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.className("btn-primary")).click();

        if(driver.getTitle().equals("Home")){
            driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[1]/a")).click();
        }
        else{
            Assert.fail();
        }

    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

}
