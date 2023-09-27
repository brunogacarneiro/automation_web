package com.automation.steps;

import com.automation.pages.DemoAutomationPracticeFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class DemoAutomationPracticeFormSteps {

    DemoAutomationPracticeFormPage demoAutomationPracticeFormPage;
    private WebDriver driver;

    @Given("the user is on the Demo Automation Practice Form page")
    public void theUserIsOnTheDemoAutomationPracticeFormPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.id("ez-accept-necessary")).click();
        demoAutomationPracticeFormPage = new DemoAutomationPracticeFormPage(driver);
    }

    @When("the user fills the Automation Practice Form")
    public void theUserFillsTheAutomationPracticeForm(DataTable dataTable) {
        Map<String, String> map = dataTable.asMaps().get(0);
        demoAutomationPracticeFormPage.inputFirstName(map.get("First name"));
        demoAutomationPracticeFormPage.inputLastName(map.get("Last name"));
        demoAutomationPracticeFormPage.selectSexRatio(map.get("Gender"));
        demoAutomationPracticeFormPage.selectExpRatio(map.get("Years of Experience"));
        demoAutomationPracticeFormPage.inputDate(map.get("Date"));
        demoAutomationPracticeFormPage.selectProfession(map.get("Profession"));
        demoAutomationPracticeFormPage.selectAutomationTools(map.get("Automation Tools"));
        demoAutomationPracticeFormPage.selectContinent(map.get("Continent"));
    }

    @And("submits the data")
    public void submitsTheData() {
        demoAutomationPracticeFormPage.clickSubmitButton();
    }

    @Then("the user will be registered")
    public void theUserWillBeRegistered() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
