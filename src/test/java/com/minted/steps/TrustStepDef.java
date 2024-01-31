package com.minted.steps;

import com.minted.pages.TrustPage;
import com.minted.utility.BrowserUtils;
import com.minted.utility.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static com.minted.utility.BrowserUtils.*;
import static org.junit.Assert.*;

public class TrustStepDef {
    private long questionSentTime;
    private long responseReceivedTime;
    private long timeDifference;

    TrustPage trustPage = new TrustPage();

    @Given("the user is on the TrustWallet chat interface and the user clicks on the <Something Else> button")
    public void the_user_is_on_the_trust_wallet_chat_interface_and_the_user_clicks_on_the_something_else_button() {
        Driver.getDriver().switchTo().frame("kodif-chat-widget");
        trustPage.somethingElseBtn.click();
    }

    @When("the user asks a question and receives a response with a link")
    public void theUserAsksAQuestionAndReceivesAResponseWithALink() {
        waitForClickablility(trustPage.trustSearchBox, 20);
        trustPage.trustSearchBox.sendKeys("What is trust wallet?");
        trustPage.submitBtn.click();
    }

    @Then("the link provided should not be blank")
    public void thenTheLinkProvidedShouldNotBeBlank() {
        waitForClickablility(trustPage.here, 25);
//        Add trust wallet scenario after consulting with feature owners
//        Will there always be a link?  and what should we check for when we open the link?
//        if (trustPage.here != null) trustPage.here.click();
        assertNotNull("Link is null", trustPage.here);
        assertFalse("Link href is blank", trustPage.here.getAttribute("href").isEmpty());
        System.out.println("\n\n\n" + trustPage.here.getAttribute("href").toString() + "\n\n\n");
    }

    @When("the user clicks the thumbs-up icon")
    public void theUserClicksTheThumbsUpIcon() {
        waitForClickablility(trustPage.thumbUpIcon, 25);
        trustPage.thumbUpIcon.click();
        waitFor(15);
    }

    @Then("the thumbs-up icon should change color to green")
    public void theThumbsUpIconShouldChangeColorToGreen() {
        WebElement regularThumbUpIcon = trustPage.thumbUpIcon;
        waitForVisibility(trustPage.greenThumbUpIcon, 25);
        WebElement greenThumbUpIcon = trustPage.greenThumbUpIcon;
        String regularIconColor = regularThumbUpIcon.getCssValue("color");
        String greenIconColor = greenThumbUpIcon.getCssValue("color");
        assertNotEquals(regularIconColor, greenIconColor);
    }

    @And("the thumbs-down icon should remain unchanged")
    public void theThumbsDownIconShouldRemainUnchanged() {
        waitForVisibility(trustPage.redThumbDownIcon, 25);
        WebElement regularThumbDownIcon = trustPage.thumbDownIcon;
        WebElement redThumbDownIcon = trustPage.redThumbDownIcon;
        String regularIconColor = regularThumbDownIcon.getCssValue("color");
        String notRedIconColor = redThumbDownIcon.getCssValue("color");
        assertEquals(regularIconColor, notRedIconColor);
    }

    @When("the user clicks the thumbs-down icon")
    public void theUserClicksTheThumbsDownIcon() {
        WebElement regularThumbDownIcon = trustPage.thumbDownIcon;
        regularThumbDownIcon.click();
        waitFor(15);
    }

    @Then("the thumbs-down icon should change color to red")
    public void theThumbsDownIconShouldChangeColorToRed() {
        waitForVisibility(trustPage.redThumbDownIcon, 25);
        WebElement redThumbDownIcon = trustPage.redThumbDownIcon;
        WebElement regularThumbDownIcon = trustPage.thumbDownIcon;
        String regularIconColor = regularThumbDownIcon.getCssValue("color");
        String redIconColor = redThumbDownIcon.getCssValue("color");
        assertNotEquals(regularIconColor, redIconColor);
        System.out.println("***\n\n\n" + regularIconColor + "\n\n\n" + redIconColor + "\n\n\n***");
    }

