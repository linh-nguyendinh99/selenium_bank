package com.example.bank.selenium;

import com.example.bank.model.TestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterestCalculationTest extends TestDriver {
    ChromeDriver driver = getDriver();

    //Bo trong truong "So tien can vay"
    @Test
    public void demo(){
        driver.get("http://192.168.5.185:8080/interest-calculation");
        WebElement money = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/form/div/div/div[1]/div[1]/div/div/div[1]/div/input"));
        money.sendKeys(" ");
        WebElement arlet = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/form/div/div/div[1]/div[1]/div/div/div[2]/div[1]/div/div"));
        String expectedTitle = "Số tiền phải lớn hơn 1.000.000";
        assertEquals(arlet.getText(),expectedTitle,"Alret not as");
        driver.close();
    }

    //nhap dung
    @Test
    public void caculationValid() throws InterruptedException {
        driver.get("http://192.168.5.185:8080/interest-calculation");
        WebElement money = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/form/div/div/div[1]/div[1]/div/div/div[1]/div/input"));
        money.sendKeys("10000000");

       driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/form/div/div/div[1]/div[2]/div/" +
               "div/div[1]/div[1]/div[1]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"list-item-49-1\"]")).click();
       driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/form/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"list-item-55-4\"]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
       Thread.sleep(2000);

       WebElement goc= driver.findElement(By.xpath("//*[@id=\"input-37\"]"));
       WebElement lai= driver.findElement(By.xpath("//*[@id=\"input-40\"]"));
       WebElement tong= driver.findElement(By.xpath("//*[@id=\"input-43\"]"));


       assertEquals("833333",goc.getText(),"Result incorrect");

    }
}
