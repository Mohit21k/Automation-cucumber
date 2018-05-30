package com.saucelabs.example.pages;

import org.openqa.selenium.WebDriver;

public class PagesFactory
{
    private static PagesFactory instance;
    private WebDriver driver;
    private HomePage homePage;
    private InitialQuotePage initialQuotePage;
    private InitialRatePage initialRatePage;
    private PreviousPolicyPage previousPolicyPage;

    public static void start(WebDriver driver)
    {
        instance = new PagesFactory(driver);
    }

    public static PagesFactory getInstance()
    {
        return instance;
    }

    private PagesFactory(WebDriver driver)
    {
        this.driver = driver;
        homePage = new HomePage(driver);
        initialQuotePage = new InitialQuotePage(driver);
        initialRatePage = new InitialRatePage(driver);
        previousPolicyPage = new PreviousPolicyPage(driver);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public HomePage getHomePage()
    {
        return homePage;
    }

    public InitialQuotePage getInitialQuotePage()
    {
        return initialQuotePage;
    }

    public InitialRatePage getInitialRatePage()
    {
        return initialRatePage;
    }

    public PreviousPolicyPage getPreviousPolicyPage()
    {
        return previousPolicyPage;
    }
}
