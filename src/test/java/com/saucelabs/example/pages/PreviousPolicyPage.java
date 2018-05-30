package com.saucelabs.example.pages;

import com.saucelabs.example.MyFluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PreviousPolicyPage extends AbstractPage
{
    @FindBy(xpath = "//a[@ng-click='goToPolicySearchPage()']")
    private WebElement goToPolicySearchPage;

    @FindBy(xpath = "//a[@ng-click='goToStartNewQuotePage()']")
    private WebElement goToStartNewQuotePage;

    public PreviousPolicyPage(WebDriver driver)
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
        return goToStartNewQuotePage;
    }

    public void clickPreviousCustomer()
    {
        goToPolicySearchPage.click();
    }

    public void clickNewCustomer()
    {
        goToStartNewQuotePage.click();
    }
}
