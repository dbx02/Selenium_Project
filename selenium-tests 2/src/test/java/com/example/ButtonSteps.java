package com.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class ButtonSteps {
    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        driver.get("https://demoqa.com/buttons");
        // String pageSource = driver.getPageSource();
        // System.out.println("Page Source: " + pageSource);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[text()='" + buttonName + "']")));
        button.click();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        assertTrue(message.isDisplayed());
    }
}
