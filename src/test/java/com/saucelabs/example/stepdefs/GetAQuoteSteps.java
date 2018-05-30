package com.saucelabs.example.stepdefs;

import com.saucelabs.example.Util;
import com.saucelabs.example.pages.HomePage;
import com.saucelabs.example.pages.InitialQuotePage;
import com.saucelabs.example.pages.InitialRatePage;
import com.saucelabs.example.pages.PagesFactory;
import com.saucelabs.example.pages.PreviousPolicyPage;
import cucumber.api.java8.En;

public class GetAQuoteSteps implements En
{
    protected void sleep(long msecs)
    {
        try
        {
            Thread.sleep(msecs);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public GetAQuoteSteps()
    {
        And("^The user sets the zip code to \"([^\"]*)\"$", (String zipCode) -> {
            HomePage homePage = PagesFactory.getInstance().getHomePage();
            homePage.enterZipCode(zipCode);
        });

        And("^The user clicks the 'Get A Quote' button$", () -> {
            HomePage homePage = PagesFactory.getInstance().getHomePage();
            homePage.clickGetAQuote();
        });

        When("^The Previous Policy page loads$", () -> {
            Util.info(PagesFactory.getInstance().getDriver(), "Loading the Previous Policy page...");
            PreviousPolicyPage ppp = PagesFactory.getInstance().getPreviousPolicyPage();
            ppp.waitForPageLoad();
        });

        And("^The user clicks on 'New Customer'$", () -> {
            PreviousPolicyPage ppp = PagesFactory.getInstance().getPreviousPolicyPage();
            ppp.clickNewCustomer();
        });

        When("^The Initial Quote page loads$", () -> {
            Util.info(PagesFactory.getInstance().getDriver(), "Loading the Initial Quote page...");
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.waitForPageLoad();
        });

        And("^The user sets the 'Year' to \"([^\"]*)\"$", (String year) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.selectYear(year);
        });

        And("^The user sets the 'Make' to \"([^\"]*)\"$", (String make) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.selectMake(make);
        });

        And("^The user sets the 'Model' to \"([^\"]*)\"$", (String model) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.selectModel(model);
        });

        And("^The user sets the 'First Name' to \"([^\"]*)\"$", (String firstName) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setFirstName(firstName);
        });

        And("^The user sets the 'Last Name' to \"([^\"]*)\"$", (String lastName) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setLastName(lastName);
        });

        And("^The user sets the 'Garaging City' to \"([^\"]*)\"$", (String city) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setGaragingCity(city);
        });

        And("^The user sets the 'Garaging Zip' to \"([^\"]*)\"$", (String zip) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setGaragingZipCode(zip);
        });

        And("^The user sets the 'Email' to \"([^\"]*)\"$", (String email) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setEmail(email);
        });

        And("^The user sets the 'Date of Birth' to \"([^\"]*)\"$", (String dob) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setBirthDate(dob);
        });

        And("^The user sets the 'Gender' to Male$", () -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setMaleGender();
        });

        And("^The user sets the 'Gender' to Female$", () -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setFemaleGender();
        });

        And("^The user sets the 'Marital status' to \"([^\"]*)\"$", (String status) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setMaritalStatus(status);
        });

        And("^The user sets the 'Credit score' to \"([^\"]*)\"$", (String creditScore) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setCreditScore(creditScore);
        });

        And("^The user sets the 'Employment status' to \"([^\"]*)\"$", (String arg0) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setEmploymentStatus(arg0);
        });

        And("^The user sets the 'Maintained Insurance' to \"([^\"]*)\"$", (String status) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setMaintainedInsurance(status);
        });

        And("^The user sets the 'Own Home' to \"([^\"]*)\"$", (String ownHome) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setOwnHome(ownHome);
        });

        And("^The user sets the 'Last 3 Years' to \"([^\"]*)\"$", (String hasViolations) -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.setViolations(hasViolations);
        });

        And("^The user clicks on 'Continue'$", () -> {
            InitialQuotePage initialQuotePage = PagesFactory.getInstance().getInitialQuotePage();
            initialQuotePage.clickContinue();
        });

        When("^The Initial Rate page loads$", () -> {
            Util.info(PagesFactory.getInstance().getDriver(), "Loading the Initial Rate page...");
            InitialRatePage initialRatePage = PagesFactory.getInstance().getInitialRatePage();
            initialRatePage.waitForPageLoad();
        });

        Then("^The \"([^\"]*)\" should be \"([^\"]*)\"$", (String fieldName, String amount) -> {
            InitialRatePage initialRatePage = PagesFactory.getInstance().getInitialRatePage();
            initialRatePage.assertAmount(fieldName, amount);
        });
