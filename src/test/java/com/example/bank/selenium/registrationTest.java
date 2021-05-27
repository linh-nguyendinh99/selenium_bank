package com.example.bank.selenium;

import com.example.bank.model.TestDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class registrationTest extends TestDriver {
    ChromeDriver driver = getDriver();
    //Bo trong truong "Ho ten"
    @Test
    public void nameTest () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("001100110011200");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");

        WebElement birth = driver.findElement(By.xpath("//*[@id=\"input-25\"]"));

        birth.sendKeys("2021-05-08");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-44-1\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button[2]"));

        Thread.sleep(2000);
        WebElement arlet = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/form/div/div/div[2]/div/div/div/div[2]/div[1]/div/div"));
        String expectedTitle = "Trường thông tin này bắt buộc!";
        assertEquals(arlet.getText(),expectedTitle,"Alret not as");
        driver.close();
    }

    //Dang ky
    @Test
    public void register () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("Nguyen Dinh Linh");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("001100110011200");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");

        WebElement birth = driver.findElement(By.xpath("//*[@id=\"input-25\"]"));
        birth.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/div[2]/table/tbody/tr[3]/td[2]/button")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-59-1\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/button[2]")).click();

    }
    //Ten có Ky tu dac biet
    @Test
    public void name2 () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("Nguyen Dinh @");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("001100110011200");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");

        WebElement birth = driver.findElement(By.xpath("//*[@id=\"input-25\"]"));
        birth.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/div[2]/table/tbody/tr[3]/td[2]/button")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-59-1\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/button[2]")).click();
        WebElement arlet = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/form/div/div/div[2]/div/div/div/div[2]/div[1]/div/div"));
        String expectedTitle = "Họ tên chỉ gồm chữ và viết hoa chữ đầu!";
        assertEquals(arlet.getText(),expectedTitle,"Alret not found");
        driver.close();
    }

    @Test
    public void birth () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("Nguyen Dinh Linh");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("100110011200");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");



        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-44-1\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button[2]"));

        Thread.sleep(2000);
        WebElement arlet = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[3]/div/div[1]/div/div[2]/div/div/div"));
        String expectedTitle = "Trường thông tin này bắt buộc!";
        assertEquals(arlet.getText(),expectedTitle,"Alret not as");
        driver.close();
    }

    //Bo trong chung minh thu
    @Test
    public void Cmt () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("Nguyen Dinh Linh");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");



        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-44-1\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button[2]"));

        Thread.sleep(2000);
        WebElement arlet = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[4]/div/div/div/div[2]/div[1]/div/div"));
        String expectedTitle = "Trường thông tin này bắt buộc!";
        assertEquals(arlet.getText(),expectedTitle,"Alret not as");
        driver.close();
    }

    //Co chu trong so chung minh thu
    @Test
    public void Cmt2 () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("Nguyen Dinh Linh");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("không không một một 00110011");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");



        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-44-1\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button[2]"));

        Thread.sleep(2000);
        WebElement arlet = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[4]/div/div/div/div[2]/div[1]/div/div"));
        String expectedTitle = "Trường thông tin này bắt buộc là một dãy số!";
        assertEquals(arlet.getText(),expectedTitle,"Alret not as");
        driver.close();
    }

    @Test
    public void Cancel () throws InterruptedException {
        driver.get("http://localhost:8080/registration");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-21\"]"));
        name.click();
        name.sendKeys("Nguyen Dinh Linh");

        WebElement cmt = driver.findElement(By.xpath("//*[@id=\"input-29\"]"));
        cmt.click();
        cmt.sendKeys("không không một một 00110011");

        WebElement job = driver.findElement(By.xpath("//*[@id=\"input-32\"]"));
        job.click();
        job.sendKeys("Sinh viên");



        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[6]/div/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list-item-44-1\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/button[2]"));

        Thread.sleep(2000);
        WebElement arlet = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/form/div/div/div[4]/div/div/div/div[2]/div[1]/div/div"));
        String expectedTitle = "Trường thông tin này bắt buộc là một dãy số!";
        assertEquals(arlet.getText(),expectedTitle,"Alret not as");
        driver.close();
    }
}


