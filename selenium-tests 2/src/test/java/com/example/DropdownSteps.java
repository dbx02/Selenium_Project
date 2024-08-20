package com.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;

public class DropdownSteps {
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
    
    @Given("I am on the dropdown page")
    public void i_am_on_the_dropdown_page() {
        driver.get("https://demoqa.com/select-menu");
    }
    
    @When("I select the {string} option from the Old Style Select Menu")
    public void i_select_the_option_from_the_old_style_select_menu(String option) {
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select selectMenu = new Select(dropdown);
        selectMenu.selectByVisibleText(option);
    }
    
    @Then("The {string} option should be selected")
    public void the_option_should_be_selected(String option) {
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select selectMenu = new Select(dropdown);
        WebElement selectedOption = selectMenu.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        assertTrue(selectedText.equals(option));
    }
}
