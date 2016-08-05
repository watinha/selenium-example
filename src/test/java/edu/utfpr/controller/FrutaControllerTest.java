package edu.utfpr.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(JUnit4.class)
public class FrutaControllerTest {

    @Test
    public void test_adicionar_adiciona_um_element () throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        Date date = new Date();

        driver.get("http://localhost:8080/fruta");
        WebElement input = driver.findElement(By.cssSelector("form input"));
        input.sendKeys("supimpa" + date.toString());
        input.submit();

        Thread.sleep(500);
        WebElement last_li = driver.findElement(By.cssSelector("li:last-child"));
        assertEquals("supimpa" + date.toString(), last_li.getText());

        driver.quit();
    }

}
