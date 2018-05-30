package com.saucelabs.example.pages;

import com.saucelabs.example.MyFluentWait;
import com.saucelabs.example.Util;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class InitialRatePage extends AbstractPage
{
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]")
    private WebElement downPayment;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[2]")
    private WebElement secondPayment;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[3]/td[2]")
    private WebElement thirdPayment;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[4]/td[2]")
    private WebElement fourthPayment;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[5]/td[2]")
    private WebElement fifthPayment;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[6]/td[2]")
    private WebElement finalPayment;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/form/div/div[9]/div/div[2]/div[2]")
    private WebElement policyTermTotal;

    public InitialRatePage(WebDriver driver)
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
        return downPayment;
    }

    public void assertAmount(String fieldName, String amount)
    {
        Util.info(getDriver(), "Asserting %s is %s...", fieldName, amount);

        WebElement elem = null;

        switch (fieldName)
        {
            case "Down Payment":
                elem = downPayment;
                break;
            case "Second Payment":
                elem = secondPayment;
                break;
            case "Third Payment":
                elem = thirdPayment;
                break;
            case "Fourth Payment":
                elem = fourthPayment;
                break;
            case "Fifth Payment":
                elem = fifthPayment;
                break;
            case "Final Payment":
                elem = finalPayment;
                break;
            case "Policy Term Total":
                elem = policyTermTotal;
                break;
        }

        Assert.assertEquals(elem.getText(), amount);
    }
}
