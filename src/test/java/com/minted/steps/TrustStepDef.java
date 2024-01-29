package com.minted.steps;

import com.minted.pages.TrustPage;
import com.minted.utility.BrowserUtils;
import com.minted.utility.Driver;

import com.mysql.cj.CoreSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.minted.utility.BrowserUtils.*;
import static org.junit.Assert.*;

public class TrustStepDef {
    private long questionSentTime;
    private long responseReceivedTime;
    private long timeDifference;

    TrustPage trustPage = new TrustPage();

    @Given("the user is on the TrustWallet chat interface")
    public void theUserIsOnTheTrustWalletChatInterface() {
        Driver.getDriver().switchTo().frame("kodif-chat-widget");
        trustPage.somethingElseBtn.click();
        waitForVisibility(trustPage.trustSearchBox, 20);
        trustPage.trustSearchBox.sendKeys("What is trust wallet?");
        trustPage.submitBtn.click();

    }

    @When("the user asks a question and receives a response with a link")
    public void theUserAsksAQuestionAndReceivesAResponseWithALink() {
//        waitForClickablility(trustPage.here, 25);
//        if (trustPage.here != null) trustPage.here.click();
    }

    @Then("the link provided should not be blank")
    public void thenTheLinkProvidedShouldNotBeBlank() {
//      assertNotNull("Link is null", trustPage.here);
        if (trustPage.here != null) {
            assertFalse("Link href is blank", trustPage.here.getAttribute("href").isEmpty());
            System.out.println("\n\n\n" + trustPage.here.getAttribute("href").toString() + "\n\n\n");
        }
    }

    @When("the user clicks the thumbs-up icon")
    public void theUserClicksTheThumbsUpIcon() {
        waitForClickablility(trustPage.thumbUpIcon, 25);
        trustPage.thumbUpIcon.click();
//        waitFor(15);
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
//        waitFor(15);
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
//        waitFor(15);
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

    @Given("the user is on the chat interface")
    public void theUserIsOnTheChatInterface() {
    }

    @When("the user clicks the attachment button")
    public void theUserClicksTheAttachmentButton() {
        waitForVisibility(trustPage.attachFileIcon, 15);
        trustPage.attachFileIcon.click();
        waitFor(15);
    }

    @Then("a file attachment dialog should appear")
    public void aFileAttachmentDialogShouldAppear() {
    }

    @When("the user clicks the emoji button")
    public void theUserClicksTheEmojiButton() {
        waitForVisibility(trustPage.emojiBtn, 15);
        trustPage.emojiBtn.click();
        waitFor(15);
    }

    @Then("an emoji selection dialog should appear")
    public void anEmojiSelectionDialogShouldAppear() {
    }

    String path;
    String fileName;

    @When("the user selects a .docx file to attach")
    public void theUserSelectsAFileToAttach() throws AWTException {

        // path = "/Users/adilyadanil/IdeaProjects/KodifQAOwn/attachments/What is wallet.docx";
        path = System.getProperty("user.dir") + File.separator + "attachments" + File.separator + "Attachment.docx";

        int i = path.lastIndexOf(File.separator);
        int j = path.lastIndexOf(".");
        fileName = path.substring(i + 1, j);
        StringSelection str = new StringSelection(path);

        WebElement fileInput = Driver.getDriver().findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(path);
//
//        Robot robot = new Robot();
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//
//        // cmd + tab is needed since it launches a java app and the browser looses focus
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(500);
//
//        //open goto window
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(500);
//
//        //paste the clipboard value
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.delay(500);
//
//        //Press Enter key twice to close the Goto window and Upload window
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.delay(500);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @Then("file is successfully attached")
    public void fileIsSuccessfullyAttached() {
        WebElement attachedDoc = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'" + fileName + "')]"));
        assertTrue(attachedDoc.isDisplayed());


    }

    @When("the user ask to talk with agent and use wrong email")
    public void theUserAskToTalkWithAgentAndUseWrongEmail() {
        trustPage.trustSearchBox.sendKeys("talk agent" + Keys.ENTER);
        assertTrue(trustPage.agentTalkResponse.isDisplayed());
        trustPage.trustSearchBox.sendKeys("11.com@" + Keys.ENTER);
    }

    @Then("the chatbot will ask for correct email")
    public void theChatbotWillAskForCorrectEmail() {
        assertTrue(trustPage.wrongEmailResponse.isDisplayed());
    }

    @When("the user ask to talk with agent and use correct email")
    public void theUserAskToTalkWithAgentAndUseCorrectEmail() {
        trustPage.trustSearchBox.sendKeys("talk agent" + Keys.ENTER);
        BrowserUtils.waitFor(10);
        waitForInvisibilityOf(trustPage.bouncingLouder, 20);
        trustPage.trustSearchBox.sendKeys("kodif@test1.com" + Keys.ENTER);
        waitForInvisibilityOf(trustPage.bouncingLouder, 20);
    }

    @And("the chatbot will ask to select the issue and provide More, Other option buttons")
    public void theChatbotWillAskToSelectTheIssueAndProvideMoreOtherOptionButtons() {

        BrowserUtils.waitFor(15);
        trustPage.moreBtn.click();
        waitForInvisibilityOf(trustPage.bouncingLouder, 20);
    }

    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));

    @And("user clicks Other option")
    public void userClicksOtherOption() {
        executor.executeScript("arguments[0].scrollIntoView(true);", trustPage.otherBtn);
        BrowserUtils.waitForVisibility(trustPage.otherBtn, 15);
        executor.executeScript("arguments[0].click();", trustPage.otherBtn);
        BrowserUtils.waitForVisibility(trustPage.otherBtn, 25);
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
        BrowserUtils.waitFor(30);
        BrowserUtils.waitForVisibility(trustPage.bouncingLouder, 20);
        BrowserUtils.waitForInvisibilityOf(trustPage.bouncingLouder, 45);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Tell us something...']")));
        BrowserUtils.waitForClickablility(trustPage.trustSearchBox, 25);
        BrowserUtils.waitForVisibility(trustPage.trustSearchBox, 20);
        executor.executeScript("arguments[0].value = arguments[1];", trustPage.trustSearchBox, "This is a test of the ticketing system by Kodif for trustwallet. Please Ignore");
        executor.executeScript("arguments[0].dispatchEvent(new Event('keydown', { 'key': 'Enter' }))", trustPage.trustSearchBox);
        waitForInvisibilityOf(trustPage.bouncingLouder, 20);


//        executor.executeScript("arguments[0].scrollIntoView(true);", trustPage.subCategoryResponse);
//        BrowserUtils.waitForVisibility(trustPage.subCategoryResponse, 15);
//        executor.executeScript("arguments[0].click();", trustPage.subCategoryResponse);
//        waitForClickablility(trustPage.subCategoryResponse,25);
//        trustPage.subCategoryResponse.click();
//        BrowserUtils.waitFor(15);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("input[placeholder='Tell us something...']")));
//        trustPage.trustSearchBox.sendKeys("This is a test of the ticketing system by Kodif for trustwallet. Please Ignore" + Keys.ENTER);
//        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
//        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshotFile, new File("/path/to/screenshot.png"));
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


