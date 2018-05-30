package com.saucelabs.example.pages;

import com.saucelabs.example.MyFluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class InitialQuotePage extends AbstractPage
{
    @FindBy(css = "select#year0")
    private WebElement year0;

    @FindBy(css = "select#make0")
    private WebElement make0;

    @FindBy(css = "select#model0")
    private WebElement model0;

    @FindBy(css = "select#trim0")
    private WebElement trim0;

    @FindBy(css = "input#\\.FirstName")
    private WebElement firstName;

    @FindBy(css = "input#\\.MiddleName")
    private WebElement middleName;

    @FindBy(css = "input#\\.LastName")
    private WebElement lastName;

    @FindBy(css = "input#garagingAddress\\.city")
    private WebElement garagingCity;

    @FindBy(css = "input#garagingAddress\\.zipCode")
    private WebElement garagingZipCode;

    @FindBy(css = "input#email")
    private WebElement email;

    @FindBy(css = "input#nameInsuredDriver\\.birthDate")
    private WebElement birthDate;

    @FindBy(css = "label:nth-child(2) > input#nameInsuredDriver\\.gender")
    private WebElement male;

    @FindBy(css = "label:nth-child(3) > input#nameInsuredDriver\\.gender")
    private WebElement female;

    @FindBy(css = "select#namedInsuredDriver\\.maritalStatus")
    private WebElement maritalStatus;

    @FindBy(css = "select#creditScore")
    private WebElement creditScore;

    @FindBy(css = "select#namedInsuredDriver\\.employmentStatus")
    private WebElement employmentStatus;

    @FindBy(css = "select#priorInsurance")
    private WebElement priorInsurance;

    @FindBy(css = "label:nth-child(2) > input#isHomeOwner")
    private WebElement isHomeOwner;

    @FindBy(css = "label:nth-child(3) > input#isHomeOwner")
    private WebElement isNotHomeOwner;

    @FindBy(css = "label:nth-child(2) > input#namedInsuredDriver\\.hasViolations")
    private WebElement hasViolations;

    @FindBy(css = "label:nth-child(3) > input#namedInsuredDriver\\.hasViolations")
    private WebElement hasNoViolations;

    @FindBy(xpath = "//a[contains(text(),'CONTINUE')]")
    private WebElement continueButton;

    public InitialQuotePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);

        wait = new MyFluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    @Override
    public WebElement getPageLoadedTestElement()
    {
        return year0;
    }

    public void selectYear(String year)
    {
        Select select = new Select(year0);
        select.selectByVisibleText(year);
        sleep(500); // Allow time for other select fields to update
    }

    public void selectMake(String make)
    {
        Select select = new Select(make0);
        select.selectByVisibleText(make);
        sleep(500); // Allow time for other select fields to update
    }

    public void selectModel(String model)
    {
        Select select = new Select(model0);
        select.selectByVisibleText(model);
        sleep(500); // Allow time for other select fields to update
    }

    public void selectTrim(String trim)
    {
        Select select = new Select(trim0);
        select.selectByVisibleText(trim);
        sleep(500); // Allow time for other select fields to update
    }

    public void setFirstName(String firstName)
    {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void setMiddleName(String middleName)
    {
        this.middleName.clear();
        this.middleName.sendKeys(middleName);
    }

    public void setLastName(String lastName)
    {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void setGaragingCity(String city)
    {
        this.garagingCity.clear();
        this.garagingCity.sendKeys(city);
    }

    public void setGaragingZipCode(String zipCode)
    {
        this.garagingZipCode.clear();
        this.garagingZipCode.sendKeys(zipCode);
    }

    public void setEmail(String email)
    {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void setBirthDate(String dob)
    {
        birthDate.clear();
        birthDate.sendKeys(dob);
    }

    public void setMaleGender()
    {
        male.click();
    }

    public void setFemaleGender()
    {
        female.click();
    }

    public void setMaritalStatus(String status)
    {
        Select select = new Select(maritalStatus);
        select.selectByVisibleText(status);
    }

    public void setCreditScore(String score)
    {
        Select select = new Select(creditScore);
        select.selectByVisibleText(score);
    }

    public void setEmploymentStatus(String status)
    {
        Select select = new Select(employmentStatus);
        select.selectByVisibleText(status);
    }

    public void setMaintainedInsurance(String status)
    {
        Select select = new Select(priorInsurance);
        select.selectByVisibleText(status);
    }

    public void setOwnHome(String ownHome)
    {
        if (ownHome.toLowerCase().startsWith("y"))
            isHomeOwner.click();
        else
            isNotHomeOwner.click();
    }

    public void setViolations(String violations)
    {
        if (violations.toLowerCase().startsWith("y"))
            hasViolations.click();
        else
            hasNoViolations.click();
    }

    public void clickContinue()
    {
        continueButton.click();
    }
}