//
//        When("^The Phones page loads$", () -> {
//            Util.log(this, "^The Phones page loads$\n");
//            CategoryPhonesPage categoryPhonesPage = PagesFactory.getInstance().getCategoryPhonesPage();
//            categoryPhonesPage.waitForPageLoad();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on 'Buy'$", () -> {
//            Util.log(this, "^The user clicks on 'Buy'$\n");
//            ProductPixel2Page productPixel2Page = PagesFactory.getInstance().getProductPixel2Page();
//            productPixel2Page.waitForPageLoad();
//            productPixel2Page.clickBuy();
//        });
//
//        And("^The user clicks on '6\" Pixel 2 XL'$", () -> {
//            Util.log(this, "^The user clicks on '6\" Pixel 2 XL'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.select6InchPixel2XL();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on 'Unlocked'$", () -> {
//            Util.log(this, "^The user clicks on 'Unlocked'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.selectUnlocked();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on 'Black & White'$", () -> {
//            Util.log(this, "^The user clicks on 'Black & White'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.selectBlackAndWhite();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on '64 GB'$", () -> {
//            Util.log(this, "^The user clicks on '64 GB'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.select64GB();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on '128 GB'$", () -> {
//            Util.log(this, "^The user clicks on '128 GB'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.select128GB();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on 'Preferred Care'$", () -> {
//            Util.log(this, "^The user clicks on 'Preferred Care'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.selectPreferredCare();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        When("^The Preferred Care dialog appears$", () -> {
//            Util.log(this, "^The Preferred Care dialog appears$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.waitForPageLoad();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user clicks on 'Add To Order'$", () -> {
//            Util.log(this, "^The user clicks on 'Add To Order'$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.selectAddToOrder();
//            sleep(250); // Allow time for the web animation to run
//        });
//
//        And("^The user adds phone to cart$", () -> {
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            sleep(500); // Allow time for the web animation to run
//            configPixel2Page.clickBuy();
//        });
//
//        When("^The shopping cart appears$", () -> {
//            Util.log(this, "^The shopping cart appears$\n");
//            CartPage cartPage = PagesFactory.getInstance().getCartPage();
//            cartPage.waitForPageLoad();
//        });
//
//        Then("^The 'Subtotal' amount should be \"([^\"]*)\"$", (String expectedAmount) -> {
//            Util.log(this, "^The 'Subtotal' amount should be \"([^\"]*)\"$\n");
//            CartPage cartPage = PagesFactory.getInstance().getCartPage();
//            String subtotal = cartPage.getSubtotal();
//            Assert.assertEquals(expectedAmount, subtotal);
//        });
//
//        When("^The Google Pixel 2 page loads$", () -> {
//            Util.log(this, "^The Google Pixel 2 page loads$\n");
//            ProductPixel2Page productPixel2Page = PagesFactory.getInstance().getProductPixel2Page();
//            productPixel2Page.waitForPageLoad();
//        });
//
//        When("^The Config Google Pixel 2 page loads$", () -> {
//            Util.log(this, "^The Config Google Pixel 2 page loads$\n");
//            ConfigPixel2Page configPixel2Page = PagesFactory.getInstance().getConfigPixel2Page();
//            configPixel2Page.waitForPageLoad();
//        });
    }
}
