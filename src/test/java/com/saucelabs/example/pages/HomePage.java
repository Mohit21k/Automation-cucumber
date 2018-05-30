package com.saucelabs.example.pages;

import com.saucelabs.example.MyFluentWait;
import com.saucelabs.example.Util;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage
{
    public static final String PAGE_URL = "https://www.safeauto.com";

//    @FindBy(xpath = "//body[@data-page-id='homepage']")
//    private WebElement homePageId;
//
//    @FindBy(css = "a[data-title=\"Phones\"]")
//    private WebElement phonesLink;
//
//    @FindBy(css = "a[data-title=\"Home & Entertainment\"]")
//    private WebElement homeAndEntertainmentLink;
//
//    @FindBy(css = "a[data-title=\"Laptops\"]")
//    private WebElement laptopsLink;
//
//    @FindBy(css = "a[data-title=\"Virtual Reality\"]")
//    private WebElement virtualRealityLink;
//
//    @FindBy(css = "a[data-title=\"Accessories\"]")
//    private WebElement accessoriesLink;

    @FindBy(css = "input#quoteZip")
    private WebElement quoteZip;

    @FindBy(css = "button#zipBtn")
    private WebElement getAQuote;

    public HomePage(WebDriver driver)
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
        return quoteZip;
    }

    public void clickGetAQuote()
    {
        Util.info(getDriver(), "Getting a quote...");

        try
        {
            getAQuote.click();
        }
        catch (org.openqa.selenium.TimeoutException e)
        {
            Util.info(getDriver(), "Waiting for the Quote link to be clickable: caught exception, type=" + e.getClass().getSimpleName());

        }
        catch (Exception e)
        {
            Util.info(getDriver(), "Waiting for the Quote link to be clickable: caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void enterZipCode(String zipCode)
    {
        quoteZip.sendKeys(zipCode);
    }
}