    @And("the thumbs-up icon should remain unchanged")
    public void theThumbsUpIconShouldRemainUnchanged() {
        waitForVisibility(trustPage.greenThumbUpIcon, 25);
        WebElement regularThumbUpIcon = trustPage.thumbUpIcon;
        WebElement greenThumbUpIcon = trustPage.greenThumbUpIcon;
        String regularIconColor = regularThumbUpIcon.getCssValue("color");
        String notGreenIconColor = greenThumbUpIcon.getCssValue("color");
        assertEquals(regularIconColor, notGreenIconColor);
    }


    @When("the user clicks the refresh button")
    public void theUserClicksTheRefreshButton() {
        waitForClickablility(trustPage.refreshIcon, 25);
        trustPage.refreshIcon.click();
        waitFor(15);
    }

    @Then("the chat interface should reload and clear the previous response")
    public void theChatInterfaceShouldReloadAndClearThePreviousResponse() {
    }

    @Then("check for the presence of the default message")
    public void checkForThePresenceOfTheDefaultMessage() {
        waitForVisibility(trustPage.defaultMsg2, 25);
        assertTrue("***\n\n\nDefault message is not present after refreshing the chat interface\n\n\n***", trustPage.defaultMsg2.isDisplayed());
    }

    @When("the user records the time the question was sent")
    public void theUserRecordsTheTimeTheQuestionWasSent() {
        // Record the current time when the question is sent
        questionSentTime = System.currentTimeMillis();

    }

    @And("records the time the response was received")
    public void recordsTheTimeTheResponseWasReceived() {
        // Record the current time when the response is received
        responseReceivedTime = System.currentTimeMillis();
    }

    @Then("the time difference between sending and receiving should be calculated")
    public void theTimeDifferenceBetweenSendingAndReceivingShouldBeCalculated() {
        // Calculate the time difference between sending and receiving
        timeDifference = responseReceivedTime - questionSentTime;
        System.out.println("\n\n\n****timeDifference  = " + timeDifference + "\n\n\n***");
        String times = trustPage.sendMsgTime.getText();

    }


    @And("the calculated time difference should be within an acceptable threshold")
    public void theCalculatedTimeDifferenceShouldBeWithinAnAcceptableThreshold() {
        long acceptableThreshold = 25000;

        if (timeDifference > acceptableThreshold) {
            throw new AssertionError("Time difference exceeds the acceptable threshold.");

        }
    }

    @When("the user clicks the emoji button")
    public void theUserClicksTheEmojiButton() {
        waitForInvisibilityOf(trustPage.bouncingLouder, 20);
        waitForClickablility(trustPage.emojiBtn, 15);
        trustPage.emojiBtn.click();
    }

    @Then("an emoji selection dialog should appear")
    public void anEmojiSelectionDialogShouldAppear() {
    }

    @When("the user ask to talk with agent and use wrong email")
    public void theUserAskToTalkWithAgentAndUseWrongEmail() {
        // Have to ask for an agent twice before AI asks to enter email
        waitForClickablility(trustPage.trustSearchBox, 30);
        trustPage.trustSearchBox.sendKeys("talk agent" + Keys.ENTER);
        waitForClickablility(trustPage.trustSearchBox, 30);
        trustPage.trustSearchBox.sendKeys("talk agent" + Keys.ENTER);
        waitForClickablility(trustPage.trustSearchBox, 30);
        assertTrue(trustPage.agentTalkResponse.isDisplayed());
        trustPage.trustSearchBox.sendKeys("11.com@" + Keys.ENTER);
    }

    @Then("the chatbot will ask for correct email")
    public void theChatbotWillAskForCorrectEmail() {
        waitForVisibility(trustPage.wrongEmailResponse, 30);
        assertTrue(trustPage.wrongEmailResponse.isDisplayed());
    }

