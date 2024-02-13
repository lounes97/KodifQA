package com.minted.pages;

import com.minted.utility.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesforcePage extends BasePage {

    public SalesforcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@data-test-id='kodif-dock-btn']" )
    public WebElement DockBtn;

    @FindBy(xpath = "//button[@data-test-id='kodif-reload-btn']" )
    public WebElement ReloadBtn;

    @FindBy(xpath = "//p[contains(text(),'KODIF’s AI Chat is your personal assistant')]" )
    public WebElement ReloadDefaultContent;

    @FindBy(xpath = "//button[@data-test-id='kodif-expand-btn']")
    public WebElement maximizeBtn;
    @FindBy(xpath = "//button[@data-test-id='kodif-minimize-btn']")
    public WebElement minimizeBtn;

    @FindBy(xpath = "//button[@data-test-id=\"kodif-commands-btn\"]")
    public WebElement commandButton;

    @FindBy(xpath = "//textarea[@data-test-id='kodif-text-command-input']")
    public WebElement commandInput;

    @FindBy(xpath = "(//input[@class='slds-input'])[1]")
    //@FindBy(xpath = "(//a[@title='Cases'])[1]")
    //@FindBy(xpath = "//button[@class='slds-button slds-button_neutral search-button slds-truncate hasSearchTerm hasSearchTerm hasSearchTerm hasSearchTerm hasSearchTerm hasSearchTerm']")
    public WebElement casesBox;

    @FindBy(xpath = "(//a[@title='05773602 | Case'])[1]")
    public WebElement caseNum;

    @FindBy(xpath = "//p[@class='chakra-text css-1k2so8']" )
    //@FindBy(xpath = "(//p[@class='chakra-text css-1k2so8'])[1]")
    public WebElement SuggestionText;

    @FindBy(xpath = "//div[@data-test-id='/suggestion']")
    public WebElement SuggestionAction;

    @FindBy(xpath = "(//div[@class='chakra-stack actions css-1grj073']//*[name()='svg'])[1]")
     //@FindBy(css = "svg.InsertIcon")
    public WebElement InsertBtn;

    @FindBy(xpath = "//div[@data-test-id='/disposition']")
    public WebElement DispositionAction;

    @FindBy(xpath = "(//p[@class='chakra-text css-1k2so8'])[1]")
    public WebElement DispositionText;

    @FindBy(xpath = "//div[@class='ql-editor slds-rich-text-area__content slds-text-color_weak slds-grow']/p")
    public WebElement SuggestionPostText;

    @FindBy(xpath = "//div[@data-aura-class='forcePageBlockItem forcePageBlockItemEdit']")
    public WebElement DispositionCaseUserName;

    @FindBy(xpath = "//div[@class='css-y1opvk']")
    public WebElement thinkingProcessIcon;

    @FindBy(xpath = "(//button[@class='chakra-button css-1dz6r2v'])[2]")
    public WebElement AllActionsInsertBtn;

    @FindBy(xpath = "//textarea[@role='textbox']")
    public WebElement textarea;

    @FindBy(xpath = "//div[@class='container  activeState']")
    public WebElement textContainerCaseNotes;

}
