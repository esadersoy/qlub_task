package io.qlub.stepDefs;

import io.cucumber.java.en.*;
import io.qlub.pages.MainPage;
import io.qlub.utilities.BrowserUtils;
import io.qlub.utilities.ConfigurationReader;
import io.qlub.utilities.Driver;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class menuStepDefs {
    Logger logger = LoggerFactory.getLogger(menuStepDefs.class);
    SoftAssertions softAssertions = new SoftAssertions();

    @Given("user scans QR code on the table")
    public void user_scans_qr_code_on_the_table() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        logger.info("User scanned QR code on the table");
    }

    @Then("user should be able to choose {string} option")
    public void user_should_be_able_to_choose_option(String option) {
        MainPage mainPage = new MainPage();
        Boolean menuPresent = mainPage.getSelectOptionWthText(option).isDisplayed();
        softAssertions.assertThat(menuPresent).as(option + " is not displayed!").isTrue();
        logger.info("> > > Verified that '{}' is displayed", option);

    }

    @When("user clicks on the {string} option")
    public void user_clicks_on_the_option(String option) {
        new MainPage().getSelectOptionWthText(option).click();
        logger.info("> > > User clicked on'{}' option", option);

    }

    @Then("user should be displayed {string} menu")
    public void user_should_be_displayed_menu(String expectedText) {
        String actualText = new MainPage().menuTitle.getText();
        softAssertions.assertThat(actualText).as(expectedText + " is not verified!").isEqualTo(expectedText);
        logger.info("> > > Menu title is verified as '{}'", expectedText);
    }


    @And("menu should be displayed as pdf file to the user")
    public void menuShouldBeDisplayedAsPdfFileToTheUser() {
        boolean displayed = new MainPage().menuAsPdf.isDisplayed();
        softAssertions.assertThat(displayed).as(" Menu is not displayed as pdf!").isTrue();
        logger.info("> > > Verified that menu is displayed as pdf");
        softAssertions.assertAll();
    }

    @Then("user should be able to see {string} option")
    public void userShouldBeAbleToSeeOption(String expectedText) {
        String actualText = new MainPage().payMyBillButton.getText();
        softAssertions.assertThat(actualText).as(expectedText + " is not verified!").isEqualTo(expectedText);
        logger.info("> > > '{}' button is verified ", expectedText);

    }

    @And("user should be able to see his bill amount")
    public void userShouldBeAbleToSeeHisHerBillAmount() {
        boolean displayed = new MainPage().billAmount.isDisplayed();
        softAssertions.assertThat(displayed).as(" Bill amount is not displayed!").isTrue();
        softAssertions.assertAll();
        logger.info("> > > Verified that bill amount is displayed");
    }

    @Then("user should be able to see his bill information")
    public void userShouldBeAbleToSeeHisBillInformation() {
        BrowserUtils.waitUntilYourBillLabelPresent(15);
        boolean displayed = new MainPage().yourBillLabel.isDisplayed();
        softAssertions.assertThat(displayed).as(" 'Your bill' label is not displayed!").isTrue();
        logger.info("> > > Verified that 'Your bill' label is displayed");
    }

    @Then("user should be able to see information of his table")
    public void userShouldBeAbleToSeeInformationOfHisTable() {
        BrowserUtils.waitFor(2);
        boolean tableInformationDisplayed = new MainPage().tableInformation.isDisplayed();
        String tableInformationLabel = new MainPage().tableInformation.getText();
        softAssertions.assertThat(tableInformationDisplayed).as("Table information is not displayed!").isTrue();
        logger.info("> > > Table information is displayed as '{}' ", tableInformationLabel);
    }


    @Then("user should able to see card payment option")
    public void userShouldAbleToSeeCardPaymentOption() {

        BrowserUtils.scrollToElement(new MainPage().cardPaymentOption);
        Driver.get().switchTo().frame(new MainPage().cardPaymentOption);
        String cardNumberLabelText = new MainPage().cardNumberLabel.getText();
        softAssertions.assertThat(cardNumberLabelText).as("Card payment option is not verified!'").isEqualTo("Card number");
        softAssertions.assertAll();
        logger.info("> > > Card payment option is verified");
    }

    @Then("user should able to see apple pay option")
    public void userShouldAbleToSeeApplePayOption() {

        softAssertions.assertThat(new MainPage().applePayButton.size()>0).as("# # # # Apple Pay option is not verified!").isTrue();
        softAssertions.assertAll();
        logger.info("> > > Apple Pay option is verified");
    }

    @Then("user should be able to see google pay option")
    public void userShouldBeAbleToSeeGooglePayOption() {

        softAssertions.assertThat(new MainPage().applePayButton.size()>0).as("# # # # Google Pay is not verified! ").isTrue();
        softAssertions.assertAll();
        logger.info("> > > Google Pay option is verified");
    }
}
