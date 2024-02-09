package com.minted.pages;

import com.minted.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@class='input r4 wide mb16 mt8 username']" )
    public WebElement username;

    @FindBy(xpath = "//input[@class='input r4 wide mb16 mt8 password']")
    public WebElement password;

    @FindBy(xpath = "//input[@class='button r4 wide primary']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='kodif-extension-root']//button[@type='button']")
    //@FindBy(xpath = "//button[@class='chakra-button react-draggable css-1746jid']")
    public WebElement coPilotIcon;

    @FindBy(xpath = "//p[@data-test-id='kodif-intro-msg']")
    public WebElement ticketSwitchDefaultText;

    @FindBy(xpath = "(//input[@placeholder='Email'])")
    public WebElement coPilotUserName;

    @FindBy(xpath = "(//input[@placeholder='Password'])")
    public WebElement coPilotPassword;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public WebElement coPilotLoginButton;

    @FindBy(xpath = "//div[@class='chakra-stack App css-11sckxr']" )
    public WebElement coPilotFrame;
}
