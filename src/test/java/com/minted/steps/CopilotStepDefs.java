package com.minted.steps;

import com.minted.pages.SalesforcePage;
import com.minted.pages.ZendeskPage;
import com.minted.utility.BrowserUtils;
import com.minted.utility.ConfigurationReader;
import com.minted.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CopilotStepDefs {

    SalesforcePage salesforcePage = new SalesforcePage();
    ZendeskPage zendeskPage = new ZendeskPage();
    int frameWidth1;
    int frameWidth2;

    String url = Driver.getDriver().getTitle();

    @When("user enters the username")
    public void user_enters_the_username() {

        if (url.contains("Salesforce")) {
            salesforcePage.username.sendKeys(ConfigurationReader.getProperty("salesForceUserName"));
        } else {
            zendeskPage.zenDeskUserName.sendKeys(ConfigurationReader.getProperty("zenDeskUserName"));
        }
    }

    @When("user enters the password")
    public void user_enters_the_password() {
        if (url.contains("Salesforce")) {
            salesforcePage.password.sendKeys(ConfigurationReader.getProperty("salesForcePassword"));
        } else {
            zendeskPage.zenDeskPassword.sendKeys(ConfigurationReader.getProperty("zenDeskPassword"));
        }

    }

    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {

        if (url.contains("Salesforce")) {
            salesforcePage.loginButton.click();
        } else {
            zendeskPage.zenDeskLoginBtn.click();
        }
    }

    @And("when the user clicks on the Kodif icon, the coPilot window pops up")
    public void whenTheUserClicksOnTheKodifIconTheCoPilotWindowPopsUp() {
        BrowserUtils.waitForVisibility(salesforcePage.coPilotIcon, 15);
        BrowserUtils.waitFor(15);
        salesforcePage.coPilotIcon.click();

    }


    @When("user enters the Kodif Copilot username and password")
    public void user_enters_the_kodif_copilot_username_and_password() {
        if (url.contains("Zendesk")) {
            BrowserUtils.waitForClickablility(zendeskPage.coPilotUserName,15);
            zendeskPage.coPilotUserName.sendKeys(ConfigurationReader.getProperty("coPilotUserName"));
            zendeskPage.coPilotPassword.sendKeys(ConfigurationReader.getProperty("coPilotPassword"));
        }
    }


    @Then("user clicks on Kodif Copilot login button")
    public void user_clicks_on_kodif_copilot_login_button() {
        if (url.contains("Zendesk")) {
            BrowserUtils.waitForClickablility(zendeskPage.coPilotLoginButton,15);
            zendeskPage.coPilotLoginButton.click();
            BrowserUtils.waitForVisibility(zendeskPage.coPilotFrame,15);
        }

    }




    @When("the user selects the maximize option the coPilot window should expand")
    public void theUserSelectsTheMaximizeOptionTheCoPilotWindowShouldExpand() {
        frameWidth1 = salesforcePage.coPilotFrame.getSize().getWidth();

        salesforcePage.maximizeBtn.click();
        frameWidth2 = salesforcePage.coPilotFrame.getSize().getWidth();

        assertTrue(frameWidth2 > frameWidth1);

    }

    @And("the user selects the minimize option the coPilot window should minimize")
    public void theUserSelectsTheMinimizeOptionTheCoPilotWindowShouldMinimizeToTheTaskbar() {

        salesforcePage.minimizeBtn.click();
        frameWidth1 = salesforcePage.coPilotFrame.getSize().getWidth();
        assertTrue(frameWidth2 > frameWidth1);
    }

    List<WebElement> elements;
    int optionIndex;

    @When("user clicks on command button he should see at least one element")
    public void userClicksOnCommandButtonHeShouldSeeAtLeastOneElement() {
        BrowserUtils.waitForClickablility(salesforcePage.commandButton, 10);
        salesforcePage.commandButton.click();
        elements = Driver.getDriver().findElements(By.xpath("//div[contains(@class,'kodif-menu-item')]"));
        System.out.println("elements.size() = " + elements.size());
        assertTrue(elements.size() >= 1);
        boolean containAskKb = false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().contains("/ask-kb")) {
                containAskKb = true;
                optionIndex = i;
                break;
            }
        }
        assertTrue(containAskKb);
    }

    @When("user enter a string in input field and press enter key")
    public void userEnterAStringInInputFieldAndPressEnterKey() {
        BrowserUtils.waitFor(15);
        salesforcePage.commandInput.sendKeys("I need help" + Keys.ENTER);

        Assert.assertFalse(salesforcePage.commandInput.isEnabled());
        //Assert.assertTrue(salesforcePage.InputRespond.getText().contains("Could you please provide me with more details about the issue you're facing or the assistance you need?"));
    }



    String firstPosition;
    String secondPosition;
    @When("the user clicks on Dock button")
    public void theUserClicksOnDockButton() {
        firstPosition = salesforcePage.DockBtn.getAttribute("class");
        salesforcePage.DockBtn.click();

    }

    @Then("the chatbot should be docked to the left side of the screen")
    public void theChatbotShouldBeDockedToTheLeftSideOfTheScreen() {
        secondPosition = salesforcePage.DockBtn.getAttribute("class");
        Assert.assertNotEquals(firstPosition,secondPosition);
    }

    @When("user refresh the page the chatbot should stay on the left side of the screen")
    public void userRefreshThePageTheChatbotShouldStayOnTheLeftSideOfTheScreen() {
        Driver.getDriver().navigate().refresh();
        secondPosition = salesforcePage.DockBtn.getAttribute("class");
        Assert.assertEquals(firstPosition,secondPosition);
    }

    @Then("the chatbot should be docked to the right side of the screen")
    public void theChatbotShouldBeDockedToTheRightSideOfTheScreen() {
        secondPosition = salesforcePage.DockBtn.getAttribute("class");
        Assert.assertEquals("chakra-button css-1k86uh7", secondPosition );
    }
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
        salesforcePage.ReloadBtn.click();
    }

    @Then("the chatbot should refresh its content")
    public void theChatbotShouldRefreshItsContent() {
        salesforcePage.ReloadDefaultContent.isDisplayed();
        Assert.assertTrue("Chatbot content is not displayed after refresh.", salesforcePage.ReloadDefaultContent.isDisplayed());
    }
}







