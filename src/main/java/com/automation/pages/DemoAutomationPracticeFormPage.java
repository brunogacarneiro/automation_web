package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DemoAutomationPracticeFormPage {
    private final WebDriver driver;
    @FindBy(name = "firstname")
    WebElement firstNameInput;
    @FindBy(name = "lastname")
    WebElement lastNameInput;
    @FindBys({@FindBy(name = "sex")})
    List<WebElement> sexRatios;
    @FindBys({@FindBy(name = "exp")})
    List<WebElement> expRatios;
    @FindBy(id = "datepicker")
    WebElement datePicker;
    @FindBys({@FindBy(name = "profession")})
    List<WebElement> professionCheckboxs;

    @FindBys({@FindBy(name = "tool")})
    List<WebElement> toolsCheckboxs;

    @FindBy(id = "continents")
    WebElement continentsSelector;

    @FindBy(id = "submit")
    WebElement submitButton;

    public DemoAutomationPracticeFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void selectSexRatio(String sex) {
        if ((sex.equals("Male"))) {
            sexRatios.get(0).click();
        } else {
            sexRatios.get(1).click();
        }
    }

    public void selectExpRatio(String exp) {
        expRatios.get(Integer.parseInt(exp) - 1).click();
    }

    public void inputDate(String date) {
        if (date == null) {
            date = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datePicker);
        datePicker.sendKeys(date);
    }

    public void selectProfession(String profession) {
        if ((profession.equals("Manual Tester"))) {
            professionCheckboxs.get(0).click();
        } else {
            professionCheckboxs.get(1).click();
        }
    }

    public void selectAutomationTools(String automationTools) {
        List<String> automationToolsList = List.of(automationTools.split(",")).stream()
                .map(x -> x.trim()).collect(Collectors.toList());
        for (String automationTool : automationToolsList) {
            switch (automationTool) {
                case "UTF":
                    toolsCheckboxs.get(0).click();
                    break;
                case "Protractor":
                    toolsCheckboxs.get(1).click();
                    break;
                case "Selenium Webdriver":
                    toolsCheckboxs.get(2).click();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + automationTool);
            }
        }
    }

    public void selectContinent(String continent) {
        continentsSelector.click();
        continentsSelector.findElements(By.xpath(".//option")).stream()
                .filter(x -> x.getText().equals(continent)).findFirst().get().click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
