package com.minted.pages;

import com.gargoylesoftware.htmlunit.Page;
import com.minted.utility.BrowserUtils;
import com.minted.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrustPage {

    public TrustPage() {
        PageFactory.initElements(Driver.getDriver(), this);


    }

    //@FindBy(xpath = "//input[@name='chat-box']")
    @FindBy(xpath = "//input[@placeholder='Tell us something...']")
    //@FindBy(css = "input[placeholder='Tell us something...']")
    public WebElement trustSearchBox;

    @FindBy(xpath = "//div[@class='makeStyles-submitBtn-21']")
    public WebElement submitBtn;

    //@FindBy(xpath = "//p[contains(text(),'Is there anything else I can assist you with?')]")
    //public WebElement anythingElseMsg;


    @FindBy(xpath = "//a[contains(text(),'here')]")
    public WebElement here;

    @FindBy(css = "svg[data-testid='RefreshIcon']")
    public WebElement refreshIcon;

    //@FindBy(css = "svg[data-testid='ThumbDownIcon']")
    @FindBy(xpath = "//*[@data-testid='ThumbDownIcon']")
    public WebElement thumbDownIcon;

    // @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[2]")
    //@FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[2]")
    // @FindBy(xpath = "//*[name()='path' and contains(@d,'M15 3H6c-.')]")
    @FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[2]")
    public WebElement redThumbDownIcon;

    //@FindBy(css = "svg[data-testid='ThumbUpIcon']")
    @FindBy(xpath = "//*[@data-testid='ThumbUpIcon']")
    public WebElement thumbUpIcon;

    // @FindBy(css = "span[class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root']:first-child")
    //@FindBy(xpath = "//*[name()='path' and contains(@d,'M1 21h4V9H')]")
    @FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[1]")
    public WebElement greenThumbUpIcon;

    @FindBy(xpath = "(//p[contains(@class,'MessageTime')])[2]")
    public WebElement sendMsgTime;

    @FindBy(xpath = "(//p[contains(@class,'MessageTime')])[3]")
    public WebElement responseMsgTime;

    @FindBy(css = "svg[data-testid='AttachFileIcon']")
    public WebElement attachFileIcon;

    @FindBy(css = "svg[data-testid='SentimentVerySatisfiedIcon']")
    public WebElement emojiBtn;

    @FindBy(css = "iframe[id='kodif-chat-widget']")
    public WebElement iframe;

    @FindBy(xpath = "//div/button[contains(text(),'Start a New Conversation')]")
    public WebElement newConversationBtn;

    @FindBy(xpath = "//div[@class='MuiBox-root css-1bkwata']")
    public WebElement sessionHasExpired;

    @FindBy(xpath = "(//div[@class='makeStyles-messageBubble-31 makeStyles-agentMessageBubble-32'])[2]")
    public WebElement defaultMsg2;

    @FindBy(xpath = "//div[contains(text(),'GIT COMMANDS.docx')]")
    public WebElement uploadedFile;
    @FindBy(xpath = "//div[contains(text(),'What is wallet')]")
    public WebElement uploadWalletText;

    @FindBy(css = "input[type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//div/p[contains(text(),'Please enter your email:')]")
    public WebElement agentTalkResponse;

    @FindBy(xpath = "//div/p[contains(text(),'The email')]")
    public WebElement wrongEmailResponse;

    @FindBy(xpath = "//div/p[contains(text(),'Please select your issue:')]")
    public WebElement posEmailResponse;

    @FindBy(xpath = "//button[text()='More']")
    public WebElement moreBtn;

    @FindBy(xpath = "//button[text()='Something else']")
    public WebElement somethingElseBtn;


    //@FindBy(xpath = "//button[contains(text(),'Other')]")
    //@FindBy(xpath = "//button[normalize-space()='Other']")
    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button:nth-child(2)")
    public WebElement otherBtn;

    @FindBy(xpath = "//div/p[contains(text(),'Please select sub-category:')]")
    public WebElement selectSubCategory;

    @FindBy(xpath = "//button[2]")
    //@FindBy(xpath = "//button[normalize-space()='General/ How To's/ Guides']")
    public WebElement subCategoryResponse;

    @FindBy(xpath = "//div/p[contains(text(),'Please provide any relevant details such as your OS, app version, transaction hash, wallet address, etc:')]")
    public WebElement SubCatMsg;

    //@FindBy(xpath = "//div/p[contains(text(),'It looks like you currently have an open ticket. Our support team will respond within 3-5 business days. Creating multiple tickets for a single issue may increase your wait time.')]")
    @FindBy(xpath = "//p[contains(text(),'It looks like you currently have an open ticket. O')]")
    public WebElement supportTeamResponse;

    @FindBy(xpath = "//div[@class='makeStyles-quickRepliesBoxContainerMini-13']")
    public WebElement boxContainer;

    @FindBy(xpath = "//div[contains(@class, 'bouncing-loader')]")
    public WebElement bouncingLouder;
}


