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

import java.io.File;
import java.time.Duration;

public class UploadSteps {
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

    @Given("I am on the Upload and Download page")
    public void i_am_on_the_upload_and_download_page() {
        driver.get("https://demoqa.com/upload-download");
        // String pageSource = driver.getPageSource();
        // System.out.println("Page Source: " + pageSource);
    }

    @When("I click the {string} button and select the {string} file")
    public void i_click_the_button_and_select_the_file(String buttonId, String filePath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(buttonId)));
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        uploadButton.sendKeys(absolutePath);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("The file it's uploaded")
    public void the_file_its_uploaded() {
        WebElement paragraph = driver.findElement(By.id("uploadedFilePath"));
        String text = paragraph.getText();
        System.out.println("The text in the paragraph is: " + text);
    }
}