    @When("the user ask to talk with agent and use correct email")
    public void theUserAskToTalkWithAgentAndUseCorrectEmail() {
        // Have to ask for an agent twice before AI asks to enter email
        waitForClickablility(trustPage.trustSearchBox, 30);
        trustPage.trustSearchBox.sendKeys("talk agent" + Keys.ENTER);
        waitForClickablility(trustPage.trustSearchBox, 30);
        trustPage.trustSearchBox.sendKeys("talk agent" + Keys.ENTER);
        waitForClickablility(trustPage.trustSearchBox, 30);
        assertTrue(trustPage.agentTalkResponse.isDisplayed());
        trustPage.trustSearchBox.sendKeys("kodif@test1.com" + Keys.ENTER);
        waitForVisibility(trustPage.bouncingLouder, 20);
        waitForInvisibilityOf(trustPage.bouncingLouder, 45);
    }

    @And("the chatbot will ask to select the issue and provide More, Other option buttons")
    public void theChatbotWillAskToSelectTheIssueAndProvideMoreOtherOptionButtons() {
        trustPage.moreBtn.click();
        waitForVisibility(trustPage.bouncingLouder, 20);
        waitForInvisibilityOf(trustPage.bouncingLouder, 45);
    }

    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));

    @And("user clicks Other option")
    public void userClicksOtherOption() {
        executor.executeScript("arguments[0].scrollIntoView(true);", trustPage.otherBtn);
        waitForClickablility(trustPage.otherBtn, 15);
        executor.executeScript("arguments[0].click();", trustPage.otherBtn);
        waitForClickablility(trustPage.otherBtn, 25);
        trustPage.otherBtn.click();

    }

    @And("user selects sub-category issue and provide more detail")
    public void userSelectsSubCategoryIssueAndProvideMoreDetail() throws IOException {
        executor.executeScript("arguments[0].scrollIntoView(true);", trustPage.subCategoryResponse);
// Wait for the element to become visible using JavaScript
        executor.executeScript("arguments[0].style.display = 'block';", trustPage.subCategoryResponse);
// Wait for the element to become clickable using JavaScript
        executor.executeScript("arguments[0].setAttribute('clickable', 'true');", trustPage.subCategoryResponse);

// Click the element using JavaScript
        executor.executeScript("arguments[0].click();", trustPage.subCategoryResponse);
        waitForVisibility(trustPage.bouncingLouder, 20);
        waitForInvisibilityOf(trustPage.bouncingLouder, 45);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Tell us something...']")));
        waitForClickablility(trustPage.trustSearchBox, 25);
        waitForVisibility(trustPage.trustSearchBox, 20);
        trustPage.trustSearchBox.sendKeys("This is a test of the ticketing system by Kodif for trustwallet. Please Ignore" + Keys.ENTER);
        waitForVisibility(trustPage.bouncingLouder, 20);
        waitForInvisibilityOf(trustPage.bouncingLouder, 45);
    }

    @Then("user select yes or no and the conversation will end")
    public void userSelectYesOrNoAndTheConversationWillEnd() throws IOException {
            // Locate the element using XPath
            WebElement supportTeamResponse = null;
            try {
                supportTeamResponse = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'It looks like you currently have an open ticket. O')]"));
            } catch (NoSuchElementException e) {
                // Handle the case where the element is not found
                // You can add appropriate error handling here
            }

            // Scroll to the element if it's present and displayed
            if (supportTeamResponse != null && supportTeamResponse.isDisplayed()) {
                executor.executeScript("arguments[0].scrollIntoView(true);", supportTeamResponse);
            }

            // Wait for a certain duration (10 seconds in this case)
            BrowserUtils.waitFor(10);

            // You can add further verification/assertion here if needed
            // For example, you can check if the element is displayed or not
            if (supportTeamResponse != null) {
                boolean isDisplayed = (Boolean) executor.executeScript("return arguments[0].style.display !== 'none'", supportTeamResponse);
                Assert.assertTrue("Support Team Response is not displayed", isDisplayed);
            }
        }

    }


