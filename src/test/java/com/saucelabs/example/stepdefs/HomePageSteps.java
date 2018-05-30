package com.saucelabs.example.stepdefs;

import com.saucelabs.example.pages.HomePage;
import com.saucelabs.example.pages.PagesFactory;
import cucumber.api.java8.En;

public class HomePageSteps implements En
{
    public HomePageSteps()
    {
        Given("^The user is on the Home Page$", () -> {
            HomePage homePage = PagesFactory.getInstance().getHomePage();
            homePage.navigateTo(HomePage.PAGE_URL);
        });
    }
}
