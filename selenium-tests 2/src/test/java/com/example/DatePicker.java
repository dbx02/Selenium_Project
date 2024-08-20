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

public class DatePicker {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the date picker page")
    public void i_am_on_the_date_picker_page() {
        driver.get("https://demoqa.com/date-picker");

    }

    @When("I select the date {string}")
    public void i_select_the_date(String date) {
        WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
        dateInput.click();

        String ariaLabel = "Choose " + date;
        WebElement specificDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@aria-label, '" + ariaLabel + "')]")));
        specificDate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("The date {string} should be selected")
    public void the_date_should_be_selected(String expectedDate) {
        WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
        String actualDate = dateInput.getAttribute("value");
        assertEquals(expectedDate, actualDate);
    }
}
