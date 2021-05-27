package com.example.bank;

import com.example.bank.model.TestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo extends TestDriver {

    ChromeDriver driver = getDriver();

    @Test
    public void demo(){
            driver.get("http://192.168.5.185:8080/interest-calculation");
            String title = driver.getTitle();
            String expectedTitle = "bank-app";
            driver.close();
            Assertions.assertEquals(expectedTitle,title,"Title not as expected");
        }
    @Test
    public void calculator(){
        driver.get("http://localhost:8080/interest-calculation");
        WebElement money = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/form/div/div/div[1]/div[1]/div/div/div[1]/div/input"));
        money.sendKeys("10000000000");

        driver.findElement(By.className("v-btn")).click();

    }

    @Test
    public void loan(){
        driver.get("http://localhost:8080/pay-the-loan");
        WebElement keyword = driver.findElement(By.id("input-200"));
    }
    }
